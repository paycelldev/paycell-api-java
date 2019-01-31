package com.example.paycellwebapiclient.ui.payment.provision;

import java.util.ArrayList;
import java.util.List;

public class ProvisionForMarketPlaceViewDto implements ProvisionForMarketPlaceListener {

  private String referenceNumber;

  private String threeDSessionId;

  private String amount;

  private String currency;

  private String installmentCount;

  private String pointAmount;

  private String paymentType;

  private String acquirerBankCode;

  private String pin;

  private List<ExtraParameterViewDto> extraParameterList;

  private List<SubMerchantViewDto> subMerchantList;

  private List<CustomerEMailViewDto> customerEMailList;

  private ProvisionForMarketPlaceListener provisionForMarketPlaceListener;

  public ProvisionForMarketPlaceViewDto(
      ProvisionForMarketPlaceListener provisionForMarketPlaceListener) {
    this.provisionForMarketPlaceListener = provisionForMarketPlaceListener;
    extraParameterList = new ArrayList<>();
    subMerchantList = new ArrayList<>();
    customerEMailList = new ArrayList<>();
  }

  @Override
  public void sendProvisionForMarketPlace() {
    if (provisionForMarketPlaceListener != null) {
      provisionForMarketPlaceListener.sendProvisionForMarketPlace();
    }
  }

  @Override
  public void sendProvisionForMarketPlaceThreeD() {
    if (provisionForMarketPlaceListener != null) {
      provisionForMarketPlaceListener.sendProvisionForMarketPlaceThreeD();
    }
  }

  @Override
  public void listenProvisionForMarketPlaceThreeD() {
    if (provisionForMarketPlaceListener != null) {
      provisionForMarketPlaceListener.listenProvisionForMarketPlaceThreeD();
    }
  }

  @Override
  public void addExtraParameter() {
    if (provisionForMarketPlaceListener != null) {
      provisionForMarketPlaceListener.addExtraParameter();
    }
  }

  @Override
  public void addSubMerchant() {
    if (provisionForMarketPlaceListener != null) {
      provisionForMarketPlaceListener.addSubMerchant();
    }
  }

  @Override
  public void addCustomerEMail() {
    if (provisionForMarketPlaceListener != null) {
      provisionForMarketPlaceListener.addCustomerEMail();
    }
  }

  @Override
  public void deleteExtraParameter(String id) {
    if (provisionForMarketPlaceListener != null) {
      provisionForMarketPlaceListener.deleteExtraParameter(id);
    }
  }

  @Override
  public void deleteSubMerchant(String id) {
    if (provisionForMarketPlaceListener != null) {
      provisionForMarketPlaceListener.deleteSubMerchant(id);
    }
  }

  @Override
  public void deleteCustomerEMail(String id) {
    if (provisionForMarketPlaceListener != null) {
      provisionForMarketPlaceListener.deleteCustomerEMail(id);
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

  public String getInstallmentCount() {
    return installmentCount;
  }

  public void setInstallmentCount(String installmentCount) {
    this.installmentCount = installmentCount;
  }

  public String getPointAmount() {
    return pointAmount;
  }

  public void setPointAmount(String pointAmount) {
    this.pointAmount = pointAmount;
  }

  public String getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(String paymentType) {
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

  public List<ExtraParameterViewDto> getExtraParameterList() {
    return extraParameterList;
  }

  public void setExtraParameterList(List<ExtraParameterViewDto> extraParameterList) {
    this.extraParameterList = extraParameterList;
  }

  public List<SubMerchantViewDto> getSubMerchantList() {
    return subMerchantList;
  }

  public void setSubMerchantList(List<SubMerchantViewDto> subMerchantList) {
    this.subMerchantList = subMerchantList;
  }

  public List<CustomerEMailViewDto> getCustomerEMailList() {
    return customerEMailList;
  }

  public void setCustomerEMailList(List<CustomerEMailViewDto> customerEMailList) {
    this.customerEMailList = customerEMailList;
  }


}
