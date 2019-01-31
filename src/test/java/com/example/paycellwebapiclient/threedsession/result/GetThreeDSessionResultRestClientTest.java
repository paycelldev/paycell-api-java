package com.example.paycellwebapiclient.threedsession.result;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.paycellwebapiclient.threedsession.get.GetThreeDSessionIdTestUtil;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GetThreeDSessionResultRestClientTest {

  @Autowired
  GetThreeDSessionResultRestClient getThreeDSessionResultRestClient;

  @Autowired
  GetThreeDSessionIdTestUtil getThreeDSessionIdTestUtil;

  @Test
  public void testGetThreeDSessionResult() throws Exception {
    String cardId = "c58a890d-8e3b-4b44-9f50-3ac60b781714";
    String msisdn = "5465553333";
    String target = "MERCHANT";
    String transactionType = "AUTH";
    String amount = "12300";

    String threeDSessionId = getThreeDSessionIdTestUtil.getThreeDSessionId(target, msisdn,
        cardId, transactionType, amount, false);

    GetThreeDSessionResultRequestFactory factory =
        new GetThreeDSessionResultRequestFactory();
    factory.setClientIPAddress("4.4.4.4");
    factory.setMsisdn(msisdn);
    factory.setThreeDSessionId(threeDSessionId);
    factory.includeMerchantCode();
    GetThreeDSessionResultRequest request = factory.build();
    GetThreeDSessionResultResponse response =
        getThreeDSessionResultRestClient.getThreeDSessionResult(request);
    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());
  }

}
