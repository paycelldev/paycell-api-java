package com.example.paycellwebapiclient.payment.client.inquire;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.JsonRestClient;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.turkcelltech.mf.tpay.web.provision.InquireRequest;
import com.turkcelltech.mf.tpay.web.provision.InquireResponse;

@Component
public class InquireRestClient extends JsonRestClient<InquireRequest, InquireResponse> {

  /**
   * Inquire Rest Methodunun urlsi verilir.
   */
  @Override
  public String getUrl() {
    return PaycellWebApiConstants.RestConstants.INQUIRE_URL;
  }

}
