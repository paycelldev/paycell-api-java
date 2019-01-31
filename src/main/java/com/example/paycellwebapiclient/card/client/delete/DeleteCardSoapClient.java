package com.example.paycellwebapiclient.card.client.delete;

import java.util.List;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseSoapClient;
import com.turkcelltech.mf.tpay.web.provision.DeleteCardRequest;
import com.turkcelltech.mf.tpay.web.provision.DeleteCardResponse;
import com.turkcelltech.mf.tpay.web.provision.ExtraParameter;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;
import com.turkcelltech.mf.tpay.web.provision.ResponseHeader;

@Component
public class DeleteCardSoapClient
    extends BaseSoapClient<DeleteCardRequest, DeleteCardResponse> {

  /**
   * DeleteCard Soap methodu çağrılır.
   */
  @Override
  public DeleteCardResponse sendRequest(DeleteCardRequest request) {
    String cardId = request.getCardId();
    List<ExtraParameter> extraParameters = request.getExtraParameters();
    String msisdn = request.getMsisdn();
    RequestHeader requestHeader = request.getRequestHeader();

    ResponseHeader responseHeader =
        provisionService.deleteCard(cardId, extraParameters, msisdn, requestHeader);

    DeleteCardResponse response = new DeleteCardResponse();
    response.setResponseHeader(responseHeader);
    return response;
  }

}
