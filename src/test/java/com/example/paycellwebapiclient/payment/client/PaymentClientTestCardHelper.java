package com.example.paycellwebapiclient.payment.client;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.card.client.query.GetCardsClient;
import com.example.paycellwebapiclient.card.client.query.GetCardsRequestFactory;
import com.example.paycellwebapiclient.card.client.register.RegisterCardTestUtil;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.turkcelltech.mf.tpay.web.provision.Card;
import com.turkcelltech.mf.tpay.web.provision.GetCardsRequest;
import com.turkcelltech.mf.tpay.web.provision.GetCardsResponse;

@Component
public class PaymentClientTestCardHelper {

  private String msisdn;
  private String cardId;

  @Autowired
  GetCardsClient getCardsClient;

  @Autowired
  RegisterCardTestUtil registerCardTestUtil;

  @PostConstruct
  public void init() throws Exception {
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
    } else {
      registerCardTestUtil.registerCard(msisdn, creditCardNo, expireDateMonth, expireDateYear, cvcNo, connectionMethod);
    }
  }

  public String getMsisdn() {
    return msisdn;
  }

  public String getCardId() {
    return cardId;
  }



}
