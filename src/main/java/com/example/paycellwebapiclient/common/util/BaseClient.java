package com.example.paycellwebapiclient.common.util;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseClient<T, S> {

  @Autowired
  private JsonRestClient<T, S> restClient;

  @Autowired
  private BaseSoapClient<T, S> soapClient;

  public S sendRequest(T request, Class<S> responseClass,
      ConnectionMethod connectionMethod) throws Exception {
    if (connectionMethod.equals(ConnectionMethod.REST)) {
      return restClient.sendRequest(request, responseClass);
    } else {
      return soapClient.sendRequest(request);
    }
  }

  public enum ConnectionMethod {
    REST, SOAP
  }
}
