package com.example.paycellwebapiclient.ui.payment.provision;

public class SubMerchantViewDto {

  private String id;

  private String subMerchantKey;

  private String subMerchantPrice;

  public String getSubMerchantKey() {
    return subMerchantKey;
  }

  public void setSubMerchantKey(String subMerchantKey) {
    this.subMerchantKey = subMerchantKey;
  }

  public String getSubMerchantPrice() {
    return subMerchantPrice;
  }

  public void setSubMerchantPrice(String subMerchantPrice) {
    this.subMerchantPrice = subMerchantPrice;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

}
