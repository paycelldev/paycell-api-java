package com.example.paycellwebapiclient.card.client.query;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient;
import com.turkcelltech.mf.tpay.web.provision.GetCardsRequest;
import com.turkcelltech.mf.tpay.web.provision.GetCardsResponse;

@Component
public class GetCardsClient extends BaseClient<GetCardsRequest, GetCardsResponse> {

  /**
   * @param request servis isteği
   * @param connectionMethod SOAP/REST
   * @return servis cevabı
   * @throws Exception servise ulaşırken hata alınırsa oluşur
   */
  public GetCardsResponse getCards(GetCardsRequest request,
      ConnectionMethod connectionMethod) throws Exception {
    return sendRequest(request, GetCardsResponse.class, connectionMethod);
  }


}
