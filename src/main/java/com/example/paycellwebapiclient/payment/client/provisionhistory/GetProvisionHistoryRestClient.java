package com.example.paycellwebapiclient.payment.client.provisionhistory;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.JsonRestClient;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.turkcelltech.mf.tpay.web.provision.GetProvisionHistoryRequest;
import com.turkcelltech.mf.tpay.web.provision.GetProvisionHistoryResponse;

@Component
public class GetProvisionHistoryRestClient
    extends JsonRestClient<GetProvisionHistoryRequest, GetProvisionHistoryResponse> {

  /**
   * GetProvisionHistory Rest Methodunun urlsi verilir.
   */
  @Override
  public String getUrl() {
    return PaycellWebApiConstants.RestConstants.GET_PROVISION_HISTORY_URL;
  }

}
