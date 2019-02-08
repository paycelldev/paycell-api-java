package com.example.paycellwebapiclient.card.client.termsofservice;

import java.util.List;
import javax.xml.ws.Holder;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseSoapClient;
import com.turkcelltech.mf.tpay.web.provision.ExtraParameter;
import com.turkcelltech.mf.tpay.web.provision.GetTermsOfServiceContentRequest;
import com.turkcelltech.mf.tpay.web.provision.GetTermsOfServiceContentResponse;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;
import com.turkcelltech.mf.tpay.web.provision.ResponseHeader;

@Component
public class GetTermsOfServiceContentSoapClient extends
    BaseSoapClient<GetTermsOfServiceContentRequest, GetTermsOfServiceContentResponse> {

  /**
   * GetTermsOfServiceContent SOAP metodu çağrılır.
   */
  @Override
  public GetTermsOfServiceContentResponse sendRequest(
      GetTermsOfServiceContentRequest request) {
    Holder<List<ExtraParameter>> extraParameters = new Holder<>();
    RequestHeader requestHeader = request.getRequestHeader();

    Holder<ResponseHeader> responseHeader = new Holder<>();
    Holder<Long> eulaId = new Holder<>();
    Holder<String> termsOfServiceHtmlContentEN = new Holder<>();
    Holder<String> termsOfServiceHtmlContentTR = new Holder<>();

    provisionService.getTermsOfServiceContent(extraParameters, requestHeader,
        responseHeader, eulaId, termsOfServiceHtmlContentEN, termsOfServiceHtmlContentTR);

    GetTermsOfServiceContentResponse response = new GetTermsOfServiceContentResponse();
    response.setResponseHeader(responseHeader.value);
    response.setEulaId(eulaId.value);
    response.setTermsOfServiceHtmlContentEN(termsOfServiceHtmlContentEN.value);
    response.setTermsOfServiceHtmlContentTR(termsOfServiceHtmlContentTR.value);
    return response;
  }

}
