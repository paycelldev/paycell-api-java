package com.example.paycellwebapiclient.card.client.update;

import static com.example.paycellwebapiclient.common.util.PaycellWebApiConstants.APPLICATION_NAME;
import static com.example.paycellwebapiclient.common.util.PaycellWebApiConstants.APPLICATION_PASSWORD;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.paycellwebapiclient.common.util.UniqueIdGenerator;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;
import com.turkcelltech.mf.tpay.web.provision.UpdateCardRequest;

public class UpdateCardRequestFactory {

  private static final String MSISDN_LONG_PATTERN = "\\d{12}";

  private static final SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");

  private UpdateCardRequest request;

  /**
   * request başlatılır.
   *
   * eulaId: Müşterinin ekleyeceği kart için imzalamış olduğu güncel sözleşme metni versiyon numarası
   */
  public UpdateCardRequestFactory() {
    request = new UpdateCardRequest();
    request.setRequestHeader(createRequestHeader());
  }

  /**
   * Müşteri IP bilgisi
   *
   * @param clientIPAddress
   * @return
   */
  public UpdateCardRequestFactory setClientIPAddress(String clientIPAddress) {
    request.getRequestHeader().setClientIPAddress(clientIPAddress);
    return this;
  }

  /**
   * Bilgisi güncellenmek istenen kartın cardId değeri gönderilir.
   *
   * @param cardId
   * @return
   */
  public UpdateCardRequestFactory setCardId(String cardId) {
    request.setCardId(cardId);
    return this;
  }

  /**
   * Seçilen kart default olarak set edilmek isteniyorsa True gönderilir, diğer durumlarda bu alan
   * gönderilmez.
   *
   * @param isDefault
   * @return
   */
  public UpdateCardRequestFactory setIsDefault(Boolean isDefault) {
    request.setIsDefault(isDefault);
    return this;
  }

  /**
   * Müşterinin uygulamaya login olduğu telefon numarası. Ülke kodu + Telefon No formatında iletilir.
   *
   * @param msisdn
   * @return
   * @throws Exception msisdn verilen formata uymadığı zaman fırlatılır.
   */
  public UpdateCardRequestFactory setMsisdn(String msisdn) throws Exception {
    if (!msisdn.matches(MSISDN_LONG_PATTERN)) {
      throw new Exception("Msisdn must match pattern: " + MSISDN_LONG_PATTERN);
    }
    request.setMsisdn(msisdn);
    return this;
  }

  /**
   * Müşteri alias bilgisini değiştirmek istiyorsa güncellenecek değer iletilir.
   *
   * @param alias
   * @return
   */
  public UpdateCardRequestFactory setAlias(String alias) {
    request.setAlias(alias);
    return this;
  }

  /**
   * 3D doğrulama yöntemi ile eklenmemiş bir kart için 3D doğrulama yapılarak 3DValidasyon bilgisinin
   * güncellenmesi isteniyorsa bu alan gönderilir. getThreeDSession servisi cevabında dönülen session
   * ID değeri iletilir.
   *
   * @param threeDSessionId
   * @return
   */
  public UpdateCardRequestFactory setThreeDSessionId(String threeDSessionId) {
    request.setThreeDSessionId(threeDSessionId);
    return this;
  }

  /**
   * Kartın güncel sözleşme metni versiyon numarası iletilir.
   * @param eulaId
   * @return
   */
  public UpdateCardRequestFactory setEulaId(String eulaId) {
    request.setEulaId(eulaId);
    return this;
  }

  /**
   * Üretilen request döndürülür.
   *
   * @return
   * @throws Exception clientIpAddress/cardId/msisdn/eulaId boş ise fırlatılır.
   */
  public UpdateCardRequest build() throws Exception {
    validate();
    return request;
  }

  /**
   *
   * @throws Exception clientIpAddress/cardId/msisdn/eulaId boş ise fırlatılır.
   */
  private void validate() throws Exception {
    if (request.getRequestHeader().getClientIPAddress() == null) {
      throw new Exception("ClientIpAddress must be set first.");
    }
    if (request.getCardId() == null) {
      throw new Exception("CardId must be set first");
    }
    if (request.getMsisdn() == null) {
      throw new Exception("Msisdn must be set first");
    }
    if (request.getEulaId() == null) {
      throw new Exception("EulaId must be set first");
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
