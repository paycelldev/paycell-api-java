package com.example.paycellwebapiclient.payment.client.provisionhistory;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.common.util.UniqueIdGenerator;
import com.turkcelltech.mf.tpay.web.provision.GetProvisionHistoryRequest;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;

public class GetProvisionHistoryRequestFactory {

  private static final String RECONCILIATION_DATE_PATTERN = "yyyyMMdd";
  private static final SimpleDateFormat transactionIdSDF =
      new SimpleDateFormat("YYYYMMddHHmmssSSS");
  private static final SimpleDateFormat reconciliationDateSDF =
      new SimpleDateFormat(RECONCILIATION_DATE_PATTERN);
  private GetProvisionHistoryRequest request;

  /**
   * Request başlatılır.
   *
   * MerchantCode: Paycell tarafından üye işyeri için tanımlanır.
   */
  public GetProvisionHistoryRequestFactory() {
    request = new GetProvisionHistoryRequest();
    request.setMerchantCode(PaycellWebApiConstants.MERCHANT_CODE);
    request.setRequestHeader(createRequestHeader());
  }

  /**
   *
   * @param clientIPAddress Müşteri IP bilgisi
   * @return
   */
  public GetProvisionHistoryRequestFactory setClientIPAddress(String clientIPAddress) {
    request.getRequestHeader().setClientIPAddress(clientIPAddress);
    return this;
  }

  /**
   * Çağrım sayısı
   *
   * @param partitionNo
   * @return
   */
  public GetProvisionHistoryRequestFactory setPartitonNo(Integer partitionNo) {
    request.setPartitionNo(partitionNo);
    return this;
  }

  /**
   * İşlemin mutabakatı için PAYCELL sisteminde belirlenen tarih bilgisidir.
   *
   * @param reconciliationDate YYYYMMDD formatında olacaktır.
   *
   * @return
   * @throws Exception
   */
  public GetProvisionHistoryRequestFactory setReconciliationDate(
      String reconciliationDate) throws Exception {
    if (reconciliationDateSDF.parse(reconciliationDate) == null
        || reconciliationDate.length() != RECONCILIATION_DATE_PATTERN.length()) {
      throw new Exception(
          "ReconciliationDate must match pattern: " + RECONCILIATION_DATE_PATTERN);
    }
    request.setReconciliationDate(reconciliationDate);
    return this;
  }

  /**
   * Oluşturulan request döndürülür.
   *
   * @return
   * @throws Exception clientIpAddress/recnociliationDate boş ise fırlatılır.
   */
  public GetProvisionHistoryRequest build() throws Exception {
    validate();
    return request;
  }

  /**
   *
   * @throws Exception clientIpAddress/recnociliationDate boş ise fırlatılır.
   */
  private void validate() throws Exception {
    if (request.getRequestHeader().getClientIPAddress() == null) {
      throw new Exception("ClientIpAddress must be set first.");
    }
    if (request.getReconciliationDate() == null) {
      throw new Exception("ReconciliationDate must be set first.");
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
    requestHeader.setTransactionDateTime(transactionIdSDF.format(new Date()));
    requestHeader.setTransactionId(UniqueIdGenerator.generateTransactionId());
    return requestHeader;
  }

}
