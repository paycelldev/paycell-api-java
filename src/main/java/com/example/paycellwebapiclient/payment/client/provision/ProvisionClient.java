package com.example.paycellwebapiclient.payment.client.provision;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient;
import com.turkcelltech.mf.tpay.web.provision.ProvisionRequest;
import com.turkcelltech.mf.tpay.web.provision.ProvisionResponse;

@Component
public class ProvisionClient extends BaseClient<ProvisionRequest, ProvisionResponse> {

  /**
   * @param request servis isteği
   * @param connectionMethod SOAP/REST
   * @return servis cevabı
   * @throws Exception servise ulaşırken hata alınırsa oluşur
   */
  public ProvisionResponse provision(ProvisionRequest request,
      ConnectionMethod connectionMethod) throws Exception {
    return sendRequest(request, ProvisionResponse.class, connectionMethod);
  }

}
