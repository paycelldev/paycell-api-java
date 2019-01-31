package com.example.paycellwebapiclient.payment.client.provisionformarketplace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.example.paycellwebapiclient.payment.client.PaymentClientTestCardHelper;
import com.turkcelltech.mf.tpay.web.provision.PaymentType;
import com.turkcelltech.mf.tpay.web.provision.ProvisionForMarketPlaceRequest;
import com.turkcelltech.mf.tpay.web.provision.ProvisionForMarketPlaceResponse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProvisionForMarketPlaceClientTest {

  @Autowired
  ProvisionForMarketPlaceClient provisionForMarketPlaceClient;

  @Autowired
  PaymentClientTestCardHelper paymentClientTestCardHelper;

  @Test
  public void testProvisionForMarketPlaceRest() throws Exception {
    String msisdn = paymentClientTestCardHelper.getMsisdn();
    String cardId = paymentClientTestCardHelper.getCardId();

    ProvisionForMarketPlaceRequestFactory factory =
        new ProvisionForMarketPlaceRequestFactory();
    factory.setClientIPAddress("4.4.4.4");
    factory.setMsisdn(msisdn);
    factory.setAcquirerBankCode("111");
    factory.setAmount("2351");
    factory.setCurrency("TRY");
    factory.setCardId(cardId);
    factory.setPaymentType(PaymentType.SALE);

    ProvisionForMarketPlaceRequest request = factory.build();
    ProvisionForMarketPlaceResponse response = provisionForMarketPlaceClient
        .provisionForMarketPlace(request, ConnectionMethod.REST);
    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());
  }

  @Test
  public void testProvisionForMarketPlaceSoap() throws Exception {
    String msisdn = paymentClientTestCardHelper.getMsisdn();
    String cardId = paymentClientTestCardHelper.getCardId();

    ProvisionForMarketPlaceRequestFactory factory =
        new ProvisionForMarketPlaceRequestFactory();
    factory.setClientIPAddress("4.4.4.4");
    factory.setMsisdn(msisdn);
    factory.setAcquirerBankCode("111");
    factory.setAmount("2351");
    factory.setCurrency("TRY");
    factory.setCardId(cardId);
    factory.setPaymentType(PaymentType.SALE);

    ProvisionForMarketPlaceRequest request = factory.build();
    ProvisionForMarketPlaceResponse response = provisionForMarketPlaceClient
        .provisionForMarketPlace(request, ConnectionMethod.SOAP);
    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());
  }

}
