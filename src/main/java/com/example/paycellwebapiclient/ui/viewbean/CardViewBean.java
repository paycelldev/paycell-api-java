package com.example.paycellwebapiclient.ui.viewbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.PrimeFaces;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.example.paycellwebapiclient.domain.model.Account;
import com.example.paycellwebapiclient.domain.model.Card;
import com.example.paycellwebapiclient.domain.model.CustomerEMail;
import com.example.paycellwebapiclient.domain.model.ExtraParameter;
import com.example.paycellwebapiclient.domain.model.Inquire;
import com.example.paycellwebapiclient.domain.model.Provision;
import com.example.paycellwebapiclient.domain.model.ProvisionForMarketPlace;
import com.example.paycellwebapiclient.domain.model.ProvisionHistory;
import com.example.paycellwebapiclient.domain.model.Refund;
import com.example.paycellwebapiclient.domain.model.Reverse;
import com.example.paycellwebapiclient.domain.model.SubMerchant;
import com.example.paycellwebapiclient.domain.model.SummaryReconciliation;
import com.example.paycellwebapiclient.domain.model.ThreeDSession;
import com.example.paycellwebapiclient.domain.model.Transaction;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.ui.card.query.CardQueryListener;
import com.example.paycellwebapiclient.ui.card.query.CardQueryViewDto;
import com.example.paycellwebapiclient.ui.card.query.CardViewDto;
import com.example.paycellwebapiclient.ui.card.register.CardRegisterListener;
import com.example.paycellwebapiclient.ui.card.register.CardRegisterViewDto;
import com.example.paycellwebapiclient.ui.payment.inquire.InquireListener;
import com.example.paycellwebapiclient.ui.payment.inquire.InquireViewDto;
import com.example.paycellwebapiclient.ui.payment.provision.CustomerEMailViewDto;
import com.example.paycellwebapiclient.ui.payment.provision.ExtraParameterViewDto;
import com.example.paycellwebapiclient.ui.payment.provision.ProvisionForMarketPlaceListener;
import com.example.paycellwebapiclient.ui.payment.provision.ProvisionForMarketPlaceViewDto;
import com.example.paycellwebapiclient.ui.payment.provision.ProvisionListener;
import com.example.paycellwebapiclient.ui.payment.provision.ProvisionViewDto;
import com.example.paycellwebapiclient.ui.payment.provision.SubMerchantViewDto;
import com.example.paycellwebapiclient.ui.payment.provisionhistory.ProvisionHistoryListener;
import com.example.paycellwebapiclient.ui.payment.provisionhistory.ProvisionHistoryViewDto;
import com.example.paycellwebapiclient.ui.payment.provisionhistory.TransactionViewDto;
import com.example.paycellwebapiclient.ui.payment.refund.RefundListener;
import com.example.paycellwebapiclient.ui.payment.refund.RefundViewDto;
import com.example.paycellwebapiclient.ui.payment.reverse.ReverseListener;
import com.example.paycellwebapiclient.ui.payment.reverse.ReverseViewDto;
import com.example.paycellwebapiclient.ui.payment.summaryreconciliation.SummaryReconciliationListener;
import com.example.paycellwebapiclient.ui.payment.summaryreconciliation.SummaryReconciliationViewDto;
import com.turkcelltech.mf.tpay.web.provision.PaymentType;

