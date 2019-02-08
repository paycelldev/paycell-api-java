package com.example.paycellwebapiclient.card.client.termsofservice;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.JsonRestClient;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.turkcelltech.mf.tpay.web.provision.GetTermsOfServiceContentRequest;
import com.turkcelltech.mf.tpay.web.provision.GetTermsOfServiceContentResponse;

@Component
public class GetTermsOfServiceContentRestClient extends
    JsonRestClient<GetTermsOfServiceContentRequest, GetTermsOfServiceContentResponse> {

  @Override
  public String getUrl() {
    return PaycellWebApiConstants.RestConstants.GET_TERMS_OF_SERVICE_CONTENT_URL;
  }

}
