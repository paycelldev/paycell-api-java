package com.example.paycellwebapiclient.payment.client.provision;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.common.util.UniqueIdGenerator;
import com.turkcelltech.mf.tpay.web.provision.ExtraParameter;
import com.turkcelltech.mf.tpay.web.provision.PaymentType;
import com.turkcelltech.mf.tpay.web.provision.ProvisionRequest;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;

public class ProvisionRequestFactory {

  private static final String MSISDN_LONG_PATTERN = "\\d{12}";
  private static final String MSISDN_PATTERN = "\\d{10}";
  private static final SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
  private ProvisionRequest request;

  /**
   * Request başlatılır.
   *
   * ReferenasNumber: Üye iş yeri tarafından işlem için oluşturulan tekil nodur. ilk 3 hanesi üye iş
   * yerine özeldir paycell tarafından belirlenir. 20 haneli numeric numaradır.
   *
   * MerchantCode: Üye İş Yerine özeldir. Paycell tarafından belirlenir.
   */
  public ProvisionRequestFactory() {
    request = new ProvisionRequest();
    request.setMerchantCode(PaycellWebApiConstants.MERCHANT_CODE);
    request.setReferenceNumber(UniqueIdGenerator.generateReferenceNumber());
    request.setRequestHeader(createRequestHeader());
  }

  /**
   *
   * @param clientIPAddress Müşteri IP'si
   * @return ProvisionRequestFactory
   */
  public ProvisionRequestFactory setClientIPAddress(String clientIPAddress) {
    request.getRequestHeader().setClientIPAddress(clientIPAddress);
    return this;
  }

  /**
   *
   * @param msisdn Müşteri telefon numarası "\d{10}" formatında gönderilir. Ülke kodu içermez.
   * @return ProvisionRequestFactory
   * @throws Exception verilen formata uyulmazsa fırlatılır
   */
  public ProvisionRequestFactory setMsisdn(String msisdn) throws Exception {
    if (msisdn.matches(MSISDN_LONG_PATTERN)) {
      request.setMsisdn(msisdn.substring(2, 12));
    } else if (msisdn.matches(MSISDN_PATTERN)) {
      request.setMsisdn(msisdn);
    } else {
      throw new Exception(String.format("msisdn should match one of patterns: %s, %s",
          MSISDN_PATTERN, MSISDN_LONG_PATTERN));
    }
    return this;
  }

  /**
   *
   * @param cardId işlem yapılmak istenen kartın tekil numarasıdır. Kayıtlı olmayan kart ile işlem
   *        yapılıyorsa null gönderilir.
   * @return ProvisionRequestFactory
   */
  public ProvisionRequestFactory setCardId(String cardId) {
    request.setCardId(cardId);
    return this;
  }

  /**
   *
   * @param amount Provision miktarı
   * @return ProvisionRequestFactory
   */
  public ProvisionRequestFactory setAmount(String amount) {
    request.setAmount(amount);
    return this;
  }

  /**
   *
   * @param currency TRY
   * @return ProvisionRequestFactory
   */
  public ProvisionRequestFactory setCurrency(String currency) {
    request.setCurrency(currency);
    return this;
  }

  /**
   *
   * @param installmentCount Taksit sayısı tek çekim işlemler için 0 yada null gönderilir.
   * @return ProvisionRequestFactory
   * @throws Exception Geçersiz taksit sayısı için fırlatılır.
   */
  public ProvisionRequestFactory setInstallmentCount(Integer installmentCount)
      throws Exception {
    if ((installmentCount == null || installmentCount == 0) || installmentCount >= 2) {
      request.setInstallmentCount(installmentCount);
      return this;
    } else {
      throw new Exception("InstallmentCount must be null,0,2 or greater than 2.");
    }
  }

  /**
   * Daha sonrası için saklanmıştır.
   *
   * @param pointAmount
   * @return ProvisionRequestFactory
   */
  public ProvisionRequestFactory setPointAmount(String pointAmount) {
    request.setPointAmount(pointAmount);
    return this;
  }

