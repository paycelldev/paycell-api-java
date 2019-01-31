package com.example.paycellwebapiclient.card.client.query;

import java.util.List;
import javax.xml.ws.Holder;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseSoapClient;
import com.turkcelltech.mf.tpay.web.provision.Card;
import com.turkcelltech.mf.tpay.web.provision.ExtraParameter;
import com.turkcelltech.mf.tpay.web.provision.GetCardsRequest;
import com.turkcelltech.mf.tpay.web.provision.GetCardsResponse;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;
import com.turkcelltech.mf.tpay.web.provision.ResponseHeader;

@Component
public class GetCardsSoapClient
    extends BaseSoapClient<GetCardsRequest, GetCardsResponse> {

  /**
   * GetCards Soap methodu çağrılır.
   */
  @Override
  public GetCardsResponse sendRequest(GetCardsRequest request) {
    RequestHeader requestHeader = request.getRequestHeader();
    String msisdn = request.getMsisdn();
    Holder<List<ExtraParameter>> extraParameters =
        new Holder<>(request.getExtraParameters());


    Holder<ResponseHeader> responseHeaderHolder = new Holder<>();
    Holder<List<Card>> cardListHolder = new Holder<>();;
    Holder<String> eulaIdHolder = new Holder<>();;
    provisionService.getCards(extraParameters, msisdn, requestHeader,
        responseHeaderHolder, cardListHolder, eulaIdHolder);

    GetCardsResponse getCardsResponse = new GetCardsResponse();
    getCardsResponse.setResponseHeader(responseHeaderHolder.value);
    getCardsResponse.setEulaId(eulaIdHolder.value);
    getCardsResponse.getCardList().addAll(cardListHolder.value);
    return getCardsResponse;
  }


}
