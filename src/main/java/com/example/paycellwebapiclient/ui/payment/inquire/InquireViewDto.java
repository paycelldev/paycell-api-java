package com.example.paycellwebapiclient.ui.payment.inquire;

import java.util.ArrayList;
import java.util.List;
import com.example.paycellwebapiclient.ui.payment.provision.ProvisionViewDto;

public class InquireViewDto implements InquireListener {

  private String originalReferenceNumber;

  private String orderId;

  private String acquirerBankCode;

  private String status;

  private List<ProvisionViewDto> provisionList;

  private InquireListener inquireListener;

  public InquireViewDto(InquireListener inquireListener) {
    this.inquireListener = inquireListener;
    provisionList = new ArrayList<>();
  }

  @Override
  public void inquire() {
    if (inquireListener != null) {
      inquireListener.inquire();
    }
  }

  public String getOriginalReferenceNumber() {
    return originalReferenceNumber;
  }

  public void setOriginalReferenceNumber(String originalReferenceNumber) {
    this.originalReferenceNumber = originalReferenceNumber;
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

  public List<ProvisionViewDto> getProvisionList() {
    return provisionList;
  }

  public void setProvisionList(List<ProvisionViewDto> provisionList) {
    this.provisionList = provisionList;
  }

}
