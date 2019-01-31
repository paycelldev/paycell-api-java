package com.example.paycellwebapiclient.domain.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.threedsession.get.GetThreeDSessionRequest;
import com.example.paycellwebapiclient.threedsession.get.GetThreeDSessionRequestFactory;
import com.example.paycellwebapiclient.threedsession.get.GetThreeDSessionResponse;
import com.example.paycellwebapiclient.threedsession.get.GetThreeDSessionRestClient;
import com.example.paycellwebapiclient.threedsession.result.GetThreeDSessionResultRequest;
import com.example.paycellwebapiclient.threedsession.result.GetThreeDSessionResultRequestFactory;
import com.example.paycellwebapiclient.threedsession.result.GetThreeDSessionResultResponse;
import com.example.paycellwebapiclient.threedsession.result.GetThreeDSessionResultRestClient;

@Component
@Scope("prototype")
public class ThreeDSession {

  private String threeDSessionId;

  private String cardId;

  private String cardToken;

  private String amount;

  private String installmentCount;

  private String transactionType;

  private String target;

  private String threeDResult;

  private String threeDResultDescription;

  @Autowired
  private GetThreeDSessionRestClient getThreeDSessionRestClient;

  @Autowired
  private GetThreeDSessionResultRestClient getThreeDSessionResultRestClient;

  public void start(String clientIPAddress, String msisdn) throws Exception {
    GetThreeDSessionRequestFactory factory = new GetThreeDSessionRequestFactory();
    factory.setClientIPAddress(clientIPAddress);
    factory.setMsisdn(msisdn);
    factory.setCardId(cardId);
    factory.setCardToken(cardId != null ? null : cardToken);
    factory.setAmount(amount);
    factory.setInstallmentCount(installmentCount);
    factory.setTransactionType(transactionType);
    factory.setTarget(target);
    GetThreeDSessionRequest request = factory.build();

    GetThreeDSessionResponse response =
        getThreeDSessionRestClient.getThreeDSession(request);
    if (response.getResponseHeader().getResponseCode()
        .contentEquals(PaycellWebApiConstants.SUCCESS_CODE)) {
      threeDSessionId = response.getThreeDSessionId();
    } else {
      throw new Exception(
          "Bad Request: " + response.getResponseHeader().getResponseDescription());
    }
  }

  public void checkResult(String clientIPAddress, String msisdn) throws Exception {
    GetThreeDSessionResultRequestFactory factory =
        new GetThreeDSessionResultRequestFactory();
    factory.setClientIPAddress(clientIPAddress);
    factory.setMsisdn(msisdn);
    factory.setThreeDSessionId(threeDSessionId);
    if (target.contentEquals(GetThreeDSessionRequestFactory.MERCHANT_TARGET)) {
      factory.includeMerchantCode();
    }
    GetThreeDSessionResultRequest request = factory.build();

    GetThreeDSessionResultResponse response =
        getThreeDSessionResultRestClient.getThreeDSessionResult(request);
    if (response.getResponseHeader().getResponseCode()
        .contentEquals(PaycellWebApiConstants.SUCCESS_CODE)) {
      threeDResult = response.getThreeDOperationResult().getThreeDResult();
      threeDResultDescription =
          response.getThreeDOperationResult().getThreeDResultDescription();
    } else
      throw new Exception(
          "Bad Request: " + response.getResponseHeader().getResponseDescription());
  }

  public String getThreeDSessionId() {
    return threeDSessionId;
  }

  public void setThreeDSessionId(String threeDSessionId) {
    this.threeDSessionId = threeDSessionId;
  }

  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }

  public String getCardToken() {
    return cardToken;
  }

  public void setCardToken(String cardToken) {
    this.cardToken = cardToken;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getInstallmentCount() {
    return installmentCount;
  }

  public void setInstallmentCount(String installmentCount) {
    this.installmentCount = installmentCount;
  }

  public String getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public String getThreeDResult() {
    return threeDResult;
  }

  public void setThreeDResult(String threeDResult) {
    this.threeDResult = threeDResult;
  }

  public String getThreeDResultDescription() {
    return threeDResultDescription;
  }

  public void setThreeDResultDescription(String threeDResultDescription) {
    this.threeDResultDescription = threeDResultDescription;
  }

}
