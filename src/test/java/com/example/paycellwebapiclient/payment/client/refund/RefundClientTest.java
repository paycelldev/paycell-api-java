package com.example.paycellwebapiclient.payment.client.refund;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.example.paycellwebapiclient.payment.client.PaymentClientTestCardHelper;
import com.example.paycellwebapiclient.payment.client.provision.ProvisionTestUtil;
import com.turkcelltech.mf.tpay.web.provision.PaymentType;
import com.turkcelltech.mf.tpay.web.provision.RefundRequest;
import com.turkcelltech.mf.tpay.web.provision.RefundResponse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RefundClientTest {

  @Autowired
  RefundClient refundClient;

  @Autowired
  ProvisionTestUtil provisionTestUtil;

  @Autowired
  PaymentClientTestCardHelper paymentClientTestCardHelper;

  private String msisdn;

  private String cardId;

  private String originalReferenceNumber;

  private String amount;

  @Before
  public void setUp() throws Exception {
    msisdn = paymentClientTestCardHelper.getMsisdn();
    cardId = paymentClientTestCardHelper.getCardId();

    amount = "2351";
    String currency = "TRY";
    PaymentType paymentType = PaymentType.SALE;

    originalReferenceNumber = provisionTestUtil.provision(cardId, amount, currency,
        msisdn, paymentType, ConnectionMethod.REST);
  }

  @Test
  public void testRefundRest() throws Exception {
    RefundRequestFactory factory = new RefundRequestFactory();
    factory.setClientIPAddress("4.4.4.4");
    factory.setMsisdn(msisdn);
    factory.setOriginalReferenceNumber(originalReferenceNumber);
    factory.setAmount(amount);
    RefundRequest request = factory.build();

    RefundResponse response = refundClient.refund(request, ConnectionMethod.REST);
    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());
  }

  @Test
  public void testRefundSoap() throws Exception {
    RefundRequestFactory factory = new RefundRequestFactory();
    factory.setClientIPAddress("4.4.4.4");
    factory.setMsisdn(msisdn);
    factory.setOriginalReferenceNumber(originalReferenceNumber);
    factory.setAmount(amount);
    RefundRequest request = factory.build();

    RefundResponse response = refundClient.refund(request, ConnectionMethod.SOAP);
    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());
  }

}
