package com.example.paycellwebapiclient.ui.card.register;

public class CardRegisterViewDto implements CardRegisterListener {

  private String alias;

  private String creditCardNo;

  private String expireDate;

  private String cvcNo;

  private Boolean isDefault;

  private String threeDSessionId;

  private String cardToken;

  private CardRegisterListener cardRegisterListener;

  public CardRegisterViewDto(CardRegisterListener cardRegisterListener) {
    this.cardRegisterListener = cardRegisterListener;
  }

  @Override
  public void registerCard() {
    if (cardRegisterListener != null) {
      cardRegisterListener.registerCard();
    }
  }

  @Override
  public void registerCardThreeD() {
    if (cardRegisterListener != null) {
      cardRegisterListener.registerCardThreeD();
    }
  }

  @Override
  public void listenRegisterCardTreeD() {
    if (cardRegisterListener != null) {
      cardRegisterListener.listenRegisterCardTreeD();
    }
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public String getCreditCardNo() {
    return creditCardNo;
  }

  public void setCreditCardNo(String creditCardNo) {
    this.creditCardNo = creditCardNo;
  }

  public String getExpireDate() {
    return expireDate;
  }

  public void setExpireDate(String expireDate) {
    this.expireDate = expireDate;
  }

  public String getCvcNo() {
    return cvcNo;
  }

  public void setCvcNo(String cvcNo) {
    this.cvcNo = cvcNo;
  }

  public Boolean getIsDefault() {
    return isDefault;
  }

  public void setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
  }

  public String getThreeDSessionId() {
    return threeDSessionId;
  }

  public void setThreeDSessionId(String threeDSessionId) {
    this.threeDSessionId = threeDSessionId;
  }

  public String getCardToken() {
    return cardToken;
  }

  public void setCardToken(String cardToken) {
    this.cardToken = cardToken;
  }

}
