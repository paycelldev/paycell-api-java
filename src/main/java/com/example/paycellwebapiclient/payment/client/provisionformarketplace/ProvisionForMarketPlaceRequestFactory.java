package com.example.paycellwebapiclient.payment.client.provisionformarketplace;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.common.util.UniqueIdGenerator;
import com.turkcelltech.mf.tpay.web.provision.ExtraParameter;
import com.turkcelltech.mf.tpay.web.provision.PaymentType;
import com.turkcelltech.mf.tpay.web.provision.ProvisionForMarketPlaceRequest;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;
import com.turkcelltech.mf.tpay.web.provision.SubMerchant;

public class ProvisionForMarketPlaceRequestFactory {

  private static final SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
  private static final String MSISDN_LONG_PATTERN = "\\d{12}";
  private static final String MSISDN_PATTERN = "\\d{10}";
  private ProvisionForMarketPlaceRequest request;

  /**
   * Requet başlatılır.
   *
   * ReferenceNumber: Üye işyeritarfından üretilen tekil değerdir. Provisiona özgüdür. ilk 3 hanesi
   * Paycell tarafından üye işyeri için tanımlanır. 20 haneli numerik bir değerdir.
   *
   * MerchantCode: Paycell taraffından üye iş yeri için tanımlanır.
   */
  public ProvisionForMarketPlaceRequestFactory() {
    request = new ProvisionForMarketPlaceRequest();
    request.setRequestHeader(createRequestHeader());
    request.setReferenceNumber(UniqueIdGenerator.generateReferenceNumber());
    request.setMerchantCode(PaycellWebApiConstants.MERCHANT_CODE);
  }

  /**
   *
   * @param clientIPAddress Müşteri IP bilgisi
   * @return ProvisionForMarketPlaceRequestFactory
   */
  public ProvisionForMarketPlaceRequestFactory setClientIPAddress(
      String clientIPAddress) {
    request.getRequestHeader().setClientIPAddress(clientIPAddress);
    return this;
  }

