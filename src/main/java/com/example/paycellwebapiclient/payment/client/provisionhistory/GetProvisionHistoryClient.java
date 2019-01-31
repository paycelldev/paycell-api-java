package com.example.paycellwebapiclient.payment.client.provisionhistory;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient;
import com.turkcelltech.mf.tpay.web.provision.GetProvisionHistoryRequest;
import com.turkcelltech.mf.tpay.web.provision.GetProvisionHistoryResponse;

@Component
public class GetProvisionHistoryClient
    extends BaseClient<GetProvisionHistoryRequest, GetProvisionHistoryResponse> {

  /**
   * @param request servis isteği
   * @param connectionMethod SOAP/REST
   * @return servis cevabı
   * @throws Exception servise ulaşırken hata alınırsa oluşur
   */
  public GetProvisionHistoryResponse getProvisionHistory(
      GetProvisionHistoryRequest request, ConnectionMethod connectionMethod)
      throws Exception {
    return sendRequest(request, GetProvisionHistoryResponse.class, connectionMethod);
  }

}
