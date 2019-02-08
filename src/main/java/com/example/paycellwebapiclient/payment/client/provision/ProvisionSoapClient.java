package com.example.paycellwebapiclient.payment.client.provision;

import java.util.List;
import javax.xml.ws.Holder;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseSoapClient;
import com.turkcelltech.mf.tpay.web.provision.ExtraParameter;
import com.turkcelltech.mf.tpay.web.provision.PaymentType;
import com.turkcelltech.mf.tpay.web.provision.ProvisionRequest;
import com.turkcelltech.mf.tpay.web.provision.ProvisionResponse;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;
import com.turkcelltech.mf.tpay.web.provision.ResponseHeader;

@Component
public class ProvisionSoapClient
    extends BaseSoapClient<ProvisionRequest, ProvisionResponse> {

  /**
   * Provision Soap methodu çağrılır.
   */
  @Override
  public ProvisionResponse sendRequest(ProvisionRequest request) {
    Holder<List<ExtraParameter>> extraParameters =
        new Holder<>(request.getExtraParameters());
    RequestHeader requestHeader = request.getRequestHeader();
    Holder<String> acquirerBankCode = new Holder<>(request.getAcquirerBankCode());
    String amount = request.getAmount();
    String cardId = request.getCardId();
    String cardToken = request.getCardToken();
    String currency = request.getCurrency();
    Integer installmentCount = request.getInstallmentCount();
    String merchantCode = request.getMerchantCode();
    String msisdn = request.getMsisdn();
    String originalReferenceNumber = request.getOriginalReferenceNumber();
    PaymentType paymentType = request.getPaymentType();
    String pin = request.getPin();
    String pointAmount = request.getPointAmount();
    String referenceNumber = request.getReferenceNumber();
    String threeDSessionId = request.getThreeDSessionId();
    Holder<ResponseHeader> responseHeader = new Holder<>();
    Holder<String> approvalCode = new Holder<>();
    Holder<String> issuerBankCode = new Holder<>();
    Holder<String> orderId = new Holder<>();
    Holder<String> reconciliationDate = new Holder<>();

    Holder<String> iyzPaymentId = new Holder<>();
    Holder<String> iyzPaymentTransactionId = new Holder<>();
    provisionService.provision(extraParameters, requestHeader, acquirerBankCode, amount,
        cardId, cardToken, currency, installmentCount, merchantCode, msisdn, originalReferenceNumber, paymentType,
        pin, pointAmount, referenceNumber, threeDSessionId, responseHeader, approvalCode,
        issuerBankCode, iyzPaymentId, iyzPaymentTransactionId, orderId, reconciliationDate);

    ProvisionResponse response = new ProvisionResponse();
    response.setAcquirerBankCode(acquirerBankCode.value);
    response.setResponseHeader(responseHeader.value);
    response.setApprovalCode(approvalCode.value);
    response.setIssuerBankCode(issuerBankCode.value);
    response.setOrderId(orderId.value);
    response.setReconciliationDate(reconciliationDate.value);
    return response;
  }
}
