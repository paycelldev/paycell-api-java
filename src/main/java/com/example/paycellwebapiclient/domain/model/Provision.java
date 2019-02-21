package com.example.paycellwebapiclient.domain.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.payment.client.provision.ProvisionClient;
import com.example.paycellwebapiclient.payment.client.provision.ProvisionRequestFactory;
import com.turkcelltech.mf.tpay.web.provision.PaymentType;
import com.turkcelltech.mf.tpay.web.provision.ProvisionRequest;
import com.turkcelltech.mf.tpay.web.provision.ProvisionResponse;

@Component
@Scope("prototype")
public class Provision {

  private String referenceNumber;

  private String threeDSessionId;

  private String acquirerBankCode;

  private String amount;

  private String currency;

  private Integer installmentCount;

  private PaymentType paymentType;

  private String pin;

  private String pointAmount;

  private String target;

  private String transactionType;

  private String transactionId;

  private String provisionType;

  private String approvalCode;

  private String dateTime;

  private String reconciliationDate;

  private String responseCode;

  private String responseDescription;

  @Autowired
  private ProvisionClient provisionClient;

  public String provision(String threeDSessionId, String clientIPAddress, String msisdn,
      String cardId, String cardToken, ConnectionMethod connectionMethod) throws Exception {
    ProvisionRequestFactory factory = new ProvisionRequestFactory();
    factory.setClientIPAddress(clientIPAddress);
    factory.setAcquirerBankCode(acquirerBankCode);
    factory.setAmount(amount);
    factory.setCurrency(currency);
    factory.setInstallmentCount(installmentCount);
    factory.setPaymentType(paymentType);
    factory.setPin(pin);
    factory.setPointAmount(pointAmount);
    factory.setCardId(cardId);
    factory.setCardToken(cardToken);
    factory.setMsisdn(msisdn);
    factory.setThreeDSessionId(threeDSessionId);
    ProvisionRequest request = factory.build();

    ProvisionResponse response = provisionClient.provision(request, connectionMethod);
    if (response.getResponseHeader().getResponseCode()
        .contentEquals(PaycellWebApiConstants.SUCCESS_CODE)) {
      setReferenceNumber(request.getReferenceNumber());
      setThreeDSessionId(request.getThreeDSessionId());
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

  public String getAcquirerBankCode() {
    return acquirerBankCode;
  }

  public void setAcquirerBankCode(String acquirerBankCode) {
    this.acquirerBankCode = acquirerBankCode;
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

  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  public String getPointAmount() {
    return pointAmount;
  }

  public void setPointAmount(String pointAmount) {
    this.pointAmount = pointAmount;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public String getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public String getProvisionType() {
    return provisionType;
  }

  public void setProvisionType(String provisionType) {
    this.provisionType = provisionType;
  }

  public String getApprovalCode() {
    return approvalCode;
  }

  public void setApprovalCode(String approvalCode) {
    this.approvalCode = approvalCode;
  }

  public String getDateTime() {
    return dateTime;
  }

  public void setDateTime(String dateTime) {
    this.dateTime = dateTime;
  }

  public String getReconciliationDate() {
    return reconciliationDate;
  }

  public void setReconciliationDate(String reconciliationDate) {
    this.reconciliationDate = reconciliationDate;
  }

  public String getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(String responseCode) {
    this.responseCode = responseCode;
  }

  public String getResponseDescription() {
    return responseDescription;
  }

  public void setResponseDescription(String responseDescription) {
    this.responseDescription = responseDescription;
  }

}
