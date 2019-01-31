package com.example.paycellwebapiclient.payment.client.reverse;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient;
import com.turkcelltech.mf.tpay.web.provision.ReverseRequest;
import com.turkcelltech.mf.tpay.web.provision.ReverseResponse;

@Component
public class ReverseClient extends BaseClient<ReverseRequest, ReverseResponse> {

  /**
   * @param request servis isteği
   * @param connectionMethod SOAP/REST
   * @return servis cevabı
   * @throws Exception servise ulaşırken hata alınırsa oluşur
   */
  public ReverseResponse reverse(ReverseRequest request,
      ConnectionMethod connectionMethod) throws Exception {
    return sendRequest(request, ReverseResponse.class, connectionMethod);
  }

}
