package com.example.paycellwebapiclient.card.client.token;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.JsonRestClient;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;

@Component
public class GetCardTokenRestClient
    extends JsonRestClient<GetCardTokenRequest, GetCardTokenResponse> {

  @Override
  public String getUrl() {
    return PaycellWebApiConstants.GET_CARD_TOKEN_URL;
  }

  public GetCardTokenResponse getCardToken(GetCardTokenRequest request) throws Exception {
    return sendRequest(request, GetCardTokenResponse.class);
  }

}
