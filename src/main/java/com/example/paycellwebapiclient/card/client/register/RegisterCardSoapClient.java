package com.example.paycellwebapiclient.card.client.register;

import java.util.List;
import javax.xml.ws.Holder;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseSoapClient;
import com.turkcelltech.mf.tpay.web.provision.ExtraParameter;
import com.turkcelltech.mf.tpay.web.provision.RegisterCardRequest;
import com.turkcelltech.mf.tpay.web.provision.RegisterCardResponse;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;
import com.turkcelltech.mf.tpay.web.provision.ResponseHeader;

@Component
public class RegisterCardSoapClient
    extends BaseSoapClient<RegisterCardRequest, RegisterCardResponse> {

  /**
   * RegisterCard Soap methodu çağrılır.
   */
  @Override
  public RegisterCardResponse sendRequest(RegisterCardRequest request) {
    Holder<List<ExtraParameter>> extraParameter =
        new Holder<>(request.getExtraParameters());
    RequestHeader requestHeader = request.getRequestHeader();
    String alias = request.getAlias();
    String cardToken = request.getCardToken();
    String eulaId = request.getEulaId();
    Boolean isDefault = request.isIsDefault();
    String msisdn = request.getMsisdn();
    String otp = request.getOtp();
    String otpValidationId = request.getOtpValidationId();
    String threeDSessionId = request.getThreeDSessionId();
    Holder<ResponseHeader> responseHeader = new Holder<>();
    Holder<String> cardId = new Holder<>();
    provisionService.registerCard(extraParameter, requestHeader, alias, cardToken, eulaId,
        isDefault, msisdn, otp, otpValidationId, threeDSessionId, responseHeader, cardId);

    RegisterCardResponse response = new RegisterCardResponse();
    response.setResponseHeader(responseHeader.value);
    response.setCardId(cardId.value);
    return response;
  }
}
