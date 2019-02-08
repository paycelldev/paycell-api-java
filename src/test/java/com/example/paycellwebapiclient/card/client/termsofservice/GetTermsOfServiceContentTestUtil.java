package com.example.paycellwebapiclient.card.client.termsofservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.turkcelltech.mf.tpay.web.provision.GetTermsOfServiceContentRequest;
import com.turkcelltech.mf.tpay.web.provision.GetTermsOfServiceContentResponse;

@Component
public class GetTermsOfServiceContentTestUtil {

  @Autowired
  private GetTermsOfServiceContentClient getTermsOfServiceContentClient;

  public GetTermsOfServiceContentResponse getTermsOfServiceContent(ConnectionMethod connectionMethod) throws Exception {

    GetTermsOfServiceContentRequest request = new GetTermsOfServiceContentRequestFactory()
        .setClientIPAddress("10.250.171.15").build();
    GetTermsOfServiceContentResponse response =
        getTermsOfServiceContentClient.getTermsOfServiceContent(request, connectionMethod);
    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());
    return response;
  }

}
