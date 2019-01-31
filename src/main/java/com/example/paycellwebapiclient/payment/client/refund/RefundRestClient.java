package com.example.paycellwebapiclient.payment.client.refund;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.JsonRestClient;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.turkcelltech.mf.tpay.web.provision.RefundRequest;
import com.turkcelltech.mf.tpay.web.provision.RefundResponse;

@Component
public class RefundRestClient extends JsonRestClient<RefundRequest, RefundResponse> {

  /**
   * Refund Rest Methodunun urlsi verilir.
   */
  @Override
  public String getUrl() {
    return PaycellWebApiConstants.RestConstants.REFUND_URL;
  }

}
