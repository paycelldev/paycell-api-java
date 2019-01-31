package com.example.paycellwebapiclient.domain.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.payment.client.reverse.ReverseClient;
import com.example.paycellwebapiclient.payment.client.reverse.ReverseRequestFactory;
import com.turkcelltech.mf.tpay.web.provision.ReverseRequest;
import com.turkcelltech.mf.tpay.web.provision.ReverseResponse;

@Component
@Scope("prototype")
public class Reverse {

  @Autowired
  private ReverseClient reverseClient;

  private String originalReferenceNumber;

  private String referenceNumber;

  public String reverse(String clientIPAddress, String msisdn, ConnectionMethod connectionMethod) throws Exception {
    ReverseRequest request;
    try {
      ReverseRequestFactory factory = new ReverseRequestFactory();
      factory.setClientIPAddress(clientIPAddress);
      factory.setMsisdn(msisdn);
      factory.setOriginalReferenceNumber(originalReferenceNumber);
      request = factory.build();
    } catch (Exception e) {
      throw e;
    }
    try {
      ReverseResponse response = reverseClient.reverse(request, connectionMethod);
      if (response.getResponseHeader().getResponseCode()
          .contentEquals(PaycellWebApiConstants.SUCCESS_CODE)) {
        setReferenceNumber(request.getReferenceNumber());
        return response.getApprovalCode();
      } else {
        throw new Exception(
            "Bad Request: " + response.getResponseHeader().getResponseDescription());
      }
    } catch (Exception e) {
      throw new Exception("Service is not responding.", e);
    }
  }

  public String getOriginalReferenceNumber() {
    return originalReferenceNumber;
  }

  public void setOriginalReferenceNumber(String originalReferenceNumber) {
    this.originalReferenceNumber = originalReferenceNumber;
  }

  public String getReferenceNumber() {
    return referenceNumber;
  }

  public void setReferenceNumber(String referenceNumber) {
    this.referenceNumber = referenceNumber;
  }



}
