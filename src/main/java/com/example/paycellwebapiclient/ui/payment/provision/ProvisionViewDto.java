package com.example.paycellwebapiclient.ui.payment.provision;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProvisionViewDto implements ProvisionListener {

  private String referenceNumber;

  private String threeDSessionId;

  private String acquirerBankCode;

  private String amount;

  private String currency;

  private String installmentCount;

  private String paymentType;

  private String pin;

  private String pointAmount;

  private String transactionId;

  private String provisionType;

  private String approvalCode;

  private String dateTime;

  private String reconciliationDate;

  private String responseCode;

  private String responseDescription;

  @JsonIgnore
  private ProvisionListener provisionListener;

  public ProvisionViewDto(ProvisionListener provisionListener) {
    this.provisionListener = provisionListener;
  }

  @Override
  public void sendProvision() {
    if (provisionListener != null) {
      provisionListener.sendProvision();
    }
  }

  @Override
  public void sendProvisionThreeD() {
    if (provisionListener != null) {
      provisionListener.sendProvisionThreeD();
    }
  }

  @Override
  public void listenProvisionThreeD() {
    if (provisionListener != null) {
      provisionListener.listenProvisionThreeD();
    }
  }

  public String getReferenceNumber() {
    return referenceNumber;
  }

  public void setReferenceNumber(String referenceNumber) {
    this.referenceNumber = referenceNumber;
  }

  public String getThreeDSessionId() {
    return threeDSessionId;
  }

  public void setThreeDSessionId(String threeDSessionId) {
    this.threeDSessionId = threeDSessionId;
  }

  public String getAcquirerBankCode() {
    return acquirerBankCode;
  }

  public void setAcquirerBankCode(String acquirerBankCode) {
    this.acquirerBankCode = acquirerBankCode;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getInstallmentCount() {
    return installmentCount;
  }

  public void setInstallmentCount(String installmentCount) {
    this.installmentCount = installmentCount;
  }

  public String getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  public String getPointAmount() {
    return pointAmount;
  }

  public void setPointAmount(String pointAmount) {
    this.pointAmount = pointAmount;
  }

  public ProvisionListener getProvisionListener() {
    return provisionListener;
  }

  public void setProvisionListener(ProvisionListener provisionListener) {
    this.provisionListener = provisionListener;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public String getProvisionType() {
    return provisionType;
  }

  public void setProvisionType(String provisionType) {
    this.provisionType = provisionType;
  }

  public String getApprovalCode() {
    return approvalCode;
  }

  public void setApprovalCode(String approvalCode) {
    this.approvalCode = approvalCode;
  }

  public String getDateTime() {
    return dateTime;
  }

  public void setDateTime(String dateTime) {
    this.dateTime = dateTime;
  }

  public String getReconciliationDate() {
    return reconciliationDate;
  }

  public void setReconciliationDate(String reconciliationDate) {
    this.reconciliationDate = reconciliationDate;
  }

  public String getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(String responseCode) {
    this.responseCode = responseCode;
  }

  public String getResponseDescription() {
    return responseDescription;
  }

  public void setResponseDescription(String responseDescription) {
    this.responseDescription = responseDescription;
  }

}
