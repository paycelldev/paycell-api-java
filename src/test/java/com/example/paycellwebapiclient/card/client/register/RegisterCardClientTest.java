package com.example.paycellwebapiclient.card.client.register;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.paycellwebapiclient.card.client.delete.DeleteCardTestUtil;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RegisterCardClientTest {

  @Autowired
  RegisterCardTestUtil registerCardTestUtil;

  @Autowired
  DeleteCardTestUtil deleteCardTestUtil;

  String msisdn = "905465553333";
  String creditCardNo = "4022774022774026";
  String expireDateMonth = "12";
  String expireDateYear = "18";
  String cvcNo = "000";



  @Test
  public void testRegisterCardRest() throws Exception {
    ConnectionMethod connectionMethod = ConnectionMethod.REST;


    String cardId = registerCardTestUtil.registerCard(msisdn, creditCardNo,
        expireDateMonth, expireDateYear, cvcNo, connectionMethod);
    assertNotNull(cardId);

    deleteCardTestUtil.deleteCard(cardId, msisdn, connectionMethod);
  }

  @Test
  public void testRegisterCardSoap() throws Exception {
    ConnectionMethod connectionMethod = ConnectionMethod.SOAP;

    String msisdn = "905465553333";
    String creditCardNo = "5400610093155852";
    String expireDateMonth = "02";
    String expireDateYear = "20";
    String cvcNo = "000";
    String cardId = registerCardTestUtil.registerCard(msisdn, creditCardNo,
        expireDateMonth, expireDateYear, cvcNo, connectionMethod);
    assertNotNull(cardId);
  }

}
