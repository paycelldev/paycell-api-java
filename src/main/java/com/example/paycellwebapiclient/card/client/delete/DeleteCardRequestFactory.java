package com.example.paycellwebapiclient.card.client.delete;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.common.util.UniqueIdGenerator;
import com.turkcelltech.mf.tpay.web.provision.DeleteCardRequest;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;

public class DeleteCardRequestFactory {

  private static final String MSISDN_LONG_PATTERN = "\\d{12}";

  private static final SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");

  private DeleteCardRequest request;

  /**
   * request başlatılır.
   */
  public DeleteCardRequestFactory() {
    request = new DeleteCardRequest();
    request.setRequestHeader(createRequestHeader());
  }

  /**
   *
   * @param clientIPAddress Müşteri IP bilgisi
   * @return
   */
  public DeleteCardRequestFactory setClientIPAddress(String clientIPAddress) {
    request.getRequestHeader().setClientIPAddress(clientIPAddress);
    return this;
  }

  /**
   * Silinmek istenen kartın cardId değeri gönderilir.
   *
   * @param cardId
   * @return
   */
  public DeleteCardRequestFactory setCardId(String cardId) {
    request.setCardId(cardId);
    return this;
  }

  /**
   * Müşterinin uygulamaya login olduğu telefon numarası. Ülke kodu + Telefon No formatında iletilir .
   *
   * @param msisdn
   * @return
   * @throws Exception Msisdn verilen formata uymaz ise fırlatılır.
   */
  public DeleteCardRequestFactory setMsisdn(String msisdn) throws Exception {
    if (!msisdn.matches(MSISDN_LONG_PATTERN)) {
      throw new Exception("Msisdn must match pattern: " + MSISDN_LONG_PATTERN);
    }
    request.setMsisdn(msisdn);
    return this;
  }

  /**
   * Üretilen request döndürülür.
   *
   * @return
   * @throws Exception clientIpAddress/cardId/msisdn boş ise fırlatılır.
   */
  public DeleteCardRequest build() throws Exception {
    validate();
    return request;
  }

  /**
   *
   * @throws Exception clientIpAddress/cardId/msisdn boş ise fırlatılır.
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
    requestHeader.setApplicationName(PaycellWebApiConstants.APPLICATION_NAME);
    requestHeader.setApplicationPwd(PaycellWebApiConstants.APPLICATION_PASSWORD);
    requestHeader.setTransactionDateTime(sdf.format(new Date()));
    requestHeader.setTransactionId(UniqueIdGenerator.generateTransactionId());
    return requestHeader;
  }

}
