package com.example.paycellwebapiclient.payment.client.reverse;

import java.util.List;
import javax.xml.ws.Holder;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseSoapClient;
import com.turkcelltech.mf.tpay.web.provision.ExtraParameter;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;
import com.turkcelltech.mf.tpay.web.provision.ResponseHeader;
import com.turkcelltech.mf.tpay.web.provision.ReverseRequest;
import com.turkcelltech.mf.tpay.web.provision.ReverseResponse;

@Component
public class ReverseSoapClient extends BaseSoapClient<ReverseRequest, ReverseResponse> {

  /**
   * Reverse Soap methodu çağrılır.
   */
  @Override
  public ReverseResponse sendRequest(ReverseRequest request) {
    List<ExtraParameter> extraParameters = request.getExtraParameters();
    String merchantCode = request.getMerchantCode();
    String msisdn = request.getMsisdn();
    String originalReferenceNumber = request.getOriginalReferenceNumber();
    String referenceNumber = request.getReferenceNumber();
    RequestHeader requestHeader = request.getRequestHeader();
    Holder<String> approvalCode = new Holder<>();
    Holder<String> reconciliationDate = new Holder<>();
    Holder<ResponseHeader> responseHeader = new Holder<>();
    Holder<String> retryStatusCode = new Holder<>();
    Holder<String> retryStatusDescription = new Holder<>();

    provisionService.reverse(extraParameters, merchantCode, msisdn,
        originalReferenceNumber, referenceNumber, requestHeader, approvalCode,
        reconciliationDate, responseHeader, retryStatusCode, retryStatusDescription);

    ReverseResponse response = new ReverseResponse();
    response.setApprovalCode(approvalCode.value);
    response.setReconciliationDate(reconciliationDate.value);
    response.setResponseHeader(responseHeader.value);
    response.setRetryStatusCode(retryStatusCode.value);
    response.setRetryStatusDescription(retryStatusDescription.value);
    return response;
  }

}
