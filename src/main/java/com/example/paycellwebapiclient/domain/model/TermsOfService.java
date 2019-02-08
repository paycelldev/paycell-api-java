package com.example.paycellwebapiclient.domain.model;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.card.client.termsofservice.GetTermsOfServiceContentClient;
import com.example.paycellwebapiclient.card.client.termsofservice.GetTermsOfServiceContentRequestFactory;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.turkcelltech.mf.tpay.web.provision.GetTermsOfServiceContentResponse;

@Component
@Scope("prototype")
public class TermsOfService implements Serializable{

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long eulaId;
  private String eulaTextEN;
  private String eulaTextTR;

  @Autowired
  private GetTermsOfServiceContentClient getTermsOfServiceContentClient;

  public void retrieveLatestEula(String clientIPAddress, ConnectionMethod connectionMethod) throws Exception {
    GetTermsOfServiceContentRequestFactory factory = new GetTermsOfServiceContentRequestFactory();
    factory.setClientIPAddress(clientIPAddress);
    GetTermsOfServiceContentResponse termsOfServiceContent =
        getTermsOfServiceContentClient.getTermsOfServiceContent(factory.build(),
            connectionMethod);
    eulaId = termsOfServiceContent.getEulaId();
    eulaTextEN = termsOfServiceContent.getTermsOfServiceHtmlContentEN();
    eulaTextTR = termsOfServiceContent.getTermsOfServiceHtmlContentTR();
  }

  public Long getEulaId() {
    return eulaId;
  }
  public void setEulaId(Long eulaId) {
    this.eulaId = eulaId;
  }
  public String getEulaTextEN() {
    return eulaTextEN;
  }
  public void setEulaTextEN(String eulaTextEN) {
    this.eulaTextEN = eulaTextEN;
  }
  public String getEulaTextTR() {
    return eulaTextTR;
  }
  public void setEulaTextTR(String eulaTextTR) {
    this.eulaTextTR = eulaTextTR;
  }



}
