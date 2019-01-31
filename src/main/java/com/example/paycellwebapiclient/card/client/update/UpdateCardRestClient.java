package com.example.paycellwebapiclient.card.client.update;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.JsonRestClient;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.turkcelltech.mf.tpay.web.provision.UpdateCardRequest;
import com.turkcelltech.mf.tpay.web.provision.UpdateCardResponse;

@Component
public class UpdateCardRestClient
    extends JsonRestClient<UpdateCardRequest, UpdateCardResponse> {


  /**
   * UpdateCard Rest Methodunun urlsi verilir.
   */
  @Override
  public String getUrl() {
    return PaycellWebApiConstants.RestConstants.UPDATE_CARD_URL;
  }

}
