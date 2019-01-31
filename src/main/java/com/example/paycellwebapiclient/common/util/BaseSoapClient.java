package com.example.paycellwebapiclient.common.util;

import com.turkcelltech.mf.tpay.web.provision.ProvisionService;
import com.turkcelltech.mf.tpay.web.provision.ProvisionServicesImplService;

public abstract class BaseSoapClient<T, S> {

  protected ProvisionService provisionService;

  public BaseSoapClient() {
    provisionService = new ProvisionServicesImplService().getProvisionServicesImplPort();
  }

  public abstract S sendRequest(T request);
}
