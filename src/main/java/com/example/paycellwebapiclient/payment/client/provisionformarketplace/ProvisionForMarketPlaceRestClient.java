package com.example.paycellwebapiclient.payment.client.provisionformarketplace;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.JsonRestClient;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.turkcelltech.mf.tpay.web.provision.ProvisionForMarketPlaceRequest;
import com.turkcelltech.mf.tpay.web.provision.ProvisionForMarketPlaceResponse;

@Component
public class ProvisionForMarketPlaceRestClient extends
    JsonRestClient<ProvisionForMarketPlaceRequest, ProvisionForMarketPlaceResponse> {

  /**
   * ProvisionForMarketPlace Rest Methodunun urlsi verilir.
   */
  @Override
  public String getUrl() {
    return PaycellWebApiConstants.RestConstants.PROVISION_FOR_MARKET_PLACE_URL;
  }

}
