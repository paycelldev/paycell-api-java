package com.example.paycellwebapiclient.threedsession.get;

import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.paycellwebapiclient.card.client.delete.DeleteCardTestUtil;
import com.example.paycellwebapiclient.card.client.register.RegisterCardTestUtil;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GetThreeDSessionRestClientTest {

  @Autowired
  RegisterCardTestUtil registerCardTestUtil;

  @Autowired
  DeleteCardTestUtil deleteCardTestUtil;

  @Autowired
  GetThreeDSessionIdTestUtil getThreeDSessionIdTestUtil;

  private String msisdn;

  private String cardId;

  @Before
  public void setUp() throws Exception {
    msisdn = "905465553333";
    String creditCardNo = "5456165456165454";
    String expireDateMonth = "12";
    String expireDateYear = "18";
    String cvcNo = "000";

    cardId = registerCardTestUtil.registerCard(msisdn, creditCardNo, expireDateMonth,
        expireDateYear, cvcNo, ConnectionMethod.REST);
  }

  @After
  public void tearUp() throws Exception {
    deleteCardTestUtil.deleteCard(cardId, msisdn, ConnectionMethod.REST);
  }

  @Test
  public void testGetThreeDSessionMerchant() throws Exception {

    String target = "MERCHANT";
    String transactionType = "AUTH";
    String amount = "12300";

    String threeDSessionId = getThreeDSessionIdTestUtil.getThreeDSessionId(target, msisdn,
        cardId, transactionType, amount, false);
    assertNotNull(threeDSessionId);
  }

  @Test
  public void testGetThreeDSessionPaycell() throws Exception {

    String target = "PAYCELL";
    String transactionType = "AUTH";
    String amount = "1";

    String threeDSessionId = getThreeDSessionIdTestUtil.getThreeDSessionId(target, msisdn,
        cardId, transactionType, amount, false);
    assertNotNull(threeDSessionId);
  }

}
