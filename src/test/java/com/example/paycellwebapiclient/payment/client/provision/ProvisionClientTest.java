package com.example.paycellwebapiclient.payment.client.provision;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.example.paycellwebapiclient.payment.client.PaymentClientTestCardHelper;
import com.turkcelltech.mf.tpay.web.provision.PaymentType;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProvisionClientTest {

  @Autowired
  ProvisionTestUtil provisionTestUtil;

  @Autowired
  PaymentClientTestCardHelper paymentClientTestCardHelper;

  @Test
  public void testProvisionRest() throws Exception {
    String msisdn = paymentClientTestCardHelper.getMsisdn();
    String cardId = paymentClientTestCardHelper.getCardId();
    String amount = "2351";
    String currency = "TRY";
    PaymentType paymentType = PaymentType.SALE;

    provisionTestUtil.provision(cardId, amount, currency, msisdn, paymentType,
        ConnectionMethod.REST);
  }

  @Test
  public void testProvisionSoap() throws Exception {
    String msisdn = paymentClientTestCardHelper.getMsisdn();
    String cardId = paymentClientTestCardHelper.getCardId();
    String amount = "2351";
    String currency = "TRY";
    PaymentType paymentType = PaymentType.SALE;

    provisionTestUtil.provision(cardId, amount, currency, msisdn, paymentType,
        ConnectionMethod.SOAP);
  }

}
