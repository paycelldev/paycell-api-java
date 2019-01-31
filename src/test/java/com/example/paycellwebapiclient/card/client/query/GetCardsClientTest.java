package com.example.paycellwebapiclient.card.client.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.turkcelltech.mf.tpay.web.provision.GetCardsRequest;
import com.turkcelltech.mf.tpay.web.provision.GetCardsResponse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GetCardsClientTest {

  @Autowired
  GetCardsClient getCardsClient;

  @Autowired
  GetCardsTestUtil getCardsTestUtil;

  @Test
  public void testGetCardsRest() throws Exception {
    String msisdn = "5465553333";
    ConnectionMethod connectionMethod = ConnectionMethod.REST;

    getCardsTestUtil.getCards(msisdn, connectionMethod);
  }



  @Test
  public void testGetCardsSoap() throws Exception {

    GetCardsRequest request = new GetCardsRequestFactory().setMsisdn("5465553333")
        .setClientIPAddress("10.250.171.15").build();
    GetCardsResponse response = getCardsClient.getCards(request, ConnectionMethod.SOAP);

    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());
  }

}
