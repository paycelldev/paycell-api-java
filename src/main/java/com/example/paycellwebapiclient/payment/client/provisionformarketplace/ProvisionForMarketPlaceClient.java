package com.example.paycellwebapiclient.payment.client.provisionformarketplace;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient;
import com.turkcelltech.mf.tpay.web.provision.ProvisionForMarketPlaceRequest;
import com.turkcelltech.mf.tpay.web.provision.ProvisionForMarketPlaceResponse;

@Component
public class ProvisionForMarketPlaceClient
    extends BaseClient<ProvisionForMarketPlaceRequest, ProvisionForMarketPlaceResponse> {

  /**
   * @param request servis isteği
   * @param connectionMethod SOAP/REST
   * @return servis cevabı
   * @throws Exception servise ulaşırken hata alınırsa oluşur
   */
  public ProvisionForMarketPlaceResponse provisionForMarketPlace(
      ProvisionForMarketPlaceRequest request, ConnectionMethod connectionMethod)
      throws Exception {
    return sendRequest(request, ProvisionForMarketPlaceResponse.class, connectionMethod);
  }


}
