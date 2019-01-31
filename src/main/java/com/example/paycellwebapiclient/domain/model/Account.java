package com.example.paycellwebapiclient.domain.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import com.example.paycellwebapiclient.card.client.query.GetCardsClient;
import com.example.paycellwebapiclient.card.client.query.GetCardsRequestFactory;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.threedsession.get.GetThreeDSessionRequestFactory;
import com.turkcelltech.mf.tpay.web.provision.GetCardsRequest;
import com.turkcelltech.mf.tpay.web.provision.GetCardsResponse;

@Component
@Scope("prototype")
public class Account {

  @Autowired
  private GetCardsClient getCardsClient;

  @Autowired
  WebApplicationContext webApplicationContext;

  private String msisdn;

  private List<Card> cardList;

  public Account(String msisdn) {
    this.msisdn = msisdn;
  }

  public void loadCards(String clientIPAddress, ConnectionMethod connectionMethod)
      throws Exception {
    GetCardsRequest request;
    try {
      GetCardsRequestFactory factory = new GetCardsRequestFactory();
      factory.setClientIPAddress(clientIPAddress);
      factory.setMsisdn(msisdn);
      request = factory.build();
    } catch (Exception e) {
      throw e;
    }

    try {
      GetCardsResponse response = getCardsClient.getCards(request, connectionMethod);
      if (response.getResponseHeader().getResponseCode()
          .contentEquals(PaycellWebApiConstants.SUCCESS_CODE)) {
        List<Card> list = new ArrayList<>();
        for (com.turkcelltech.mf.tpay.web.provision.Card cardListItem : response
            .getCardList()) {
          Card card = webApplicationContext.getBean(Card.class);
          BeanUtils.copyProperties(cardListItem, card);
          card.setIsDefault(cardListItem.isIsDefault());
          card.setIsExpired(cardListItem.isIsExpired());
          card.setShowEulaId(cardListItem.isShowEulaId());
          card.setIsOTPValidated(cardListItem.isIsOTPValidated());
          card.setIsThreeDValidated(cardListItem.isIsThreeDValidated());
          list.add(card);
        }
        cardList = list;
      } else {
        throw new Exception(
            "Bad Request: " + response.getResponseHeader().getResponseDescription());
      }
    } catch (Exception e) {
      throw new Exception("Service is not responding.", e);
    }
  }

  public void registerCard(Card card, String clientIpAddress,
      ConnectionMethod connectionMethod) throws Exception {
    card.save(clientIpAddress, getMsisdn(), connectionMethod);
    loadCards(clientIpAddress, connectionMethod);
  }

  public void deleteCard(Card deletedCard, String clientIPAddress,
      ConnectionMethod connectionMethod) throws Exception {
    for (Card card : cardList) {
      if (card.getCardId().contentEquals(deletedCard.getCardId())) {
        card.delete(clientIPAddress, getMsisdn(), connectionMethod);
        break;
      }
    }
    loadCards(clientIPAddress, connectionMethod);
  }

  public void updateCard(Card updatedCard, String clientIPAddress,
      ConnectionMethod connectionMethod) throws Exception {
    updatedCard.update(clientIPAddress, getMsisdn(), connectionMethod);
  }

  public void startThreeDSessionForProvision(ThreeDSession threeDSession,
      String clientIPAddress) throws Exception {
    threeDSession.setTarget(GetThreeDSessionRequestFactory.MERCHANT_TARGET);
    threeDSession.setTransactionType("AUTH");
    threeDSession.start(clientIPAddress, getMsisdn());
  }

  public void startThreeDSessionForCard(ThreeDSession threeDSession,
      String clientIPAddress) throws Exception {
    threeDSession.setTarget(GetThreeDSessionRequestFactory.MERCHANT_TARGET);
    threeDSession.setTransactionType("AUTH");
    threeDSession.setAmount("1");
    threeDSession.start(clientIPAddress, getMsisdn());
  }

  public String provision(Provision provision, String cardId, String cardToken,
      String clientIPAddress, ConnectionMethod connectionMethod) throws Exception {
    if (cardId != null) {
      return provision.provision(clientIPAddress, getMsisdn(), cardId, cardToken, connectionMethod);
    } else {
      return provision.provision(clientIPAddress, getMsisdn(), null, cardToken, connectionMethod);
    }
  }

  public String provisionForMarketPlace(ProvisionForMarketPlace provisionForMarketPlace,
      String cardId, String cardToken, String clientIPAddress, ConnectionMethod connectionMethod) throws Exception {
    if (cardId != null) {
      return provisionForMarketPlace.provisionForMarketPlace(clientIPAddress, getMsisdn(),
          cardId, cardToken, connectionMethod);
    } else {
      return provisionForMarketPlace.provisionForMarketPlace(clientIPAddress, getMsisdn(),
          null, cardToken, connectionMethod);
    }
  }

  public void checkThreeDSessionResult(ThreeDSession threeDSession,
      String clientIPAddress) throws Exception {
    threeDSession.checkResult(clientIPAddress, getMsisdn());
  }

  public Inquire inquire(String originalReferenceNumber, String clientIPAddress,
      ConnectionMethod connectionMethod) throws Exception {
    Inquire inquire = webApplicationContext.getBean(Inquire.class);
    inquire.setOriginalReferenceNumber(originalReferenceNumber);
    inquire.setMsisdn(getMsisdn());
    inquire.inquire(clientIPAddress, connectionMethod);
    return inquire;
  }

  public void reverse(Reverse reverse, String clientIPAddress, ConnectionMethod connectionMethod) throws Exception {
    reverse.reverse(clientIPAddress, getMsisdn(), connectionMethod);
  }

  public void refund(Refund refund, String clientIPAddress, ConnectionMethod connectionMethod) throws Exception {
    refund.refund(clientIPAddress, getMsisdn(), connectionMethod);
  }

  public String getMsisdn() {
    return msisdn;
  }

  public List<Card> getCardList() {
    return cardList;
  }

}
