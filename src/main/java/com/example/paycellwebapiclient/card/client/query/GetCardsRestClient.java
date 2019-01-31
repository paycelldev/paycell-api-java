package com.example.paycellwebapiclient.card.client.query;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.JsonRestClient;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.turkcelltech.mf.tpay.web.provision.GetCardsRequest;
import com.turkcelltech.mf.tpay.web.provision.GetCardsResponse;

@Component
public class GetCardsRestClient
    extends JsonRestClient<GetCardsRequest, GetCardsResponse> {

  /**
   * GetCards Rest Methodunun urlsi verilir.
   */
  @Override
  public String getUrl() {
    return PaycellWebApiConstants.RestConstants.GET_CARDS_URL;
  }

}
