package com.example.paycellwebapiclient.domain.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.payment.client.provisionformarketplace.ProvisionForMarketPlaceClient;
import com.example.paycellwebapiclient.payment.client.provisionformarketplace.ProvisionForMarketPlaceRequestFactory;
import com.turkcelltech.mf.tpay.web.provision.PaymentType;
import com.turkcelltech.mf.tpay.web.provision.ProvisionForMarketPlaceRequest;
import com.turkcelltech.mf.tpay.web.provision.ProvisionForMarketPlaceResponse;

@Component
@Scope("prototype")
public class ProvisionForMarketPlace {

  private String referenceNumber;

  private String threeDSessionId;

  private String amount;

  private String currency;

  private Integer installmentCount;

  private String pointAmount;

  private PaymentType paymentType;

  private String acquirerBankCode;

  private String pin;

  private List<ExtraParameter> extraParameterList;

  private List<SubMerchant> subMerchantList;

  private List<CustomerEMail> customerEMailList;

  @Autowired
  private ProvisionForMarketPlaceClient provisionForMarketPlaceClient;

  public ProvisionForMarketPlace() {
    extraParameterList = new ArrayList<>();
    subMerchantList = new ArrayList<>();
    customerEMailList = new ArrayList<>();
  }

  public String provisionForMarketPlace(String clientIPAddress, String msisdn,
      String cardId, String cardToken, ConnectionMethod connectionMethod) throws Exception {
    ProvisionForMarketPlaceRequestFactory factory =
        new ProvisionForMarketPlaceRequestFactory();
    factory.setCardId(cardId);
    factory.setCardToken(cardToken);
    factory.setClientIPAddress(clientIPAddress);
    factory.setMsisdn(msisdn);
    factory.setThreeDSessionId(threeDSessionId);
    factory.setAmount(amount);
    factory.setCurrency(currency);
    factory.setInstallmentCount(installmentCount);
    factory.setPointAmount(pointAmount);
    factory.setPaymentType(paymentType);
    factory.setAcquirerBankCode(acquirerBankCode);
    factory.setPin(pin);
    for (ExtraParameter extraParameter : extraParameterList) {
      factory.addExtraParameter(extraParameter.getKey(), extraParameter.getValue());
    }
    for (SubMerchant subMerchant : subMerchantList) {
      factory.addSubMerchant(subMerchant.getSubMerchantKey(),
          subMerchant.getSubMerchantPrice());
    }
    for (CustomerEMail customerEMail : customerEMailList) {
      factory.setCustomerEmail(customerEMail.geteMail());
    }
    ProvisionForMarketPlaceRequest request = factory.build();

    ProvisionForMarketPlaceResponse response =
        provisionForMarketPlaceClient.provisionForMarketPlace(request, connectionMethod);
    if (response.getResponseHeader().getResponseCode()
        .contentEquals(PaycellWebApiConstants.SUCCESS_CODE)) {
      setReferenceNumber(request.getReferenceNumber());
      return response.getApprovalCode();
    } else {
      throw new Exception(
          "Bad Request: " + response.getResponseHeader().getResponseDescription());
    }
  }

  public String getReferenceNumber() {
    return referenceNumber;
  }

  public void setReferenceNumber(String referenceNumber) {
    this.referenceNumber = referenceNumber;
  }

  public String getThreeDSessionId() {
    return threeDSessionId;
  }

  public void setThreeDSessionId(String threeDSessionId) {
    this.threeDSessionId = threeDSessionId;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getPointAmount() {
    return pointAmount;
  }

  public void setPointAmount(String pointAmount) {
    this.pointAmount = pointAmount;
  }

  public Integer getInstallmentCount() {
    return installmentCount;
  }

  public void setInstallmentCount(Integer installmentCount) {
    this.installmentCount = installmentCount;
  }

  public PaymentType getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
  }

  public String getAcquirerBankCode() {
    return acquirerBankCode;
  }

  public void setAcquirerBankCode(String acquirerBankCode) {
    this.acquirerBankCode = acquirerBankCode;
  }

  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  public List<ExtraParameter> getExtraParameterList() {
    return extraParameterList;
  }

  public void setExtraParameterList(List<ExtraParameter> extraParameterList) {
    this.extraParameterList = extraParameterList;
  }

  public List<SubMerchant> getSubMerchantList() {
    return subMerchantList;
  }

  public void setSubMerchantList(List<SubMerchant> subMerchantList) {
    this.subMerchantList = subMerchantList;
  }

  public List<CustomerEMail> getCustomerEMailList() {
    return customerEMailList;
  }

  public void setCustomerEMailList(List<CustomerEMail> customerEMailList) {
    this.customerEMailList = customerEMailList;
  }

}
