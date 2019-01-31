package com.example.paycellwebapiclient.payment.client.inquire;

import java.util.List;
import javax.xml.ws.Holder;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseSoapClient;
import com.turkcelltech.mf.tpay.web.provision.ExtraParameter;
import com.turkcelltech.mf.tpay.web.provision.InquireRequest;
import com.turkcelltech.mf.tpay.web.provision.InquireResponse;
import com.turkcelltech.mf.tpay.web.provision.Provision;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;
import com.turkcelltech.mf.tpay.web.provision.ResponseHeader;

@Component
public class InquireSoapClient extends BaseSoapClient<InquireRequest, InquireResponse> {

  /**
   * Inquire Soap methodu çağrılır.
   */
  @Override
  public InquireResponse sendRequest(InquireRequest request) {
    List<ExtraParameter> extraParameters = request.getExtraParameters();
    String merchantCode = request.getMerchantCode();
    String msisdn = request.getMsisdn();
    String originalReferenceNumber = request.getOriginalReferenceNumber();
    String referenceNumber = request.getReferenceNumber();
    RequestHeader requestHeader = request.getRequestHeader();

    Holder<String> acquirerBankCode = new Holder<>();
    Holder<String> orderId = new Holder<>();
    Holder<List<Provision>> provisionList = new Holder<>();
    Holder<ResponseHeader> responseHeader = new Holder<>();
    Holder<String> status = new Holder<>();

    provisionService.inquire(extraParameters, merchantCode, msisdn,
        originalReferenceNumber, referenceNumber, requestHeader, acquirerBankCode,
        orderId, provisionList, responseHeader, status);

    InquireResponse inquireResponse = new InquireResponse();
    inquireResponse.setAcquirerBankCode(acquirerBankCode.value);
    inquireResponse.setOrderId(orderId.value);
    inquireResponse.getProvisionList().addAll(provisionList.value);
    inquireResponse.setResponseHeader(responseHeader.value);
    inquireResponse.setStatus(status.value);
    return inquireResponse;
  }

}