@ManagedBean
@ViewScoped
public class CardViewBean extends BaseViewBean
    implements CardRegisterListener, CardQueryListener, ProvisionListener,
    InquireListener, ReverseListener, RefundListener, SummaryReconciliationListener,
    ProvisionHistoryListener, ProvisionForMarketPlaceListener {

  private String connectionMethod;

  private CardQueryViewDto cardQueryViewDto;

  private CardRegisterViewDto cardRegisterViewDto;

  private ProvisionViewDto provisionViewDto;

  private ProvisionForMarketPlaceViewDto provisionForMarketPlaceViewDto;

  private InquireViewDto inquireViewDto;

  private ReverseViewDto reverseViewDto;

  private RefundViewDto refundViewDto;

  private SummaryReconciliationViewDto summaryReconciliationViewDto;

  private ProvisionHistoryViewDto provisionHistoryViewDto;

  private Account account;

  private ThreeDSession threeDSession;

  private Boolean threeDSecureActive;

  @Autowired
  private WebApplicationContext webApplicationContext;


  public CardViewBean() {
    connectionMethod = "REST";
    resetView();
  }

  private void resetView() {
    cardQueryViewDto = new CardQueryViewDto(this);
    cardRegisterViewDto = new CardRegisterViewDto(this);
    provisionViewDto = new ProvisionViewDto(this);
    provisionForMarketPlaceViewDto = new ProvisionForMarketPlaceViewDto(this);
    inquireViewDto = new InquireViewDto(this);
    reverseViewDto = new ReverseViewDto(this);
    refundViewDto = new RefundViewDto(this);
    summaryReconciliationViewDto = new SummaryReconciliationViewDto(this);
    provisionHistoryViewDto = new ProvisionHistoryViewDto(this);
    account = null;
  }

  @Override
  public void queryCards() {
    String extractedMsisdn = cardQueryViewDto.getMsisdn().replaceAll("\\D", "");
    if (extractedMsisdn.isEmpty()) {
      resetView();
      return;
    }
    account = webApplicationContext.getBean(Account.class, extractedMsisdn);
    try {
      account.loadCards(getClientIPAddress(), enumConnectionMethod());
      List<CardViewDto> cardViewDtoList = new ArrayList<>();
      for (Card card : account.getCardList()) {
        CardViewDto cardViewDto = new CardViewDto();
        BeanUtils.copyProperties(card, cardViewDto);
        cardViewDtoList.add(cardViewDto);
      }
      cardQueryViewDto.setCards(cardViewDtoList);
    } catch (Exception e) {
      error(e.getMessage());
    }
  }

  @Override
  public void registerCard() {
    Map<String, String> parameterMap =
        FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    String cardToken = parameterMap.get("cardToken");
    cardRegisterViewDto.setCardToken(cardToken);
    registerCard(cardToken);
  }

  private void registerCard(String cardToken) {
    try {
      Card card = webApplicationContext.getBean(Card.class);
      card.setAlias(cardRegisterViewDto.getAlias());
      card.setCreditCardNo(cardRegisterViewDto.getCreditCardNo().replaceAll("\\D", ""));
      card.setExpireDateMonth(cardRegisterViewDto.getExpireDate().substring(0, 2));
      card.setExpireDateYear(cardRegisterViewDto.getExpireDate().substring(3, 5));
      card.setCvcNo(cardRegisterViewDto.getCvcNo());
      card.setIsDefault(cardRegisterViewDto.getIsDefault());
      card.setCardToken(cardToken);
      account.registerCard(card, getClientIPAddress(), enumConnectionMethod());
      info("Registered successfully.");
      queryCards();
      cardRegisterViewDto = new CardRegisterViewDto(this);
    } catch (Exception e) {
      e.printStackTrace();
      error(e.getMessage());
    }
  }

  @Override
  public void registerCardThreeD() {
    Map<String, String> parameterMap =
        FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    String cardToken = parameterMap.get("cardToken");
    cardRegisterViewDto.setCardToken(cardToken);

    try {
      threeDSession = webApplicationContext.getBean(ThreeDSession.class);
      threeDSession.setCardToken(cardToken);
      account.startThreeDSessionForCard(threeDSession, getClientIPAddress());
      cardRegisterViewDto.setThreeDSessionId(threeDSession.getThreeDSessionId());

      openThreeDSecurePage();
    } catch (Exception e) {
      threeDSession = null;
      closeThreeDSecurePage();
      error(e.getMessage());
    }
  }

  @Override
  public void listenRegisterCardTreeD() {
    waitForThreeDResult((t) -> {
      registerCard(cardRegisterViewDto.getCardToken());
    });
  }

  @Override
  public void updateCard(CardViewDto updatedCardViewDto) {
    try {
      Card updatedCard = webApplicationContext.getBean(Card.class);
      BeanUtils.copyProperties(updatedCardViewDto, updatedCard);
      account.updateCard(updatedCard, getClientIPAddress(), enumConnectionMethod());
      info("Updated successfully.");
      queryCards();
    } catch (Exception e) {
      error(e.getMessage());
    }
  }

  @Override
  public void updateCardThreeD(CardViewDto updatedCardViewDto) {
    try {
      threeDSession = webApplicationContext.getBean(ThreeDSession.class);
      threeDSession.setCardId(updatedCardViewDto.getCardId());
      account.startThreeDSessionForCard(threeDSession, getClientIPAddress());
      cardQueryViewDto.setThreeDSessionId(threeDSession.getThreeDSessionId());

      openThreeDSecurePage();
    } catch (Exception e) {
      threeDSession = null;
      closeThreeDSecurePage();
      error(e.getMessage());
    }
  }

  @Override
  public void listenUpdateCardThreeD(CardViewDto updatedCardViewDto) {
    waitForThreeDResult((t) -> {
      updateCard(updatedCardViewDto);
    });
  }

  @Override
  public void deleteCard(CardViewDto deletedCardViewDto) {
    Card deletedCard = webApplicationContext.getBean(Card.class);
    BeanUtils.copyProperties(deletedCardViewDto, deletedCard);
    try {
      account.deleteCard(deletedCard, getClientIPAddress(), enumConnectionMethod());
      info("Deleted successfully.");
      queryCards();
    } catch (Exception e) {
      error(e.getMessage());
    }
  }

  @Override
  public void sendProvision() {
    Map<String, String> parameterMap =
        FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    String cardToken = parameterMap.get("cardToken");
    provisionViewDto.setThreeDSessionId(null);
    provisionViewDto.setReferenceNumber(null);

    sendProvision(cardToken);
  }

  private void sendProvision(String cardToken) {
    Provision provision = webApplicationContext.getBean(Provision.class);
    BeanUtils.copyProperties(provisionViewDto, provision);
    provision.setPaymentType(PaymentType.fromValue(provisionViewDto.getPaymentType()));
    try {
      if (isRegisteredCardAvailable()) {
        account.provision(provision, cardQueryViewDto.getSelectedCard().getCardId(),
            cardToken, getClientIPAddress(), enumConnectionMethod());
      } else {
        account.provision(provision, null, cardToken, getClientIPAddress(),
            enumConnectionMethod());
      }
      provisionViewDto.setReferenceNumber(provision.getReferenceNumber());
      provisionViewDto.setThreeDSessionId(provision.getThreeDSessionId());
      info("Provision is sent successfully.");
    } catch (Exception e) {
      error(e.getMessage());
    }
  }

  @Override
  public void sendProvisionThreeD() {
    Map<String, String> parameterMap =
        FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    String cardToken = parameterMap.get("cardToken");
    provisionViewDto.setThreeDSessionId(null);
    provisionViewDto.setReferenceNumber(null);

    try {
      threeDSession = webApplicationContext.getBean(ThreeDSession.class);
      threeDSession.setAmount(provisionViewDto.getAmount());
      threeDSession.setInstallmentCount(provisionViewDto.getInstallmentCount());

      if (isRegisteredCardAvailable()) {
        threeDSession.setCardId(cardQueryViewDto.getSelectedCard().getCardId());
        threeDSession.setCardToken(cardToken);
      } else {
        threeDSession.setCardToken(cardToken);
      }

      account.startThreeDSessionForProvision(threeDSession, getClientIPAddress());
      provisionViewDto.setThreeDSessionId(threeDSession.getThreeDSessionId());

      openThreeDSecurePage();

    } catch (Exception e) {
      threeDSession = null;
      closeThreeDSecurePage();
      error(e.getMessage());
    }
  }

  @Override
  public void listenProvisionThreeD() {
    waitForThreeDResult((t) -> {
      sendProvision(t.getCardToken());
    });
  }

  @Override
  public void sendProvisionForMarketPlace() {
    Map<String, String> parameterMap =
        FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    String cardToken = parameterMap.get("cardToken");
    provisionForMarketPlaceViewDto.setThreeDSessionId(null);
    provisionForMarketPlaceViewDto.setReferenceNumber(null);
    sendProvisionForMarketPlace(cardToken);
  }

  private void sendProvisionForMarketPlace(String cardToken) {
    try {
      ProvisionForMarketPlace provisionForMarketPlace = prepareProvisionForMarketPlace();
      if (isRegisteredCardAvailable()) {
        account.provisionForMarketPlace(provisionForMarketPlace,
            cardQueryViewDto.getSelectedCard().getCardId(), cardToken,
            getClientIPAddress(), enumConnectionMethod());
      } else {
        account.provisionForMarketPlace(provisionForMarketPlace, null, cardToken,
            getClientIPAddress(), enumConnectionMethod());
      }
      provisionForMarketPlaceViewDto
          .setReferenceNumber(provisionForMarketPlace.getReferenceNumber());
      info("Provision is sent successfully.");
    } catch (Exception e) {
      error(e.getMessage());
    }
  }

  @Override
  public void sendProvisionForMarketPlaceThreeD() {
    Map<String, String> parameterMap =
        FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    String cardToken = parameterMap.get("cardToken");
    provisionForMarketPlaceViewDto.setThreeDSessionId(null);
    provisionForMarketPlaceViewDto.setReferenceNumber(null);

    try {
      threeDSession = webApplicationContext.getBean(ThreeDSession.class);
      if (isRegisteredCardAvailable()) {
        threeDSession.setCardId(cardQueryViewDto.getSelectedCard().getCardId());
        threeDSession.setCardToken(cardToken);
      } else {
        threeDSession.setCardToken(cardToken);
      }
      threeDSession.setAmount(provisionForMarketPlaceViewDto.getAmount());
      threeDSession
          .setInstallmentCount(provisionForMarketPlaceViewDto.getInstallmentCount());
      account.startThreeDSessionForProvision(threeDSession, getClientIPAddress());
      provisionForMarketPlaceViewDto
          .setThreeDSessionId(threeDSession.getThreeDSessionId());

      openThreeDSecurePage();

    } catch (Exception e) {
      threeDSession = null;
      closeThreeDSecurePage();
      error(e.getMessage());
    }

  }

  @Override
  public void listenProvisionForMarketPlaceThreeD() {
    waitForThreeDResult((t) -> {
      sendProvisionForMarketPlace(t.getCardToken());
    });
  }

  private ProvisionForMarketPlace prepareProvisionForMarketPlace() {
    ProvisionForMarketPlace provisionForMarketPlace =
        webApplicationContext.getBean(ProvisionForMarketPlace.class);
    BeanUtils.copyProperties(provisionForMarketPlaceViewDto, provisionForMarketPlace);
    provisionForMarketPlace.setPaymentType(
        PaymentType.fromValue(provisionForMarketPlaceViewDto.getPaymentType()));
    for (ExtraParameterViewDto extraParameterViewDto : provisionForMarketPlaceViewDto
        .getExtraParameterList()) {
      if (StringUtils.isNoneBlank(extraParameterViewDto.getKey(),
          extraParameterViewDto.getValue())) {
        ExtraParameter extraParameter =
            webApplicationContext.getBean(ExtraParameter.class);
        BeanUtils.copyProperties(extraParameterViewDto, extraParameter);
        provisionForMarketPlace.getExtraParameterList().add(extraParameter);
      }
    }
    for (SubMerchantViewDto subMerchantViewDto : provisionForMarketPlaceViewDto
        .getSubMerchantList()) {
      if (StringUtils.isNoneBlank(subMerchantViewDto.getSubMerchantKey(),
          subMerchantViewDto.getSubMerchantPrice())) {
        SubMerchant subMerchant = webApplicationContext.getBean(SubMerchant.class);
        BeanUtils.copyProperties(subMerchantViewDto, subMerchant);
        provisionForMarketPlace.getSubMerchantList().add(subMerchant);
      }
    }
    for (CustomerEMailViewDto customerEMailViewDto : provisionForMarketPlaceViewDto
        .getCustomerEMailList()) {
      if (StringUtils.isNoneBlank(customerEMailViewDto.geteMail())) {
        CustomerEMail customerEMail = webApplicationContext.getBean(CustomerEMail.class);
        BeanUtils.copyProperties(customerEMailViewDto, customerEMail);
        provisionForMarketPlace.getCustomerEMailList().add(customerEMail);
      }
    }
    return provisionForMarketPlace;
  }

  @Override
  public void addExtraParameter() {
    ExtraParameterViewDto extraParameterViewDto = new ExtraParameterViewDto();
    int id = provisionForMarketPlaceViewDto.getExtraParameterList().size() + 1;
    extraParameterViewDto.setId(String.valueOf(id));
    provisionForMarketPlaceViewDto.getExtraParameterList().add(extraParameterViewDto);
  }

  @Override
  public void addSubMerchant() {
    SubMerchantViewDto subMerchantViewDto = new SubMerchantViewDto();
    int id = provisionForMarketPlaceViewDto.getSubMerchantList().size() + 1;
    subMerchantViewDto.setId(String.valueOf(id));
    provisionForMarketPlaceViewDto.getSubMerchantList().add(subMerchantViewDto);
  }

  @Override
  public void addCustomerEMail() {
    CustomerEMailViewDto customerEMail = new CustomerEMailViewDto();
    int id = provisionForMarketPlaceViewDto.getCustomerEMailList().size() + 1;
    customerEMail.setId(String.valueOf(id));
    provisionForMarketPlaceViewDto.getCustomerEMailList().add(customerEMail);
  }

  @Override
  public void deleteExtraParameter(String id) {
    for (ExtraParameterViewDto extraParameterViewDto : provisionForMarketPlaceViewDto
        .getExtraParameterList()) {
      if (extraParameterViewDto.getId().equals(id)) {
        provisionForMarketPlaceViewDto.getExtraParameterList()
            .remove(extraParameterViewDto);
        break;
      }
    }
  }

  @Override
  public void deleteSubMerchant(String id) {
    for (SubMerchantViewDto subMerchantViewDto : provisionForMarketPlaceViewDto
        .getSubMerchantList()) {
      if (subMerchantViewDto.getId().equals(id)) {
        provisionForMarketPlaceViewDto.getSubMerchantList().remove(subMerchantViewDto);
        break;
      }
    }
  }

  @Override
  public void deleteCustomerEMail(String id) {
    for (CustomerEMailViewDto customerEMailViewDto : provisionForMarketPlaceViewDto
        .getCustomerEMailList()) {
      if (customerEMailViewDto.getId().equals(id)) {
        provisionForMarketPlaceViewDto.getCustomerEMailList()
            .remove(customerEMailViewDto);
        break;
      }
    }
  }

  @Override
  public void inquire() {
    try {
      Inquire inquire = account.inquire(inquireViewDto.getOriginalReferenceNumber(),
          getClientIPAddress(), enumConnectionMethod());
      BeanUtils.copyProperties(inquire, inquireViewDto, "provisionList");
      inquireViewDto.setProvisionList(new ArrayList<>());
      for (Provision provision : inquire.getProvisionList()) {
        ProvisionViewDto provisionViewDto = new ProvisionViewDto(null);
        BeanUtils.copyProperties(provision, provisionViewDto);
        inquireViewDto.getProvisionList().add(provisionViewDto);
      }
    } catch (Exception e) {
      error(e.getMessage());
    }
  }

  @Override
  public void reverse() {
    try {
      Reverse reverse = webApplicationContext.getBean(Reverse.class);
      reverse.setOriginalReferenceNumber(reverseViewDto.getOriginalReferenceNumber());
      account.reverse(reverse, getClientIPAddress(), enumConnectionMethod());
      reverseViewDto.setReferenceNumber(reverse.getReferenceNumber());
      info("Reverse operation is successful");
    } catch (Exception e) {
      error(e.getMessage());
    }
  }

  @Override
  public void refund() {
    try {
      Refund refund = webApplicationContext.getBean(Refund.class);
      refund.setOriginalReferenceNumber(refundViewDto.getOriginalReferenceNumber());
      refund.setAmount(refundViewDto.getAmount());
      refund.setPointAmount(refundViewDto.getPointAmount());
      account.refund(refund, getClientIPAddress(), enumConnectionMethod());
      refundViewDto.setReferenceNumber(refund.getReferenceNumber());
      info("Refund operation is successful");
    } catch (Exception e) {
      error(e.getMessage());
    }
  }

  @Override
  public void summaryReconciliation() {
    try {
      SummaryReconciliation summaryReconciliation =
          webApplicationContext.getBean(SummaryReconciliation.class);
      summaryReconciliation
          .setReconciliationDate(summaryReconciliationViewDto.getReconciliationDate());
      summaryReconciliation
          .setTotalSaleAmount(summaryReconciliationViewDto.getTotalSaleAmount());
      summaryReconciliation
          .setTotalReverseAmount(summaryReconciliationViewDto.getTotalReverseAmount());
      summaryReconciliation
          .setTotalRefundAmount(summaryReconciliationViewDto.getTotalRefundAmount());
      summaryReconciliation.setTotalSaleCount(
          Integer.valueOf(summaryReconciliationViewDto.getTotalSaleCount()));
      summaryReconciliation.setTotalReverseCount(
          Integer.valueOf(summaryReconciliationViewDto.getTotalReverseCount()));
      summaryReconciliation.setTotalRefundCount(
          Integer.valueOf(summaryReconciliationViewDto.getTotalRefundCount()));
      summaryReconciliation.summaryReconciliation(getClientIPAddress(),
          enumConnectionMethod());

      BeanUtils.copyProperties(summaryReconciliation, summaryReconciliationViewDto);
      summaryReconciliationViewDto.setResponseTotalSaleCount(
          summaryReconciliation.getResponseTotalSaleCount().toString());
      summaryReconciliationViewDto.setResponseTotalReverseCount(
          summaryReconciliation.getResponseTotalReverseCount().toString());
      summaryReconciliationViewDto.setResponseTotalRefundCount(
          summaryReconciliation.getResponseTotalRefundCount().toString());

    } catch (Exception e) {
      error(e.getMessage());
    }
  }

  @Override
  public void retrieveProvisionHistory() {
    try {
      provisionHistoryViewDto.setTransactionList(new ArrayList<>());
      ProvisionHistory provisionHistory =
          webApplicationContext.getBean(ProvisionHistory.class);
      provisionHistory
          .setReconciliationDate(provisionHistoryViewDto.getReconciliationDate());
      provisionHistory.retrieveProvisionHistory(getClientIPAddress(),
          enumConnectionMethod());
      for (Transaction transaction : provisionHistory.getTransactionList()) {
        TransactionViewDto transactionViewDto = new TransactionViewDto();
        BeanUtils.copyProperties(transaction, transactionViewDto, "transactionParams");
        transactionViewDto.setTransactionParams(transaction.getTransactionParams() != null
            ? StringUtils.join(transaction.getTransactionParams(), ",")
            : null);
        provisionHistoryViewDto.getTransactionList().add(transactionViewDto);
      }
    } catch (Exception e) {
      error(e.getMessage());
    }
  }

  public boolean isAccountSet() {
    return account != null;
  }

  public boolean isPaymentMethodAvailable() {
    boolean registeredCardAvailable = isRegisteredCardAvailable();

    boolean customCardAvailable = isCustomCardAvailabe();
    return registeredCardAvailable || customCardAvailable;
  }

  public boolean isRegisteredCardAvailable() {
    return cardQueryViewDto.getSelectedCard() != null;
  }

  public boolean isCustomCardAvailabe() {
    CardViewDto customCard = cardQueryViewDto.getCustomCard();
    return StringUtils.isNoneBlank(customCard.getCreditCardNo(),
        customCard.getExpireDateMonth(), customCard.getExpireDateYear());
  }

  private void openThreeDSecurePage() {
    PrimeFaces.current().executeScript(String.format("openThreeDSecurePage('%s','%s')",
        threeDSession.getThreeDSessionId(), ""));
  }

  private void closeThreeDSecurePage() {
    PrimeFaces.current().executeScript("closeThreeDSecurePage()");
  }

  private void waitForThreeDResult(Consumer<ThreeDSession> threeDSessionConsumer) {
    if (threeDSession == null) {
      return;
    }
    try {
      Date startTime = new Date();
      do {
        Thread.sleep(5000);
        try {
          account.checkThreeDSessionResult(threeDSession, getClientIPAddress());
        } catch (Exception e) {
        }
      } while (!timeLimitExceeded(startTime, 60000)
          && (threeDSession.getThreeDResult() == null || !threeDSession.getThreeDResult()
              .contentEquals(PaycellWebApiConstants.SUCCESS_CODE)));
      if (threeDSession.getThreeDResult()
          .contentEquals(PaycellWebApiConstants.SUCCESS_CODE)) {
        threeDSessionConsumer.accept(threeDSession);
        threeDSession = null;
      } else {
        throw new Exception("3D Secure timeout limit is reached.");
      }
    } catch (Exception e) {
      threeDSession = null;
      error(e.getMessage());
    }
  }

  private boolean timeLimitExceeded(Date startTime, int timeoutLimit) {
    return new Date().getTime() - startTime.getTime() > timeoutLimit;
  }

  private String getClientIPAddress() {
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
        .getExternalContext().getRequest();
    String ipAddress = request.getHeader("X-FORWARDED-FOR");
    if (ipAddress == null) {
      ipAddress = request.getRemoteAddr();
    }
    return ipAddress;
  }

  private ConnectionMethod enumConnectionMethod() {
    return connectionMethod.contentEquals("SOAP") ? ConnectionMethod.SOAP
        : ConnectionMethod.REST;
  }

  public CardQueryViewDto getCardQueryViewDto() {
    return cardQueryViewDto;
  }

  public void setCardQueryViewDto(CardQueryViewDto cardQueryViewDto) {
    this.cardQueryViewDto = cardQueryViewDto;
  }

  public CardRegisterViewDto getCardRegisterViewDto() {
    return cardRegisterViewDto;
  }

  public void setCardRegisterViewDto(CardRegisterViewDto cardRegisterViewDto) {
    this.cardRegisterViewDto = cardRegisterViewDto;
  }

  public ProvisionViewDto getProvisionViewDto() {
    return provisionViewDto;
  }

  public void setProvisionViewDto(ProvisionViewDto provisionViewDto) {
    this.provisionViewDto = provisionViewDto;
  }

  public InquireViewDto getInquireViewDto() {
    return inquireViewDto;
  }

  public void setInquireViewDto(InquireViewDto inquireViewDto) {
    this.inquireViewDto = inquireViewDto;
  }

  public ReverseViewDto getReverseViewDto() {
    return reverseViewDto;
  }

  public void setReverseViewDto(ReverseViewDto reverseViewDto) {
    this.reverseViewDto = reverseViewDto;
  }

  public RefundViewDto getRefundViewDto() {
    return refundViewDto;
  }

  public void setRefundViewDto(RefundViewDto refundViewDto) {
    this.refundViewDto = refundViewDto;
  }

  public SummaryReconciliationViewDto getSummaryReconciliationViewDto() {
    return summaryReconciliationViewDto;
  }

  public void setSummaryReconciliationViewDto(
      SummaryReconciliationViewDto summaryReconciliationViewDto) {
    this.summaryReconciliationViewDto = summaryReconciliationViewDto;
  }

  public ProvisionHistoryViewDto getProvisionHistoryViewDto() {
    return provisionHistoryViewDto;
  }

  public void setProvisionHistoryViewDto(
      ProvisionHistoryViewDto provisionHistoryViewDto) {
    this.provisionHistoryViewDto = provisionHistoryViewDto;
  }

  public ProvisionForMarketPlaceViewDto getProvisionForMarketPlaceViewDto() {
    return provisionForMarketPlaceViewDto;
  }

  public void setProvisionForMarketPlaceViewDto(
      ProvisionForMarketPlaceViewDto provisionForMarketPlaceViewDto) {
    this.provisionForMarketPlaceViewDto = provisionForMarketPlaceViewDto;
  }

  public String getConnectionMethod() {
    return connectionMethod;
  }

  public void setConnectionMethod(String connectionMethod) {
    this.connectionMethod = connectionMethod;
  }

  public Boolean getThreeDSecureActive() {
    return threeDSecureActive;
  }

  public void setThreeDSecureActive(Boolean threeDSecureActive) {
    this.threeDSecureActive = threeDSecureActive;
  }

}
