package com.example.paycellwebapiclient.domain.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.card.client.delete.DeleteCardClient;
import com.example.paycellwebapiclient.card.client.delete.DeleteCardRequestFactory;
import com.example.paycellwebapiclient.card.client.register.RegisterCardClient;
import com.example.paycellwebapiclient.card.client.register.RegisterCardRequestFactory;
import com.example.paycellwebapiclient.card.client.update.UpdateCardClient;
import com.example.paycellwebapiclient.card.client.update.UpdateCardRequestFactory;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.turkcelltech.mf.tpay.web.provision.DeleteCardRequest;
import com.turkcelltech.mf.tpay.web.provision.DeleteCardResponse;
import com.turkcelltech.mf.tpay.web.provision.RegisterCardRequest;
import com.turkcelltech.mf.tpay.web.provision.RegisterCardResponse;
import com.turkcelltech.mf.tpay.web.provision.UpdateCardRequest;
import com.turkcelltech.mf.tpay.web.provision.UpdateCardResponse;

@Component
@Scope("prototype")
public class Card {

  @Autowired
  private RegisterCardClient registerCardClient;

  @Autowired
  private DeleteCardClient deleteCardClient;

  @Autowired
  private UpdateCardClient updateCardClient;

  private String cardId;

  private String cardToken;

  private String alias;

  private String creditCardNo;

  private String maskedCardNo;

  private String cardBrand;

  private String expireDateMonth;

  private String expireDateYear;

  private String cvcNo;

  private Boolean isDefault;

  private Boolean isExpired;

  private Boolean showEulaId;

  private Boolean isThreeDValidated;

  private Boolean isOTPValidated;

  private String activationDate;

  public String save(String clientIPAddress, String msisdn,
      String eulaId, ConnectionMethod connectionMethod) throws Exception {
    RegisterCardRequestFactory factory = new RegisterCardRequestFactory();
    factory.setClientIPAddress(clientIPAddress);
    factory.setMsisdn(msisdn);
    factory.setAlias(alias);
    factory.setIsDefault(isDefault);
    factory.setCardToken(cardToken);
    factory.setEulaId(eulaId);
    RegisterCardRequest request = factory.build();

    RegisterCardResponse response =
        registerCardClient.registerCard(request, connectionMethod);
    if (response.getResponseHeader().getResponseCode()
        .contentEquals(PaycellWebApiConstants.SUCCESS_CODE)) {
      cardId = response.getCardId();
      return cardId;
    } else {
      throw new Exception(
          "Bad Request: " + response.getResponseHeader().getResponseDescription());
    }
  }

  public void delete(String clientIPAddress, String msisdn,
      ConnectionMethod connectionMethod) throws Exception {
    DeleteCardRequest request;
    try {
      DeleteCardRequestFactory factory = new DeleteCardRequestFactory();
      factory.setClientIPAddress(clientIPAddress);
      factory.setCardId(cardId);
      factory.setMsisdn(msisdn);
      request = factory.build();
    } catch (Exception e) {
      throw e;
    }
    try {
      DeleteCardResponse response =
          deleteCardClient.deleteCard(request, connectionMethod);
      if (!response.getResponseHeader().getResponseCode()
          .contentEquals(PaycellWebApiConstants.SUCCESS_CODE)) {
        throw new Exception(
            "Bad Request: " + response.getResponseHeader().getResponseDescription());
      }
    } catch (Exception e) {
      throw new Exception("Service is not responding.", e);
    }
  }

  public void update(String clientIPAddress, String msisdn,
      String eulaId, ConnectionMethod connectionMethod) throws Exception {
    UpdateCardRequestFactory factory = new UpdateCardRequestFactory();
    factory.setClientIPAddress(clientIPAddress);
    factory.setMsisdn(msisdn);
    factory.setCardId(cardId);
    factory.setAlias(alias);
    factory.setIsDefault(isDefault);
    factory.setEulaId(eulaId);
    UpdateCardRequest request = factory.build();

    UpdateCardResponse response = updateCardClient.updateCard(request, connectionMethod);
    if (!response.getResponseHeader().getResponseCode()
        .contentEquals(PaycellWebApiConstants.SUCCESS_CODE)) {
      throw new Exception(
          "Bad Request: " + response.getResponseHeader().getResponseDescription());
    }
  }

  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
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

  public void setCardToken(String cardToken) {
    this.cardToken = cardToken;
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

  public Boolean getIsExpired() {
    return isExpired;
  }

  public void setIsExpired(Boolean isExpired) {
    this.isExpired = isExpired;
  }

  public Boolean getShowEulaId() {
    return showEulaId;
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

  public String getCardToken() {
    return cardToken;
  }

}
