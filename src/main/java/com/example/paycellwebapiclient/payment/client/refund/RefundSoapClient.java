package com.example.paycellwebapiclient.payment.client.refund;

import java.util.List;
import javax.xml.ws.Holder;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseSoapClient;
import com.turkcelltech.mf.tpay.web.provision.ExtraParameter;
import com.turkcelltech.mf.tpay.web.provision.RefundRequest;
import com.turkcelltech.mf.tpay.web.provision.RefundResponse;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;
import com.turkcelltech.mf.tpay.web.provision.ResponseHeader;

@Component
public class RefundSoapClient extends BaseSoapClient<RefundRequest, RefundResponse> {

  /**
   * Refund Soap methodu çağrılır.
   */
  @Override
  public RefundResponse sendRequest(RefundRequest request) {
    String amount = request.getAmount();
    List<ExtraParameter> extraParameters = request.getExtraParameters();
    String merchantCode = request.getMerchantCode();
    String msisdn = request.getMsisdn();
    String originalReferenceNumber = request.getOriginalReferenceNumber();
    String pointAmount = request.getPointAmount();
    String referenceNumber = request.getReferenceNumber();
    RequestHeader requestHeader = request.getRequestHeader();
    Holder<String> approvalCode = new Holder<>();
    Holder<String> reconciliationDate = new Holder<>();
    Holder<ResponseHeader> responseHeader = new Holder<>();
    Holder<String> retryStatusCode = new Holder<>();
    Holder<String> retryStatusDescription = new Holder<>();

    provisionService.refund(amount, extraParameters, merchantCode, msisdn,
        originalReferenceNumber, pointAmount, referenceNumber, requestHeader,
        approvalCode, reconciliationDate, responseHeader, retryStatusCode,
        retryStatusDescription);

    RefundResponse response = new RefundResponse();
    response.setApprovalCode(approvalCode.value);
    response.setReconciliationDate(reconciliationDate.value);
    response.setResponseHeader(responseHeader.value);
    response.setRetryStatusCode(retryStatusCode.value);
    response.setRetryStatusDescription(retryStatusDescription.value);

    return response;
  }

}