  /**
   *
   * @param msisdn Müşteri telefon no ülke kodu olmadan işlenecektir. "\d{10}" formatında olmalıdır.
   * @return ProvisionForMarketPlaceRequestFactory
   * @throws Exception Beklenen formatta bilgi gönderilmediği zaman fırlatılır.
   */
  public ProvisionForMarketPlaceRequestFactory setMsisdn(String msisdn) throws Exception {
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
   * Paycell’de tanımlı kart ile ödeme yapılmak istenmesi durumunda gönderilir.
   *
   * @param cardId
   * @return
   */
  public ProvisionForMarketPlaceRequestFactory setCardId(String cardId) {
    request.setCardId(cardId);
    return this;
  }

  /**
   * İade edilmesi istenen işlem tutarıdır. Son 2 hane KURUŞ'u ifade eder. Virgül kullanılmaz.
   * Örnekler: 1TL = 100 15,25TL = 1525
   *
   * @param amount
   * @return
   */
  public ProvisionForMarketPlaceRequestFactory setAmount(String amount) {
    request.setAmount(amount);
    return this;
  }

  /**
   * şlem döviz cinsini belirler. TRY, EUR, USD, vb.
   *
   * @param currency
   * @return
   */
  public ProvisionForMarketPlaceRequestFactory setCurrency(String currency) {
    request.setCurrency(currency);
    return this;
  }

  /**
   * Taksit sayısı bilgisidir. Taksitsiz işlemlerde boş olarak veya 0 olarak gönderilebilir.
   *
   * @param installmentCount
   * @return
   */
  public ProvisionForMarketPlaceRequestFactory setInstallmentCount(
      Integer installmentCount) {
    request.setInstallmentCount(installmentCount);
    return this;
  }

  /**
   * İleride kullanılmak üzere ayrılmıştır. İade edilmesi istenen kart puan bilgisidir.
   *
   * @param pointAmount
   * @return
   */
  public ProvisionForMarketPlaceRequestFactory setPointAmount(String pointAmount) {
    request.setPointAmount(pointAmount);
    return this;
  }

  /**
   * Ödeme işlem tipini belirtir, ön otorizasyon uygulaması söz konusu değilse SALE değeri gönderilir.
   * [SALE, PREAUTH, POSTAUTH]
   *
   * @param paymentType
   * @return
   */
  public ProvisionForMarketPlaceRequestFactory setPaymentType(PaymentType paymentType) {
    request.setPaymentType(paymentType);
    return this;
  }

  /**
   * İleride kullanılmak üzere ayrılmıştır. Sanal Pos bankası kodu iletilir.
   *
   * @param acquirerBankCode
   * @return
   */
  public ProvisionForMarketPlaceRequestFactory setAcquirerBankCode(
      String acquirerBankCode) {
    request.setAcquirerBankCode(acquirerBankCode);
    return this;
  }

  /**
   * İleride kullanılmak üzere ayrılmıştır. Paycell kullanıcısı PIN değeri iletilir.
   *
   * @param pin
   * @return
   */
  public ProvisionForMarketPlaceRequestFactory setPin(String pin) {
    request.setPin(pin);
    return this;
  }

  /**
   * Ödeme işleminin 3D doğrulama yöntemi ile yapılması durumunda getThreeDSession servisi cevabında
   * alınan session ID bilgisidir.
   *
   * @param threeDSessionId
   * @return
   */
  public ProvisionForMarketPlaceRequestFactory setThreeDSessionId(
      String threeDSessionId) {
    request.setThreeDSessionId(threeDSessionId);
    return this;
  }

  /**
   * Kart numarası girilerek yapılmak istenen ödeme işlemlerinde getCardToken servisi alınan değer
   * veya kayıtlı kart kullanımında cvc ile ödeme yapılmasına ilişkin getCardToken servisi ile cvc
   * karşılığında alınan token değeri.
   *
   * @param cardToken
   * @return
   */
  public ProvisionForMarketPlaceRequestFactory setCardToken(String cardToken) {
    request.setCardToken(cardToken);
    return this;
  }

  /**
   * Ödeme işlemine ilişkin ek bir parametre değeri opsiyonel olarak iletilebilir.
   *
   * @param key
   * @param value
   * @return
   */
  public ProvisionForMarketPlaceRequestFactory addExtraParameter(String key,
      String value) {
    ExtraParameter extraParameter = new ExtraParameter();
    extraParameter.setKey(key);
    extraParameter.setValue(value);
    request.getExtraParameters().add(extraParameter);
    return this;
  }

  /**
   * Ödeme işlemine ilişkin alt üye işyeri bilgileri iletilebilir.
   *
   * @param subMerchantKey
   * @param subMerchantPrice
   * @return
   */
  public ProvisionForMarketPlaceRequestFactory addSubMerchant(String subMerchantKey,
      String subMerchantPrice) {
    SubMerchant subMerchant = new SubMerchant();
    subMerchant.setSubMerchantKey(subMerchantKey);
    subMerchant.setSubMerchantPrice(subMerchantPrice);
    request.getSubMerchants().add(subMerchant);
    return this;
  }

  /**
   * Müşteri email bilgisi iletilir.
   *
   * @param email
   * @return
   */
  public ProvisionForMarketPlaceRequestFactory setCustomerEmail(String email) {
    request.setCustomerEmail(email);
    return this;
  }

  /**
   * Üretilen request döndürülür.
   *
   * @return
   * @throws Exception msisdn/amount/currency/paymentType/clientIAddress boş ise fırlatılır.
   */
  public ProvisionForMarketPlaceRequest build() throws Exception {
    validate();
    return request;
  }

  private void validate() throws Exception {
    if (request.getRequestHeader().getClientIPAddress() == null) {
      throw new Exception("ClientIpAdress must be set first.");
    }
    if (request.getMsisdn() == null) {
      throw new Exception("Msisdn must be set first.");
    }
    if (request.getAmount() == null) {
      throw new Exception("Amount must be set first.");
    }
    if (request.getCurrency() == null) {
      throw new Exception("Currency must be set first.");
    }
    if (request.getPaymentType() == null) {
      throw new Exception("PaymentType must be set first.");
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
