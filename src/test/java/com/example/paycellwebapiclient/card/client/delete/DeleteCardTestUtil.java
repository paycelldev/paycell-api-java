package com.example.paycellwebapiclient.card.client.delete;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.turkcelltech.mf.tpay.web.provision.DeleteCardRequest;
import com.turkcelltech.mf.tpay.web.provision.DeleteCardResponse;

@Component
public class DeleteCardTestUtil {

  @Autowired
  private DeleteCardClient deleteCardClient;

  public void deleteCard(String cardId, String msisdn, ConnectionMethod connectionMethod)
      throws Exception {
    DeleteCardRequestFactory factory = new DeleteCardRequestFactory();
    factory.setCardId(cardId);
    factory.setMsisdn(msisdn);
    factory.setClientIPAddress("4.4.4.4");
    DeleteCardRequest request = factory.build();

    DeleteCardResponse response = deleteCardClient.deleteCard(request, connectionMethod);
    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());
  }

}
