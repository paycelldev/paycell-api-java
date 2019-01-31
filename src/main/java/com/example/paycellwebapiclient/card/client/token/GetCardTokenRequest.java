package com.example.paycellwebapiclient.card.client.token;

public class GetCardTokenRequest {

  private RequestHeader header;

  private String creditCardNo;

  private String expireDateMonth;

  private String expireDateYear;

  private String cvcNo;

  private String hashData;

  public RequestHeader getHeader() {
    return header;
  }

  public void setHeader(RequestHeader header) {
    this.header = header;
  }

  public String getCreditCardNo() {
    return creditCardNo;
  }

  public void setCreditCardNo(String creditCardNo) {
    this.creditCardNo = creditCardNo;
  }

  public String getExpireDateMonth() {
    return expireDateMonth;
  }

  public void setExpireDateMonth(String expireDateMonth) {
    this.expireDateMonth = expireDateMonth;
  }

  public String getExpireDateYear() {
    return expireDateYear;
  }

  public void setExpireDateYear(String expireDateYear) {
    this.expireDateYear = expireDateYear;
  }

  public String getCvcNo() {
    return cvcNo;
  }

  public void setCvcNo(String cvcNo) {
    this.cvcNo = cvcNo;
  }

  public String getHashData() {
    return hashData;
  }

  public void setHashData(String hashData) {
    this.hashData = hashData;
  }



}
