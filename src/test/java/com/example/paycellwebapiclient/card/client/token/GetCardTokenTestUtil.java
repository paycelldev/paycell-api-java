package com.example.paycellwebapiclient.card.client.token;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetCardTokenTestUtil {

  @Autowired
  private GetCardTokenRestClient getCardTokenRestClient;

  public String getCardToken(String creditCardNo, String expireDateMonth,
      String expireDateYear, String cvcNo) throws Exception {
    GetCardTokenRequest request =
        new GetCardTokenRequestFactory().setCreditCardNo(creditCardNo)
            .setExpireDate(expireDateMonth, expireDateYear).setCvcNo(cvcNo).build();
    GetCardTokenResponse response = getCardTokenRestClient.getCardToken(request);
    assertNotNull(response);
    String expectedHashData = generateHashData(response);
    assertEquals(expectedHashData, response.getHashData());
    return response.getCardToken();
  }

  private String generateHashData(GetCardTokenResponse response) {
    String transactionId = response.getHeader().getTransactionId();
    String responseDateTime = response.getHeader().getResponseDateTime();
    String responseCode = response.getHeader().getResponseCode();
    String cardToken = response.getCardToken();
    return HashDataGenerator.generateForResponse(transactionId, responseDateTime,
        responseCode, cardToken);
  }

}
