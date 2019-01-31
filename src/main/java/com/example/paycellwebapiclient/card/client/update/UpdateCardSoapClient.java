package com.example.paycellwebapiclient.card.client.update;

import java.util.List;
import javax.xml.ws.Holder;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseSoapClient;
import com.turkcelltech.mf.tpay.web.provision.ExtraParameter;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;
import com.turkcelltech.mf.tpay.web.provision.ResponseHeader;
import com.turkcelltech.mf.tpay.web.provision.UpdateCardRequest;
import com.turkcelltech.mf.tpay.web.provision.UpdateCardResponse;

@Component
public class UpdateCardSoapClient
    extends BaseSoapClient<UpdateCardRequest, UpdateCardResponse> {

  /**
   * UpdateCard Soap methodu çağrılır.
   */
  @Override
  public UpdateCardResponse sendRequest(UpdateCardRequest request) {
    Holder<List<ExtraParameter>> extraParameters =
        new Holder<>(request.getExtraParameters());
    RequestHeader requestHeader = request.getRequestHeader();
    String alias = request.getAlias();
    String cardId = request.getCardId();
    String eulaId = request.getEulaId();
    Boolean isDefault = request.isIsDefault();
    String msisdn = request.getMsisdn();
    String otp = request.getOtp();
    String otpValidationId = request.getOtpValidationId();
    String threeDSessionId = request.getThreeDSessionId();
    Holder<ResponseHeader> responseHeader = new Holder<>();
    provisionService.updateCard(extraParameters, requestHeader, alias, cardId, eulaId,
        isDefault, msisdn, otp, otpValidationId, threeDSessionId, responseHeader);

    UpdateCardResponse response = new UpdateCardResponse();
    response.setResponseHeader(responseHeader.value);
    return response;
  }

}
