package com.example.paycellwebapiclient.threedsession.get;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetThreeDSessionIdTestUtil {

  @Autowired
  GetThreeDSessionRestClient getThreeDSessionRestClient;

  public String getThreeDSessionId(String target, String msisdn, String cardId,
      String transactionType, String amount, boolean isOilService) throws Exception {
    String clientIPAddress = "4.4.4.4";

    GetThreeDSessionRequestFactory factory = new GetThreeDSessionRequestFactory();
    factory.setClientIPAddress(clientIPAddress);
    factory.setTarget(target);
    factory.setAmount(amount);
    factory.setMsisdn(msisdn);
    factory.setCardId(cardId);
    factory.setTransactionType(transactionType);

    GetThreeDSessionRequest request = factory.build();
    GetThreeDSessionResponse response =
        getThreeDSessionRestClient.getThreeDSession(request);
    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());
    return response.getThreeDSessionId();
  }

}
