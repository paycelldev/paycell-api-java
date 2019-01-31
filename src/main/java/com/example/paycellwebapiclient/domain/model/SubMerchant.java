package com.example.paycellwebapiclient.domain.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SubMerchant {

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

}
