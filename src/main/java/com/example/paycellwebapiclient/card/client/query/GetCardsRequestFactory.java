package com.example.paycellwebapiclient.card.client.query;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.common.util.UniqueIdGenerator;
import com.turkcelltech.mf.tpay.web.provision.GetCardsRequest;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;

public class GetCardsRequestFactory {

  private static final String MSISDN_PATTERN = "\\d{10,12}";
  private static final String MSISDN_LONG_PATTERN = "\\d{12}";

  private static final SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");

  private GetCardsRequest request;

  /**
   * request başlatılır.
   */
  public GetCardsRequestFactory() {
    request = new GetCardsRequest();
    request.setRequestHeader(createRequestHeader());
  }

  /**
   *
   * @param clientIPAddress Müşteri IP bilgisi
   * @return
   */
  public GetCardsRequestFactory setClientIPAddress(String clientIPAddress) {
    request.getRequestHeader().setClientIPAddress(clientIPAddress);
    return this;
  }

  /**
   * Müşterinin uygulamaya login olduğu telefon numarası. Ülke kodu iletilmez.
   *
   * @param msisdn
   * @return
   * @throws Exception
   */
  public GetCardsRequestFactory setMsisdn(String msisdn) throws Exception {
    if (msisdn == null || !msisdn.matches(MSISDN_PATTERN)) {
      throw new Exception("msisdn must match pattern: " + MSISDN_PATTERN);
    }
    if (msisdn.matches(MSISDN_LONG_PATTERN)) {
      request.setMsisdn(msisdn.substring(2, 12));
    } else {
      request.setMsisdn(msisdn);
    }
    return this;
  }

  /**
   * Üretilen request döndürülür.
   *
   * @return
   * @throws Exception clientIpAddress/msisdn boş ise fırlatılır.
   */
  public GetCardsRequest build() throws Exception {
    validate();
    return request;
  }

  private void validate() throws Exception {
    if (request.getRequestHeader().getClientIPAddress() == null) {
      throw new Exception("ClientIpAddress must be set first.");
    }
    if (request.getMsisdn() == null) {
      throw new Exception("msisdn must be set");
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
