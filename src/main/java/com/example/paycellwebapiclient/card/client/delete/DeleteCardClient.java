package com.example.paycellwebapiclient.card.client.delete;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient;
import com.turkcelltech.mf.tpay.web.provision.DeleteCardRequest;
import com.turkcelltech.mf.tpay.web.provision.DeleteCardResponse;

@Component
public class DeleteCardClient extends BaseClient<DeleteCardRequest, DeleteCardResponse> {

  /**
   * @param request servis isteği
   * @param connectionMethod SOAP/REST
   * @return servis cevabı
   * @throws Exception servise ulaşırken hata alınırsa oluşur
   */
  public DeleteCardResponse deleteCard(DeleteCardRequest request,
      ConnectionMethod connectionMethod) throws Exception {
    return sendRequest(request, DeleteCardResponse.class, connectionMethod);
  }

}
