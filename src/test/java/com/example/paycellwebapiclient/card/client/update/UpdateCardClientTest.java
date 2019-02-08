package com.example.paycellwebapiclient.card.client.update;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.paycellwebapiclient.card.client.delete.DeleteCardTestUtil;
import com.example.paycellwebapiclient.card.client.query.GetCardsClient;
import com.example.paycellwebapiclient.card.client.query.GetCardsRequestFactory;
import com.example.paycellwebapiclient.card.client.register.RegisterCardTestUtil;
import com.example.paycellwebapiclient.card.client.termsofservice.GetTermsOfServiceContentTestUtil;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.turkcelltech.mf.tpay.web.provision.Card;
import com.turkcelltech.mf.tpay.web.provision.GetCardsRequest;
import com.turkcelltech.mf.tpay.web.provision.GetCardsResponse;
import com.turkcelltech.mf.tpay.web.provision.GetTermsOfServiceContentResponse;
import com.turkcelltech.mf.tpay.web.provision.UpdateCardRequest;
import com.turkcelltech.mf.tpay.web.provision.UpdateCardResponse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UpdateCardClientTest {

  @Autowired
  UpdateCardClient updateCardClient;

  @Autowired
  RegisterCardTestUtil registerCardTestUtil;

  @Autowired
  DeleteCardTestUtil deleteCardTestUtil;

  @Autowired
  GetCardsClient getCardsClient;

  @Autowired
  GetTermsOfServiceContentTestUtil getTermsOfServiceContentTestUtil;

  String cardId;
  String msisdn;
  boolean isCardTemp;

  private Long eulaId;

  @Before
  public void setup() throws Exception {
    msisdn = "905465553333";
    ConnectionMethod connectionMethod = ConnectionMethod.REST;
    String creditCardNo = "5456165456165454";
    String expireDateMonth = "12";
    String expireDateYear = "18";
    String cvcNo = "000";

    GetCardsRequestFactory factory = new GetCardsRequestFactory();
    factory.setClientIPAddress("4.4.4.4");
    factory.setMsisdn(msisdn);
    GetCardsRequest request = factory.build();
    GetCardsResponse response = getCardsClient.getCards(request, connectionMethod);

    List<Card> cardList = response.getCardList();
    if(cardList.size() > 0) {
      cardId = cardList.get(0).getCardId();
      isCardTemp = false;
    } else {
      cardId = registerCardTestUtil.registerCard(msisdn, creditCardNo, expireDateMonth, expireDateYear, cvcNo, connectionMethod);
      isCardTemp = true;
    }

    GetTermsOfServiceContentResponse termsOfServiceContent =
        getTermsOfServiceContentTestUtil.getTermsOfServiceContent(connectionMethod);
    eulaId = termsOfServiceContent.getEulaId();
  }

  @After
  public void tearDown() throws Exception {
    if(isCardTemp) {
      deleteCardTestUtil.deleteCard(cardId, msisdn, ConnectionMethod.REST);
    }
  }

  @Test
  public void testUpdateCardRest() throws Exception {
    ConnectionMethod connectionMethod = ConnectionMethod.REST;

    String alias = "test_" + new Random().nextInt(1000);
    String clientIpAddress = "10.250.171.15";

    UpdateCardRequestFactory factory = new UpdateCardRequestFactory();
    factory.setClientIPAddress(clientIpAddress);
    factory.setCardId(cardId);
    factory.setMsisdn(msisdn);
    factory.setAlias(alias);
    factory.setEulaId(String.valueOf(eulaId));
    factory.setIsDefault(true);
    UpdateCardRequest request = factory.build();
    UpdateCardResponse response = updateCardClient.updateCard(request, connectionMethod);
    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());

  }

  @Test
  public void testUpdateCardSoap() throws Exception {
    ConnectionMethod connectionMethod = ConnectionMethod.SOAP;

    String alias = "kk non";
    String clientIpAddress = "10.250.171.15";

    UpdateCardRequestFactory factory = new UpdateCardRequestFactory();
    factory.setClientIPAddress(clientIpAddress);
    factory.setCardId(cardId);
    factory.setMsisdn(msisdn);
    factory.setAlias(alias);
    factory.setEulaId(String.valueOf(eulaId));
    factory.setIsDefault(true);
    UpdateCardRequest request = factory.build();
    UpdateCardResponse response = updateCardClient.updateCard(request, connectionMethod);
    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());

  }

}
