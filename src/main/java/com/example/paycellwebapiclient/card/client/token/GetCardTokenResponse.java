package com.example.paycellwebapiclient.card.client.token;

import com.turkcelltech.mf.tpay.web.provision.ResponseHeader;

public class GetCardTokenResponse {

  private ResponseHeader header;

  private String cardToken;

  private String hashData;

  public ResponseHeader getHeader() {
    return header;
  }

  public void setHeader(ResponseHeader header) {
    this.header = header;
  }

  public String getCardToken() {
    return cardToken;
  }

  public void setCardToken(String cardToken) {
    this.cardToken = cardToken;
  }

  public String getHashData() {
    return hashData;
  }

  public void setHashData(String hashData) {
    this.hashData = hashData;
  }



}
