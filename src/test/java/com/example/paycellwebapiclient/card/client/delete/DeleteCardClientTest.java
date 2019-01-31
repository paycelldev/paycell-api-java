package com.example.paycellwebapiclient.card.client.delete;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.paycellwebapiclient.card.client.register.RegisterCardTestUtil;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DeleteCardClientTest {

  @Autowired
  RegisterCardTestUtil registerCardTestUtil;

  @Autowired
  DeleteCardTestUtil deleteCardTestUtil;

  @Test
  public void testDeleteCardRest() throws Exception {
    ConnectionMethod connectionMethod = ConnectionMethod.REST;

    String msisdn = "905465553333";
    String creditCardNo = "4506347022052795";
    String expireDateMonth = "02";
    String expireDateYear = "20";
    String cvcNo = "000";

    String cardId = registerCardTestUtil.registerCard(msisdn, creditCardNo,
        expireDateMonth, expireDateYear, cvcNo, connectionMethod);
    assertNotNull(cardId);

    deleteCardTestUtil.deleteCard(cardId, msisdn, connectionMethod);
  }

  @Test
  public void testDeleteCardSoap() throws Exception {
    ConnectionMethod connectionMethod = ConnectionMethod.SOAP;

    String msisdn = "905465553333";
    String creditCardNo = "4506347022052795";
    String expireDateMonth = "02";
    String expireDateYear = "20";
    String cvcNo = "000";

    String cardId = registerCardTestUtil.registerCard(msisdn, creditCardNo,
        expireDateMonth, expireDateYear, cvcNo, connectionMethod);
    assertNotNull(cardId);

    deleteCardTestUtil.deleteCard(cardId, msisdn, connectionMethod);
  }

}
