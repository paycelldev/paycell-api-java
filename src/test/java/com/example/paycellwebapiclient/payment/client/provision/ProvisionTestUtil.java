package com.example.paycellwebapiclient.payment.client.provision;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.turkcelltech.mf.tpay.web.provision.PaymentType;
import com.turkcelltech.mf.tpay.web.provision.ProvisionRequest;
import com.turkcelltech.mf.tpay.web.provision.ProvisionResponse;

@Component
public class ProvisionTestUtil {

  @Autowired
  private ProvisionClient provisionClient;

  public String provision(String cardId, String amount, String currency, String msisdn,
      PaymentType paymentType, ConnectionMethod connectionMethod) throws Exception {
    ProvisionRequestFactory factory = new ProvisionRequestFactory();
    factory.setCardId(cardId);
    factory.setAmount(amount);
    factory.setCurrency(currency);
    factory.setMsisdn(msisdn);
    factory.setPaymentType(paymentType);
    factory.setClientIPAddress("4.4.4.4");
    ProvisionRequest request = factory.build();
    ProvisionResponse response = provisionClient.provision(request, connectionMethod);
    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());

    return request.getReferenceNumber();
  }
}
