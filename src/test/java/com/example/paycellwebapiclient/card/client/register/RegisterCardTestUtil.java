package com.example.paycellwebapiclient.card.client.register;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.card.client.query.GetCardsTestUtil;
import com.example.paycellwebapiclient.card.client.token.GetCardTokenTestUtil;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.turkcelltech.mf.tpay.web.provision.Card;
import com.turkcelltech.mf.tpay.web.provision.GetCardsResponse;
import com.turkcelltech.mf.tpay.web.provision.RegisterCardRequest;
import com.turkcelltech.mf.tpay.web.provision.RegisterCardResponse;

@Component
public class RegisterCardTestUtil {

  @Autowired
  private GetCardTokenTestUtil getCardTokenTestUtil;

  @Autowired
  private RegisterCardClient registerCardClient;

  @Autowired
  private GetCardsTestUtil getCardsTestUtil;

  public String registerCard(String msisdn, String creditCardNo, String expireDateMonth,
      String expireDateYear, String cvcNo, ConnectionMethod connectionMethod) throws Exception {
    GetCardsResponse getCardsResponse = getCardsTestUtil.getCards(msisdn, connectionMethod);
    for(Card card : getCardsResponse.getCardList()) {
      if(card.getMaskedCardNo().substring(12, 16).equals(creditCardNo.substring(12, 16))) {
        return card.getCardId();
      }
    }

    String cardToken = getCardTokenTestUtil.getCardToken(creditCardNo, expireDateMonth,
        expireDateYear, cvcNo);
    RegisterCardRequest request = new RegisterCardRequestFactory().setCardToken(cardToken)
        .setAlias("test").setIsDefault(true).setMsisdn(msisdn)
        .setClientIPAddress("10.250.171.15").build();
    RegisterCardResponse response =
        registerCardClient.registerCard(request, connectionMethod);
    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());
    assertNotNull(response.getCardId());
    return response.getCardId();
  }

}
