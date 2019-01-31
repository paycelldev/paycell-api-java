package com.example.paycellwebapiclient.payment.client.inquire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.turkcelltech.mf.tpay.web.provision.InquireRequest;
import com.turkcelltech.mf.tpay.web.provision.InquireResponse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InquireClientTest {

  @Autowired
  InquireClient inquireClient;

  @Test
  public void testInquireRest() throws Exception {
    InquireRequestFactory factory = new InquireRequestFactory();
    factory.setClientIPAddress("4.4.4.4");
    factory.setMsisdn("5465553333");
    factory.setOriginalReferenceNumber("00120181114150809797");
    InquireRequest request = factory.build();
    InquireResponse response = inquireClient.inquire(request, ConnectionMethod.REST);
    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());
  }

  @Test
  public void testInquireSoap() throws Exception {
    InquireRequestFactory factory = new InquireRequestFactory();
    factory.setClientIPAddress("4.4.4.4");
    factory.setMsisdn("5465553333");
    factory.setOriginalReferenceNumber("00120181114150809797");
    InquireRequest request = factory.build();
    InquireResponse response = inquireClient.inquire(request, ConnectionMethod.SOAP);
    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());
  }

}
