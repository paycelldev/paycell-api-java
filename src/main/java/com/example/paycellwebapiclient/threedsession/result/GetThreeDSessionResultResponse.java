package com.example.paycellwebapiclient.threedsession.result;

import com.turkcelltech.mf.tpay.web.provision.ResponseHeader;

public class GetThreeDSessionResultResponse {

  private ResponseHeader responseHeader;

  private String currentStep;

  private String mdErrorMessage;

  private String mdStatus;

  private ThreeDOperationResult threeDOperationResult;

  private String extraParameters;

  public ResponseHeader getResponseHeader() {
    return responseHeader;
  }

  public void setResponseHeader(ResponseHeader responseHeader) {
    this.responseHeader = responseHeader;
  }

  public String getCurrentStep() {
    return currentStep;
  }

  public void setCurrentStep(String currentStep) {
    this.currentStep = currentStep;
  }

  public String getMdErrorMessage() {
    return mdErrorMessage;
  }

  public void setMdErrorMessage(String mdErrorMessage) {
    this.mdErrorMessage = mdErrorMessage;
  }

  public String getMdStatus() {
    return mdStatus;
  }

  public void setMdStatus(String mdStatus) {
    this.mdStatus = mdStatus;
  }

  public ThreeDOperationResult getThreeDOperationResult() {
    return threeDOperationResult;
  }

  public void setThreeDOperationResult(ThreeDOperationResult threeDOperationResult) {
    this.threeDOperationResult = threeDOperationResult;
  }

  public String getExtraParameters() {
    return extraParameters;
  }

  public void setExtraParameters(String extraParameters) {
    this.extraParameters = extraParameters;
  }

}
