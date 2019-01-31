package com.example.paycellwebapiclient.domain.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.payment.client.refund.RefundClient;
import com.example.paycellwebapiclient.payment.client.refund.RefundRequestFactory;
import com.turkcelltech.mf.tpay.web.provision.RefundRequest;
import com.turkcelltech.mf.tpay.web.provision.RefundResponse;

@Component
@Scope("prototype")
public class Refund {

  private String originalReferenceNumber;

  private String referenceNumber;

  private String amount;

  private String pointAmount;

  @Autowired
  private RefundClient refundClient;

  public String refund(String clientIPAddress, String msisdn, ConnectionMethod connectionMethod) throws Exception {
    RefundRequestFactory factory = new RefundRequestFactory();
    factory.setClientIPAddress(clientIPAddress);
    factory.setMsisdn(msisdn);
    factory.setOriginalReferenceNumber(originalReferenceNumber);
    factory.setAmount(amount);
    factory.setPointAmount(pointAmount);
    RefundRequest request = factory.build();

    RefundResponse response = refundClient.refund(request, connectionMethod);
    if (response.getResponseHeader().getResponseCode()
        .contentEquals(PaycellWebApiConstants.SUCCESS_CODE)) {
      setReferenceNumber(request.getReferenceNumber());
      return response.getApprovalCode();
    } else {
      throw new Exception(
          "Bad Request: " + response.getResponseHeader().getResponseDescription());
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

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getPointAmount() {
    return pointAmount;
  }

  public void setPointAmount(String pointAmount) {
    this.pointAmount = pointAmount;
  }



}
