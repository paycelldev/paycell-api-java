package com.example.paycellwebapiclient.payment.client.provision;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.JsonRestClient;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.turkcelltech.mf.tpay.web.provision.ProvisionRequest;
import com.turkcelltech.mf.tpay.web.provision.ProvisionResponse;

@Component
public class ProvisionRestClient
    extends JsonRestClient<ProvisionRequest, ProvisionResponse> {

  /**
   * Provision Rest Methodunun urlsi verilir.
   */
  @Override
  public String getUrl() {
    return PaycellWebApiConstants.RestConstants.PROVISION_URL;
  }

}
