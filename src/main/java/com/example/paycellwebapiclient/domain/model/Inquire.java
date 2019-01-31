package com.example.paycellwebapiclient.domain.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.payment.client.inquire.InquireClient;
import com.example.paycellwebapiclient.payment.client.inquire.InquireRequestFactory;
import com.turkcelltech.mf.tpay.web.provision.InquireRequest;
import com.turkcelltech.mf.tpay.web.provision.InquireResponse;

@Component
@Scope("prototype")
public class Inquire {

  @Autowired
  private InquireClient inquireClient;

  @Autowired
  private WebApplicationContext webApplicationContext;

  private String originalReferenceNumber;

  private String msisdn;

  private String orderId;

  private String acquirerBankCode;

  private String status;

  private List<Provision> provisionList;

  public void inquire(String clientIPAddress, ConnectionMethod connectionMethod)
      throws Exception {
    InquireRequestFactory factory = new InquireRequestFactory();
    factory.setMsisdn(msisdn);
    factory.setOriginalReferenceNumber(originalReferenceNumber);
    factory.setClientIPAddress(clientIPAddress);
    InquireRequest request = factory.build();

    InquireResponse response = inquireClient.inquire(request, connectionMethod);
    if (response.getResponseHeader().getResponseCode()
        .contentEquals(PaycellWebApiConstants.SUCCESS_CODE)) {
      BeanUtils.copyProperties(response, this, "provisionList");
      provisionList = new ArrayList<>();
      for (com.turkcelltech.mf.tpay.web.provision.Provision provisionItem : response
          .getProvisionList()) {
        Provision provision = webApplicationContext.getBean(Provision.class);
        BeanUtils.copyProperties(provisionItem, provision);
        provisionList.add(provision);
      }
    } else {
      throw new Exception(
          "Bad Request: " + response.getResponseHeader().getResponseDescription());
    }
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getAcquirerBankCode() {
    return acquirerBankCode;
  }

  public void setAcquirerBankCode(String acquirerBankCode) {
    this.acquirerBankCode = acquirerBankCode;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<Provision> getProvisionList() {
    return provisionList;
  }

  public void setProvisionList(List<Provision> provisionList) {
    this.provisionList = provisionList;
  }

  public String getOriginalReferenceNumber() {
    return originalReferenceNumber;
  }

  public void setOriginalReferenceNumber(String originalReferenceNumber) {
    this.originalReferenceNumber = originalReferenceNumber;
  }

  public String getMsisdn() {
    return msisdn;
  }

  public void setMsisdn(String msisdn) {
    this.msisdn = msisdn;
  }



}
