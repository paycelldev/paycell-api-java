package com.example.paycellwebapiclient.card.client.register;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient;
import com.turkcelltech.mf.tpay.web.provision.RegisterCardRequest;
import com.turkcelltech.mf.tpay.web.provision.RegisterCardResponse;

@Component
public class RegisterCardClient
    extends BaseClient<RegisterCardRequest, RegisterCardResponse> {

  /**
   * @param request servis isteği
   * @param connectionMethod SOAP/REST
   * @return servis cevabı
   * @throws Exception servise ulaşırken hata alınırsa oluşur
   */
  public RegisterCardResponse registerCard(RegisterCardRequest request,
      ConnectionMethod connectionMethod) throws Exception {
    return sendRequest(request, RegisterCardResponse.class, connectionMethod);
  };

}
