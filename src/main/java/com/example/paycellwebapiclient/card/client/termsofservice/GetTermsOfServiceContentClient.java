package com.example.paycellwebapiclient.card.client.termsofservice;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient;
import com.turkcelltech.mf.tpay.web.provision.GetTermsOfServiceContentRequest;
import com.turkcelltech.mf.tpay.web.provision.GetTermsOfServiceContentResponse;

@Component
public class GetTermsOfServiceContentClient extends
    BaseClient<GetTermsOfServiceContentRequest, GetTermsOfServiceContentResponse> {

  /**
   * @param request servis isteği
   * @param connectionMethod SOAP/REST
   * @return servis cevabı
   * @throws Exception servise ulaşırken hata alınırsa oluşur
   */
  public GetTermsOfServiceContentResponse getTermsOfServiceContent(
      GetTermsOfServiceContentRequest request, ConnectionMethod connectionMethod)
      throws Exception {
    return sendRequest(request, GetTermsOfServiceContentResponse.class, connectionMethod);
  }

}
