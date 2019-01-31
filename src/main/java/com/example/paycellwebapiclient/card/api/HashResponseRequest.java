package com.example.paycellwebapiclient.card.api;

public class HashResponseRequest {
  private String transactionId;
  private String responseDateTime;
  private String responseCode;
  private String cardToken;

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public String getResponseDateTime() {
    return responseDateTime;
  }

  public void setResponseDateTime(String responseDateTime) {
    this.responseDateTime = responseDateTime;
  }

  public String getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(String responseCode) {
    this.responseCode = responseCode;
  }

  public String getCardToken() {
    return cardToken;
  }

  public void setCardToken(String cardToken) {
    this.cardToken = cardToken;
  }
}
