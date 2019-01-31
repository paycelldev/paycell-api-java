package com.example.paycellwebapiclient.ui.payment.reverse;

public class ReverseViewDto implements ReverseListener {

  private String originalReferenceNumber;

  private String referenceNumber;

  private ReverseListener reverseListener;

  public ReverseViewDto(ReverseListener reverseListener) {
    this.reverseListener = reverseListener;
  }

  @Override
  public void reverse() {
    if (reverseListener != null) {
      reverseListener.reverse();
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
