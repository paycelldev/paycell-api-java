package com.example.paycellwebapiclient.card.client.termsofservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GetTermsOfServiceContentClientTest {

  @Autowired
  GetTermsOfServiceContentTestUtil getTermsOfServiceContentTestUtil;

  @Test
  public void testGetTermsOfServiceContentRest() throws Exception {
    ConnectionMethod connectionMethod = ConnectionMethod.REST;
    getTermsOfServiceContentTestUtil.getTermsOfServiceContent(connectionMethod);
  }

  @Test
  public void testGetTermsOfServiceContentSoap() throws Exception {
    ConnectionMethod connectionMethod = ConnectionMethod.SOAP;
    getTermsOfServiceContentTestUtil.getTermsOfServiceContent(connectionMethod);
  }

}
