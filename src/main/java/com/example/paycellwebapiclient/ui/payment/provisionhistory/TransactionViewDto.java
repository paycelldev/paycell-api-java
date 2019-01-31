package com.example.paycellwebapiclient.ui.payment.provisionhistory;

public class TransactionViewDto {

  private String transactionDateTime;

  private String orderId;

  private String acquirerBankCode;

  private String approvalCode;

  private String issuerBankCode;

  private String amount;

  private String netAmount;

  private String referenceNumber;

  private String transactionId;

  private String transactionParams;

  public String getTransactionDateTime() {
    return transactionDateTime;
  }

  public void setTransactionDateTime(String transactionDateTime) {
    this.transactionDateTime = transactionDateTime;
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

  public String getApprovalCode() {
    return approvalCode;
  }

  public void setApprovalCode(String approvalCode) {
    this.approvalCode = approvalCode;
  }

  public String getIssuerBankCode() {
    return issuerBankCode;
  }

  public void setIssuerBankCode(String issuerBankCode) {
    this.issuerBankCode = issuerBankCode;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getNetAmount() {
    return netAmount;
  }

  public void setNetAmount(String netAmount) {
    this.netAmount = netAmount;
  }

  public String getReferenceNumber() {
    return referenceNumber;
  }

  public void setReferenceNumber(String referenceNumber) {
    this.referenceNumber = referenceNumber;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public String getTransactionParams() {
    return transactionParams;
  }

  public void setTransactionParams(String transactionParams) {
    this.transactionParams = transactionParams;
  }



}
