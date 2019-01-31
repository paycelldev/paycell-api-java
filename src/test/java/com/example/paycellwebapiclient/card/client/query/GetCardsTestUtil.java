package com.example.paycellwebapiclient.card.client.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.turkcelltech.mf.tpay.web.provision.GetCardsRequest;
import com.turkcelltech.mf.tpay.web.provision.GetCardsResponse;

@Component
public class GetCardsTestUtil {

  @Autowired
  GetCardsClient getCardsClient;

  public GetCardsResponse getCards(String msisdn, ConnectionMethod connectionMethod)
      throws Exception {
    GetCardsRequest request = new GetCardsRequestFactory().setMsisdn(msisdn)
        .setClientIPAddress("4.4.4.4").build();
    GetCardsResponse response = getCardsClient.getCards(request, connectionMethod);

    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());
    return response;
  }
}