  /**
   *
   * @param paymentType SALE/PREAUTH/POSTAUTH
   * @return ProvisionRequestFactory
   */
  public ProvisionRequestFactory setPaymentType(PaymentType paymentType) {
    request.setPaymentType(paymentType);
    return this;
  }

  /**
   * İleride kullanılmak üzere ayrılmıştır.
   *
   * @param acquirerBankCode Sanal Pos bankası kodu iletilir.
   * @return ProvisionRequestFactory
   */
  public ProvisionRequestFactory setAcquirerBankCode(String acquirerBankCode) {
    request.setAcquirerBankCode(acquirerBankCode);
    return this;
  }

  /**
   * leride kullanılmak üzere ayrılmıştır.
   *
   * @param pin Paycell kullanıcısı PIN değeri iletilir.
   * @return ProvisionRequestFactory
   */
  public ProvisionRequestFactory setPin(String pin) {
    request.setPin(pin);
    return this;
  }

  /**
   *
   * @param threeDSessionId Ödeme işleminin 3D doğrulama yöntemi ile yapılması durumunda
   *        getThreeDSession servisi cevabında alınan session ID bilgisidir.
   * @return
   */
  public ProvisionRequestFactory setThreeDSessionId(String threeDSessionId) {
    request.setThreeDSessionId(threeDSessionId);
    return this;
  }

  /**
   * @param cardToken Kart numarası girilerek yapılmak istenen ödeme işlemlerinde getCardToken servisi
   *        alınan değer veya kayıtlı kart kullanımında cvc ile ödeme yapılmasına ilişkin getCardToken
   *        servisi ile cvc karşılığında alınan token değeri .
   * @return ProvisionRequestFactory
   */
  public ProvisionRequestFactory setCardToken(String cardToken) {
    request.setCardToken(cardToken);
    return this;
  }

  /**
   * Ödeme işlemine ilişkin ek bir parametre değeri opsiyonel olarak iletilebilir.
   *
   * @param key
   * @param value
   * @return ProvisionRequestFactory
   */
  public ProvisionRequestFactory addExtraParameter(String key, String value) {
    ExtraParameter extraParameter = new ExtraParameter();
    extraParameter.setKey(key);
    extraParameter.setValue(value);
    request.getExtraParameters().add(extraParameter);
    return this;
  }

  /**
   * Oluşturulan request döndürülür
   *
   * @return
   * @throws Exception msisdn/amount/currency/paymenttype/clientIpAddress boş ise fırlatılır.
   */
  public ProvisionRequest build() throws Exception {
    validate();
    return request;
  }

  private void validate() throws Exception {
    if (request.getRequestHeader().getClientIPAddress() == null) {
      throw new Exception("ClientIpAddress must be set first.");
    }
    if (request.getMsisdn() == null) {
      throw new Exception("Msisdn must be set first");
    }
    if (request.getAmount() == null) {
      throw new Exception("Amount must be set first");
    }
    if (request.getCurrency() == null) {
      throw new Exception("Currency must be set first");
    }
    if (request.getPaymentType() == null) {
      throw new Exception("PaymentType must be set first");
    }
  }

  /**
   * Header bilgileri doldurulur.
   *
   * ApplicationName: Paycell tarafından üye iş yeri için tanımlanır.
   *
   * ApplicationPassword: Paycell tarafından üye işyeri için tanımlanır.
   *
   * TransactionDateTime: yyyyMMddHHmmssSSS formatı kullanılır
   *
   * TransactionId: Üye iş yeri tarafından üretilir tekil olmalıdır. 20 Haneli numerik bir değerdir.
   *
   * @return RequestHeader
   */
  private RequestHeader createRequestHeader() {
    RequestHeader requestHeader = new RequestHeader();
    requestHeader.setApplicationName(PaycellWebApiConstants.APPLICATION_NAME);
    requestHeader.setApplicationPwd(PaycellWebApiConstants.APPLICATION_PASSWORD);
    requestHeader.setTransactionDateTime(sdf.format(new Date()));
    requestHeader.setTransactionId(UniqueIdGenerator.generateTransactionId());
    return requestHeader;
  }

}
