package com.example.paycellwebapiclient.payment.client.inquire;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient;
import com.turkcelltech.mf.tpay.web.provision.InquireRequest;
import com.turkcelltech.mf.tpay.web.provision.InquireResponse;

@Component
public class InquireClient extends BaseClient<InquireRequest, InquireResponse> {

  /**
   * @param request servis isteği
   * @param connectionMethod SOAP/REST
   * @return servis cevabı
   * @throws Exception servise ulaşırken hata alınırsa oluşur
   */
  public InquireResponse inquire(InquireRequest request,
      ConnectionMethod connectionMethod) throws Exception {
    return sendRequest(request, InquireResponse.class, connectionMethod);
  }

}
