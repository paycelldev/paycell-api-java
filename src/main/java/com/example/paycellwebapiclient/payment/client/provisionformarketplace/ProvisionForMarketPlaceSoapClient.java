package com.example.paycellwebapiclient.payment.client.provisionformarketplace;

import java.util.List;
import javax.xml.ws.Holder;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseSoapClient;
import com.turkcelltech.mf.tpay.web.provision.ExtraParameter;
import com.turkcelltech.mf.tpay.web.provision.PaymentType;
import com.turkcelltech.mf.tpay.web.provision.ProvisionForMarketPlaceRequest;
import com.turkcelltech.mf.tpay.web.provision.ProvisionForMarketPlaceResponse;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;
import com.turkcelltech.mf.tpay.web.provision.ResponseHeader;
import com.turkcelltech.mf.tpay.web.provision.SubMerchant;

@Component
public class ProvisionForMarketPlaceSoapClient extends
    BaseSoapClient<ProvisionForMarketPlaceRequest, ProvisionForMarketPlaceResponse> {

  /**
   * ProvisionForMarketPlace Soap methodu çağrılır.
   */
  @Override
  public ProvisionForMarketPlaceResponse sendRequest(
      ProvisionForMarketPlaceRequest request) {
    Holder<List<ExtraParameter>> extraParameters =
        new Holder<>(request.getExtraParameters());
    RequestHeader requestHeader = request.getRequestHeader();
    String customerEmail = request.getCustomerEmail();
    String currency = request.getCurrency();
    String cardToken = request.getCardToken();
    String cardId = request.getCardId();
    String amount = request.getAmount();
    Holder<String> acquirerBankCode = new Holder<>(request.getAcquirerBankCode());
    Integer installmentCount = request.getInstallmentCount();
    String merchantCode = request.getMerchantCode();
    String msisdn = request.getMsisdn();
    PaymentType paymentType = request.getPaymentType();
    String pin = request.getPin();
    String pointAmount = request.getPointAmount();
    String threeDSessionId = request.getThreeDSessionId();
    List<SubMerchant> subMerchants = request.getSubMerchants();
    String referenceNumber = request.getReferenceNumber();
    Holder<ResponseHeader> responseHeader = new Holder<>();
    Holder<String> approvalCode = new Holder<>();
    Holder<String> issuerBankCode = new Holder<>();
    Holder<String> orderId = new Holder<>();
    Holder<String> reconciliationDate = new Holder<>();

    provisionService.provisionForMarketPlace(extraParameters, requestHeader,
        acquirerBankCode, amount, cardId, cardToken, currency, customerEmail,
        installmentCount, merchantCode, msisdn, paymentType, pin, pointAmount,
        referenceNumber, subMerchants, threeDSessionId, responseHeader, approvalCode,
        issuerBankCode, orderId, reconciliationDate);

    ProvisionForMarketPlaceResponse response = new ProvisionForMarketPlaceResponse();
    response.setResponseHeader(responseHeader.value);
    response.setAcquirerBankCode(acquirerBankCode.value);
    response.setApprovalCode(approvalCode.value);
    response.setIssuerBankCode(issuerBankCode.value);
    response.setOrderId(orderId.value);
    response.setReconciliationDate(reconciliationDate.value);
    return response;
  }

}
