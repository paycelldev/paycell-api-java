package com.example.paycellwebapiclient.ui.viewbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class BaseViewBean extends SpringBeanAutowiringSupport {

  public void info(String message) {
    FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", message));
  }

  public void warn(String message) {
    FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", message));
  }

  public void error(String message) {
    FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", message));
  }

  public void fatal(String message) {
    FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", message));
  }

}
