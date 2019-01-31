package com.example.paycellwebapiclient.card.client.delete;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.JsonRestClient;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.turkcelltech.mf.tpay.web.provision.DeleteCardRequest;
import com.turkcelltech.mf.tpay.web.provision.DeleteCardResponse;

@Component
public class DeleteCardRestClient
    extends JsonRestClient<DeleteCardRequest, DeleteCardResponse> {

  /**
   * DeleteCard Rest Methodunun urlsi verilir.
   */
  @Override
  public String getUrl() {
    return PaycellWebApiConstants.RestConstants.DELETE_CARD_URL;
  }

}
