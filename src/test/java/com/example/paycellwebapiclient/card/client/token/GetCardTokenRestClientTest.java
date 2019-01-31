package com.example.paycellwebapiclient.card.client.token;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GetCardTokenRestClientTest {

  @Autowired
  GetCardTokenTestUtil getCardTokenTestUtil;

  @Test
  public void testGetCardToken() throws Exception {
    String cardToken =
        getCardTokenTestUtil.getCardToken("4355084355084358", "12", "18", "212");
    assertNotNull(cardToken);
  }


  @Test
  public void testGetCardTokenWithoutCvc() throws Exception {
    String cardToken =
        getCardTokenTestUtil.getCardToken("4355084355084358", "12", "18", null);
    assertNotNull(cardToken);
  }


  @Test
  public void testGetCardTokenOnlyCvc() throws Exception {
    String cardToken = getCardTokenTestUtil.getCardToken(null, null, null, "212");
    assertNotNull(cardToken);
  }

}
