package com.example.paycellwebapiclient.threedsession.get;

import com.turkcelltech.mf.tpay.web.provision.ResponseHeader;

public class GetThreeDSessionResponse {

  private ResponseHeader responseHeader;

  private String threeDSessionId;

  private String extraParameters;

  public ResponseHeader getResponseHeader() {
    return responseHeader;
  }

  public void setResponseHeader(ResponseHeader responseHeader) {
    this.responseHeader = responseHeader;
  }

  public String getThreeDSessionId() {
    return threeDSessionId;
  }

  public void setThreeDSessionId(String threeDSessionId) {
    this.threeDSessionId = threeDSessionId;
  }

  public String getExtraParameters() {
    return extraParameters;
  }

  public void setExtraParameters(String extraParameters) {
    this.extraParameters = extraParameters;
  }

}
