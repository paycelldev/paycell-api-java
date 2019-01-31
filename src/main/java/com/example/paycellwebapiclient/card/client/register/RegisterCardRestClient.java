package com.example.paycellwebapiclient.card.client.register;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.JsonRestClient;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.turkcelltech.mf.tpay.web.provision.RegisterCardRequest;
import com.turkcelltech.mf.tpay.web.provision.RegisterCardResponse;

@Component
public class RegisterCardRestClient
    extends JsonRestClient<RegisterCardRequest, RegisterCardResponse> {

  /**
   * RegisterCard Rest Methodunun urlsi verilir.
   */
  @Override
  public String getUrl() {
    return PaycellWebApiConstants.RestConstants.REGISTER_CARD_URL;
  }

}
