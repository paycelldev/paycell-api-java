package com.example.paycellwebapiclient.ui.payment.refund;

public class RefundViewDto implements RefundListener {

  private String originalReferenceNumber;

  private String amount;

  private String pointAmount;

  private String referenceNumber;

  private RefundListener refundListener;

  public RefundViewDto(RefundListener refundListener) {
    this.refundListener = refundListener;
  }

  @Override
  public void refund() {
    if (refundListener != null) {
      refundListener.refund();
    }
  }

  public String getOriginalReferenceNumber() {
    return originalReferenceNumber;
  }

  public void setOriginalReferenceNumber(String originalReferenceNumber) {
    this.originalReferenceNumber = originalReferenceNumber;
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

  public String getReferenceNumber() {
    return referenceNumber;
  }

  public void setReferenceNumber(String referenceNumber) {
    this.referenceNumber = referenceNumber;
  }



}
