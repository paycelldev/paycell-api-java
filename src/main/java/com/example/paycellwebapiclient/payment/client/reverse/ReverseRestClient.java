package com.example.paycellwebapiclient.payment.client.reverse;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.JsonRestClient;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.turkcelltech.mf.tpay.web.provision.ReverseRequest;
import com.turkcelltech.mf.tpay.web.provision.ReverseResponse;

@Component
public class ReverseRestClient extends JsonRestClient<ReverseRequest, ReverseResponse> {

  /**
   * Reverse Rest Methodunun urlsi verilir.
   */
  @Override
  public String getUrl() {
    return PaycellWebApiConstants.RestConstants.REVERSE_URL;
  }

}
