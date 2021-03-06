package com.example.paycellwebapiclient.card.client.update;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient;
import com.turkcelltech.mf.tpay.web.provision.UpdateCardRequest;
import com.turkcelltech.mf.tpay.web.provision.UpdateCardResponse;

@Component
public class UpdateCardClient extends BaseClient<UpdateCardRequest, UpdateCardResponse> {

  /**
   * @param request servis isteği
   * @param connectionMethod SOAP/REST
   * @return servis cevabı
   * @throws Exception servise ulaşırken hata alınırsa oluşur
   */
  public UpdateCardResponse updateCard(UpdateCardRequest request,
      ConnectionMethod connectionMethod) throws Exception {
    return sendRequest(request, UpdateCardResponse.class, connectionMethod);
  }

}
