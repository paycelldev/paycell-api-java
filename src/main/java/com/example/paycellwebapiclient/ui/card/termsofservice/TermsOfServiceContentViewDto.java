package com.example.paycellwebapiclient.ui.card.termsofservice;

import java.io.Serializable;

public class TermsOfServiceContentViewDto implements Serializable{

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private String eulaTextEN;
  private String eulaTextTR;
  private String eulaId;
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
  public String getEulaId() {
    return eulaId;
  }
  public void setEulaId(String eulaId) {
    this.eulaId = eulaId;
  }

}
