package com.example.paycellwebapiclient.payment.client.refund;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.common.util.UniqueIdGenerator;
import com.turkcelltech.mf.tpay.web.provision.RefundRequest;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;

public class RefundRequestFactory {

  private static final SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
  private static final String MSISDN_LONG_PATTERN = "\\d{12}";
  private static final String MSISDN_PATTERN = "\\d{10}";
  private RefundRequest request;

  /**
   * Requet başlatılır.
   *
   * ReferenceNumber: Üye işyeritarfından üretilen tekil değerdir. Provisiona özgüdür. ilk 3 hanesi
   * Paycell tarafından üye işyeri için tanımlanır. 20 haneli numerik bir değerdir.
   *
   * MerchantCode: Paycell taraffından üye iş yeri için tanımlanır.
   */
  public RefundRequestFactory() {
    request = new RefundRequest();
    request.setRequestHeader(createRequestHeader());
    request.setMerchantCode(PaycellWebApiConstants.MERCHANT_CODE);
    request.setReferenceNumber(UniqueIdGenerator.generateReferenceNumber());
  }

  /**
   *
   * @param clientIPAddress Müşteri IP bilgisi
   * @return
   */
  public RefundRequestFactory setClientIPAddress(String clientIPAddress) {
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
  public RefundRequestFactory setMsisdn(String msisdn) throws Exception {
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
   * İade edilmesi istenen işlem tutarıdır. Son 2 hane KURUŞ'u ifade eder. Virgül kullanılmaz.
   * Örnekler: 1TL = 100 15,25TL = 1525
   *
   * @param amount
   * @return
   */
  public RefundRequestFactory setAmount(String amount) {
    request.setAmount(amount);
    return this;
  }

  /**
   * İleride kullanılmak üzere ayrılmıştır. İade edilmesi istenen kart puan bilgisidir.
   *
   * @param pointAmount
   * @return
   */
  public RefundRequestFactory setPointAmount(String pointAmount) {
    request.setPointAmount(pointAmount);
    return this;
  }

  /**
   * İade edilecek işlemin "referenceNumber" değeridir.
   *
   * @param originalReferenceNumber
   * @return
   */
  public RefundRequestFactory setOriginalReferenceNumber(String originalReferenceNumber) {
    request.setOriginalReferenceNumber(originalReferenceNumber);
    return this;
  }

  /**
   * Oluşturulan request döndürülür.
   *
   * @return
   * @throws Exception clientIpAdress/msisdn/originalReferenceNumber/amount boş ise fırlatılır
   */
  public RefundRequest build() throws Exception {
    validate();
    return request;
  }

  /**
   *
   * @throws Exception clientIpAdress/msisdn/originalReferenceNumber/amount boş ise fırlatılır
   */
  private void validate() throws Exception {
    if (request.getRequestHeader().getClientIPAddress() == null) {
      throw new Exception("ClientIpAdress must be set first");
    }
    if (request.getMsisdn() == null) {
      throw new Exception("Msisdn must be set first.");
    }
    if (request.getOriginalReferenceNumber() == null) {
      throw new Exception("OriginalReferenceNumber must be set first.");
    }
    if (request.getAmount() == null) {
      throw new Exception("Amount must be set first.");
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
