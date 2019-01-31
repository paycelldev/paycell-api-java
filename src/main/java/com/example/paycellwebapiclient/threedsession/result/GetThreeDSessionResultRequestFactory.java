package com.example.paycellwebapiclient.threedsession.result;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.common.util.UniqueIdGenerator;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;

public class GetThreeDSessionResultRequestFactory {

  private static final SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
  private static final String MSISDN_LONG_PATTERN = "\\d{12}";
  private static final String MSISDN_PATTERN = "\\d{10}";
  private GetThreeDSessionResultRequest request;

  /**
   * request başlatılır.
   */
  public GetThreeDSessionResultRequestFactory() {
    request = new GetThreeDSessionResultRequest();
    request.setRequestHeader(createRequestHeader());
  }

  /**
   *
   * @param clientIPAddress Müşteri IP bilgisi
   * @return
   */
  public GetThreeDSessionResultRequestFactory setClientIPAddress(String clientIPAddress) {
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
  public GetThreeDSessionResultRequestFactory setMsisdn(String msisdn) throws Exception {
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
   * getThreeDSession method’u ile alınan threeDSessionId değeridir.
   *
   * @param threeDSessionId
   * @return
   */
  public GetThreeDSessionResultRequestFactory setThreeDSessionId(String threeDSessionId) {
    request.setThreeDSessionId(threeDSessionId);
    return this;
  }

  /**
   * Target=MERCHANT olduğunda iletilir. Akaryakıt ödeme işlemlerinde kullanılır. Üye işyeri
   * uygulaması üzerinden başlatılan normal ödeme işlemlerinde gönderilmez.
   *
   * @return
   */
  public GetThreeDSessionResultRequestFactory includeReferenceNumber() {
    request.setReferenceNumber(UniqueIdGenerator.generateReferenceNumber());
    return this;
  }

  /**
   * Target=MERCHANT olduğunda iletilir. Ödeme işleminin başlatıldığı Paycell’de tanımlı üye işyeri
   * kodu bilgisi gönderilir. Entegrasyon sonrasında her tanımlanan yeni üye işyeri için Paycell
   * tarafından merchantCode değeri paylaşılır.
   *
   * @return
   */
  public GetThreeDSessionResultRequestFactory includeMerchantCode() {
    request.setMerchantCode(PaycellWebApiConstants.MERCHANT_CODE);
    return this;
  }

  /**
   * Üretilen request döndürülür.
   *
   * @return
   * @throws Exception clientIpAddress/msisdn/threeDSessionId boş ise fırlatılıt.
   */
  public GetThreeDSessionResultRequest build() throws Exception {
    validate();
    return request;
  }

  /**
   *
   * @throws Exception clientIpAddress/msisdn/threeDSessionId boş ise fırlatılıt.
   */
  private void validate() throws Exception {
    if (request.getRequestHeader().getClientIPAddress() == null) {
      throw new Exception("ClientIpAddress must be set first.");
    }
    if (request.getMsisdn() == null) {
      throw new Exception("Msisdn must be set first.");
    }
    if (request.getThreeDSessionId() == null) {
      throw new Exception("ThreeDSessionId must be set first.");
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
