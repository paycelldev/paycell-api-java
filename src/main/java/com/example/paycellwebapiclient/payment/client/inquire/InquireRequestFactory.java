package com.example.paycellwebapiclient.payment.client.inquire;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.common.util.UniqueIdGenerator;
import com.turkcelltech.mf.tpay.web.provision.InquireRequest;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;

public class InquireRequestFactory {

  private static final SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
  private static final String MSISDN_LONG_PATTERN = "\\d{12}";
  private static final String MSISDN_PATTERN = "\\d{10}";
  private InquireRequest request;

  /**
   * Request başlatılır.
   *
   * ReferenasNumber: Üye iş yeri tarafından işlem için oluşturulan tekil nodur. ilk 3 hanesi üye iş
   * yerine özeldir paycell tarafından belirlenir. 20 haneli numeric numaradır.
   *
   * MerchantCode: Üye İş Yerine özeldir. Paycell tarafından belirlenir.
   */
  public InquireRequestFactory() {
    request = new InquireRequest();
    request.setReferenceNumber(UniqueIdGenerator.generateReferenceNumber());
    request.setRequestHeader(createRequestHeader());
    request.setMerchantCode(PaycellWebApiConstants.MERCHANT_CODE);
  }

  /**
   * @param clientIPAddress Müşteri IPsi
   * @return InquireRequestFactory
   */
  public InquireRequestFactory setClientIPAddress(String clientIPAddress) {
    request.getRequestHeader().setClientIPAddress(clientIPAddress);
    return this;
  }

  /**
   * @param msisdn Müşteri telefon nuumarası, ülke kodu dahil edilmeyecek.
   * @return InquireRequestFactory
   * @throws Exception
   */
  public InquireRequestFactory setMsisdn(String msisdn) throws Exception {
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
   * @param originalReferenceNumber sorgulanmak istenen Provision refereans numarası
   * @return InquireRequestFactory
   */
  public InquireRequestFactory setOriginalReferenceNumber(
      String originalReferenceNumber) {
    request.setOriginalReferenceNumber(originalReferenceNumber);
    return this;
  }

  /**
   * Request oluşturulur, gerekli alanlar boş ise uyarı verilir.
   *
   * @return InquireRequest
   * @throws Exception msisdn boş/originalReferenceNumber boş/clientIpAddress boş
   */
  public InquireRequest build() throws Exception {
    validate();
    return request;
  }

  /**
   * Gerekli alanlar kontrol edilir.
   *
   * @throws Exception msisdn boş/originalReferenceNumber boş/clientIpAddress boş
   */
  private void validate() throws Exception {
    if (request.getRequestHeader().getClientIPAddress() == null) {
      throw new Exception("ClientIpAddress must be set first.");
    }
    if (request.getMsisdn() == null) {
      throw new Exception("Msisdn must be set first.");
    }
    if (request.getOriginalReferenceNumber() == null) {
      throw new Exception("OriginalReferenceNumber must be set first.");
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
