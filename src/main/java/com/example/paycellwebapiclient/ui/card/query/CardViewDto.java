package com.example.paycellwebapiclient.ui.card.query;

public class CardViewDto {

  private Boolean editMode;

  private String cardId;

  private String cardToken;

  private String alias;

  private String creditCardNo;

  private String maskedCardNo;

  private String cardBrand;

  private String expireDate;

  private String expireDateMonth;

  private String expireDateYear;

  private String cvcNo;

  private Boolean isDefault;

  private Boolean isExpired;

  private Boolean showEulaId;

  private Boolean isThreeDValidated;

  private Boolean isOTPValidated;

  private String activationDate;

  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }

  public String getCardToken() {
    return cardToken;
  }

  public void setCardToken(String cardToken) {
    this.cardToken = cardToken;
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

  public String getMaskedCardNo() {
    return maskedCardNo;
  }

  public void setMaskedCardNo(String maskedCardNo) {
    this.maskedCardNo = maskedCardNo;
  }

  public String getCardBrand() {
    return cardBrand;
  }

  public void setCardBrand(String cardBrand) {
    this.cardBrand = cardBrand;
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

  public Boolean getIsDefault() {
    return isDefault;
  }

  public void setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
  }

  public Boolean getIsExpired() {
    return isExpired;
  }

  public void setIsExpired(Boolean isExpired) {
    this.isExpired = isExpired;
  }

  public Boolean getShowEulaId() {
    return true;
  }

  public void setShowEulaId(Boolean showEulaId) {
    this.showEulaId = showEulaId;
  }

  public Boolean getIsThreeDValidated() {
    return isThreeDValidated;
  }

  public void setIsThreeDValidated(Boolean isThreeDValidated) {
    this.isThreeDValidated = isThreeDValidated;
  }

  public Boolean getIsOTPValidated() {
    return isOTPValidated;
  }

  public void setIsOTPValidated(Boolean isOTPValidated) {
    this.isOTPValidated = isOTPValidated;
  }

  public String getActivationDate() {
    return activationDate;
  }

  public void setActivationDate(String activationDate) {
    this.activationDate = activationDate;
  }

  public Boolean getEditMode() {
    return editMode;
  }

  public void setEditMode(Boolean editMode) {
    this.editMode = editMode;
  }

  public String getExpireDate() {
    if (expireDateMonth != null && expireDateYear != null) {
      expireDate = expireDateMonth + "/" + expireDateYear;
    }
    return expireDate;
  }

  public void setExpireDate(String expireDate) {
    if (expireDate != null && expireDate.matches("\\d{2}/\\d{2}")) {
      setExpireDateMonth(expireDate.substring(0, 2));
      setExpireDateYear(expireDate.substring(3, 5));
      this.expireDate = expireDate;
    } else {
      setExpireDateMonth(null);
      setExpireDateYear(null);
      this.expireDate = null;
    }
  }

}
