package com.example.paycellwebapiclient.card.client.register;

import static com.example.paycellwebapiclient.common.util.PaycellWebApiConstants.APPLICATION_NAME;
import static com.example.paycellwebapiclient.common.util.PaycellWebApiConstants.APPLICATION_PASSWORD;
import static com.example.paycellwebapiclient.common.util.PaycellWebApiConstants.EULAID;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.paycellwebapiclient.common.util.UniqueIdGenerator;
import com.turkcelltech.mf.tpay.web.provision.RegisterCardRequest;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;

public class RegisterCardRequestFactory {

  private static final String MSISDN_LONG_PATTERN = "\\d{12}";

  private SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");

  private RegisterCardRequest request;

  /**
   * request başlatılır.
   *
   * eulaId: Müşterinin ekleyeceği kart için imzalamış olduğu güncel sözleşme metni versiyon numarası
   */
  public RegisterCardRequestFactory() {
    request = new RegisterCardRequest();
    request.setEulaId(EULAID);
    request.setRequestHeader(createRequestHeader());
  }

  /**
   *
   * @param clientIPAddress Müşteri IP bilgisi
   * @return
   */
  public RegisterCardRequestFactory setClientIPAddress(String clientIPAddress) {
    request.getRequestHeader().setClientIPAddress(clientIPAddress);
    return this;
  }

  /**
   * Müşterinin eklemek istediği karta vereceği isim bilgisidir.
   *
   * @param alias
   * @return
   */
  public RegisterCardRequestFactory setAlias(String alias) {
    request.setAlias(alias);
    return this;
  }

  /**
   * getCardToken servisi ile alınan token değeridir.
   *
   * @param cardToken
   * @return
   */
  public RegisterCardRequestFactory setCardToken(String cardToken) {
    request.setCardToken(cardToken);
    return this;
  }

  /**
   * Eklenecek kart default olarak belirlenmek isteniyorsa True gönderilir, diğer durumda bu alan
   * gönderilmez.
   *
   * @param isDefault
   * @return
   */
  public RegisterCardRequestFactory setIsDefault(Boolean isDefault) {
    request.setIsDefault(isDefault);
    return this;
  }

  /**
   * Müşterinin uygulamaya login olduğu telefon numarası. Ülke kodu + Telefon No formatında iletilir.
   *
   * @param msisdn
   * @return
   * @throws Exception Msisdn verilen formata uymadığı zaman fırlatılır.
   */
  public RegisterCardRequestFactory setMsisdn(String msisdn) throws Exception {
    if (!msisdn.matches(MSISDN_LONG_PATTERN)) {
      throw new Exception("Msisdn must match pattern: " + MSISDN_LONG_PATTERN);
    }
    request.setMsisdn(msisdn);
    return this;
  }

  /**
   * Kartın 3D doğrulama yöntemi ile eklenmesi durumunda getThreeDSession servisi cevabında dönülen
   * session ID değeri iletilir.
   *
   * @param threeDSessionId
   * @return
   */
  public RegisterCardRequestFactory setThreeDSessionId(String threeDSessionId) {
    request.setThreeDSessionId(threeDSessionId);
    return this;
  }

  /**
   * Üretilen request döndürülür.
   *
   * @return
   * @throws Exception clientIpAddress/cardToken/msisdn bilglier boş ise fırlatılır.
   */
  public RegisterCardRequest build() throws Exception {
    validate();
    return request;
  }

  /**
   *
   * @throws Exception clientIpAddress/cardToken/msisdn bilglier boş ise fırlatılır.
   */
  private void validate() throws Exception {
    if (request.getRequestHeader().getClientIPAddress() == null) {
      throw new Exception("ClientIpAddress must be set first.");
    }
    if (request.getCardToken() == null) {
      throw new Exception("CardToken must be set first");
    }
    if (request.getMsisdn() == null) {
      throw new Exception("Msisdn must be set first");
    }
  }

  /**
   * Request header oluşturulur.
   *
   * ApplicationName: Paycell tarafından kayıt sırasında belirlenerek, üye iş yerine verilir.
   *
   * ApplicationPassword: Paycell tarafından kayıt sırasında belirlenerek, üye iş yerine verilir.
   *
   * TransactionDateTime: işlem tarihi YYYYMMddHHmmssSSS formatı kullanılır.
   *
   * TransactionId: işlem tekil numarasıdır, üye iş yeri tarafından oluşturulur. "\\d{20}" formatında
   * olmalıdır.
   *
   * @return Oluşturulan header bilgisi
   */
  private RequestHeader createRequestHeader() {
    RequestHeader requestHeader = new RequestHeader();
    requestHeader.setApplicationName(APPLICATION_NAME);
    requestHeader.setApplicationPwd(APPLICATION_PASSWORD);
    requestHeader.setTransactionDateTime(sdf.format(new Date()));
    requestHeader.setTransactionId(UniqueIdGenerator.generateTransactionId());
    return requestHeader;
  }

}
