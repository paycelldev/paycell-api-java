package com.example.paycellwebapiclient.threedsession.get;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.common.util.UniqueIdGenerator;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;

public class GetThreeDSessionRequestFactory {

  private static final SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
  public static final String MERCHANT_TARGET = "MERCHANT";
  public static final String PAYCELL_TARGET = "PAYCELL";
  private static final String MSISDN_LONG_PATTERN = "\\d{12}";
  private static final String MSISDN_PATTERN = "\\d{10}";
  private GetThreeDSessionRequest request;

  /**
   * Request başlatılır.
   */
  public GetThreeDSessionRequestFactory() {
    request = new GetThreeDSessionRequest();
    request.setRequestHeader(createRequestHeader());
  }

  /**
   *
   * @param clientIPAddress Müşteri IP bilgisi
   * @return
   */
  public GetThreeDSessionRequestFactory setClientIPAddress(String clientIPAddress) {
    request.getRequestHeader().setClientIPAddress(clientIPAddress);
    return this;
  }

  /**
   * Müşterinin uygulamaya login olduğu telefon numarası. Ülke kodu bilgisi iletilmez.
   *
   * @param msisdn
   * @return
   * @throws Exception
   */
  public GetThreeDSessionRequestFactory setMsisdn(String msisdn) throws Exception {
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
   * PAYCELL ve MERCHANT değerlerini alabilir. Provizyon işlemi amacıyla kullanılıyorsa MERCHANT, kart
   * ekleme veya kart güncelleme işlemi amacıyla kullanılıyorsa PAYCELL gönderilir.
   *
   * @param target
   * @return
   * @throws Exception
   */
  public GetThreeDSessionRequestFactory setTarget(String target) throws Exception {
    if (!MERCHANT_TARGET.contentEquals(target) && !PAYCELL_TARGET.contentEquals(target)) {
      throw new Exception("Invalid Target");
    }
    request.setTarget(target);
    return this;
  }

  /**
   * İşlem tutarıdır.Son 2 hane KURUŞ'u ifade eder. Virgül kullanılmaz. Örnekler: 1TL = 100 15,25TL =
   * 1525 Kart ekleme veye kart güncelleme akışlarında kullanılması durumunda 3D doğrulamada amount
   * olarak 1 kuruş iletilebilir.
   *
   * @param amount
   * @return
   */
  public GetThreeDSessionRequestFactory setAmount(String amount) {
    request.setAmount(amount);
    return this;
  }

  /**
   * Taksit sayısı bilgisidir. Taksitsiz işlemlerde boş olarak veya 0 olarak gönderilebilir.
   *
   * @param installmentCount
   * @return
   * @throws Exception
   */
  public GetThreeDSessionRequestFactory setInstallmentCount(String installmentCount)
      throws Exception {
    try {
      Integer valueOfInstallmentCount =
          installmentCount != null ? Integer.valueOf(installmentCount) : null;
      if (valueOfInstallmentCount == null || valueOfInstallmentCount == 0
          || valueOfInstallmentCount > 1) {
        request.setInstallmentCount(installmentCount);
      } else {
        throw new Exception("Installment count may be 0 or greater than 1.");
      }
    } catch (NumberFormatException e) {
      throw new Exception("Invalid Installment Count.");
    }
    return this;
  }

  /**
   * AUTH, PREAUTH
   *
   * @param transactionType
   * @return
   */
  public GetThreeDSessionRequestFactory setTransactionType(String transactionType) {
    request.setTransactionType(transactionType);
    return this;
  }

  /**
   * Paycell’de tanımlı kart ile işlem yapılırsa gönderilir.
   *
   * @param cardId
   * @return
   */
  public GetThreeDSessionRequestFactory setCardId(String cardId) {
    request.setCardId(cardId);
    return this;
  }

  /**
   * Kart numarası girilerek işlem yapılırsa gönderilir.
   *
   * @param cardToken
   * @return
   */
  public GetThreeDSessionRequestFactory setCardToken(String cardToken) {
    request.setCardToken(cardToken);
    return this;
  }

  /**
   * Üretilen request döndürülür.
   *
   * @return
   * @throws Exception clientIpAddress/msisdn/target/transactionType boş ise fırlatılır.
   */
  public GetThreeDSessionRequest build() throws Exception {
    validate();
    preBuild();
    return request;
  }

  /**
   *
   * @throws Exception clientIpAddress/msisdn/target/transactionType boş ise fırlatılır.
   */
  private void validate() throws Exception {
    if (request.getRequestHeader().getClientIPAddress() == null) {
      throw new Exception("ClientIpAddress must be set first.");
    }
    if (request.getMsisdn() == null) {
      throw new Exception("Msisdn must be set first.");
    }
    if (request.getTarget() == null) {
      throw new Exception("Target must be set first.");
    }
    if (request.getTransactionType() == null) {
      throw new Exception("TransactionType must be set first.");
    }
  }

  /**
   * Provisino işlemleri için merchant code iletilir.
   */
  private void preBuild() {
    if (request.getTarget().contentEquals(MERCHANT_TARGET)) {
      request.setMerchantCode(PaycellWebApiConstants.MERCHANT_CODE);
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
