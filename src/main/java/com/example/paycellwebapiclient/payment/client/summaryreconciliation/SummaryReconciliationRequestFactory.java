package com.example.paycellwebapiclient.payment.client.summaryreconciliation;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.common.util.UniqueIdGenerator;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;
import com.turkcelltech.mf.tpay.web.provision.SummaryReconciliationRequest;

public class SummaryReconciliationRequestFactory {

  private static final SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
  private SummaryReconciliationRequest request;

  /**
   * Requet başlatılır.
   *
   * ReferenceNumber: Üye işyeritarfından üretilen tekil değerdir. Provisiona özgüdür. ilk 3 hanesi
   * Paycell tarafından üye işyeri için tanımlanır. 20 haneli numerik bir değerdir.
   *
   * MerchantCode: Paycell taraffından üye iş yeri için tanımlanır.
   */
  public SummaryReconciliationRequestFactory() {
    request = new SummaryReconciliationRequest();
    request.setRequestHeader(createRequestHeader());
    request.setMerchantCode(PaycellWebApiConstants.MERCHANT_CODE);
  }

  /**
   *
   * @param clientIPAddress Müşteri IP bilgisi
   * @return
   */
  public SummaryReconciliationRequestFactory setClientIPAddress(String clientIPAddress) {
    request.getRequestHeader().setClientIPAddress(clientIPAddress);
    return this;
  }

  /**
   * İşlemin mutabakatı için PAYCELL sisteminde belirlenen tarih.
   *
   * @param reconciliationDate YYYYMMDD formatında olacaktır.
   * @return
   */
  public SummaryReconciliationRequestFactory setReconciliationDate(
      String reconciliationDate) {
    request.setReconciliationDate(reconciliationDate);
    return this;
  }

  /**
   * lgili tarihte gerçekleşen [Sale] işlemlerinin toplam tutarıdır. İşlem [Reverse] ya da [Refund]
   * edildiği durumda da toplama dahil edilir.
   *
   * @param totalSaleAmount
   * @return
   */
  public SummaryReconciliationRequestFactory setTotalSaleAmount(String totalSaleAmount) {
    request.setTotalSaleAmount(totalSaleAmount);
    return this;
  }

  /**
   * İlgili tarihte gerçekleşen [Reverse] işlemlerinin toplam tutarıdır.
   *
   * @param totalReverseAmount
   * @return
   */
  public SummaryReconciliationRequestFactory setTotalReverseAmount(
      String totalReverseAmount) {
    request.setTotalReverseAmount(totalReverseAmount);
    return this;
  }

  /**
   * İlgili tarihte gerçekleşen [Refund] işlemlerinin toplam tutarıdır.
   *
   * @param totalRefundAmount
   * @return
   */
  public SummaryReconciliationRequestFactory setTotalRefundAmount(
      String totalRefundAmount) {
    request.setTotalRefundAmount(totalRefundAmount);
    return this;
  }

  /**
   * İlgili tarihte gerçekleşen [Sale] işlemlerinin toplam adedidir.İşlem [Reverse] ya da [Refund]
   * edildiği durumda da toplama dahil edilir.
   *
   * @param totalSaleCount
   * @return
   */
  public SummaryReconciliationRequestFactory setTotalSaleCount(Integer totalSaleCount) {
    request.setTotalSaleCount(totalSaleCount);
    return this;
  }

  /**
   * İlgili tarihte gerçekleşen [Reverse] işlemlerinin toplam adedidir.
   *
   * @param totalReverseCount
   * @return
   */
  public SummaryReconciliationRequestFactory setTotalReverseCount(
      Integer totalReverseCount) {
    request.setTotalReverseCount(totalReverseCount);
    return this;
  }

  /**
   * İlgili tarihte gerçekleşen [Refund] işlemlerinin toplam adedidir.
   *
   * @param totalRefundCount
   * @return
   */
  public SummaryReconciliationRequestFactory setTotalRefundCount(
      Integer totalRefundCount) {
    request.setTotalRefundCount(totalRefundCount);
    return this;
  }

  /**
   * İlgili tarihte gerçekleşen [PostAuth] işlemlerinin toplam miktarıdır.
   *
   * @param totalPostAuthAmount
   * @return
   */
  public SummaryReconciliationRequestFactory setTotalPostAuthAmount(
      String totalPostAuthAmount) {
    request.setTotalPostAuthAmount(totalPostAuthAmount);
    return this;
  }

  /**
   * İlgili tarihte gerçekleşen [PostAuthReverse] işlemlerinin toplam miktarıdır.
   *
   * @param totalPostAuthReverseAmount
   * @return
   */
  public SummaryReconciliationRequestFactory setTotalPostAuthReverseAmount(
      String totalPostAuthReverseAmount) {
    request.setTotalPostAuthReverseAmount(totalPostAuthReverseAmount);
    return this;
  }

  /**
   * İlgili tarihte gerçekleşen [PreAuth] işlemlerinin toplam miktarıdır.
   *
   * @param totalPreAuthAmount
   * @return
   */
  public SummaryReconciliationRequestFactory setTotalPreAuthAmount(
      String totalPreAuthAmount) {
    request.setTotalPreAuthAmount(totalPreAuthAmount);
    return this;
  }

  /**
   * İlgili tarihte gerçekleşen [PreAuthReverse] işlemlerinin toplam miktarıdır.
   *
   * @param totalPreAuthReverseAmount
   * @return
   */
  public SummaryReconciliationRequestFactory setTotalPreAuthReverseAmount(
      String totalPreAuthReverseAmount) {
    request.setTotalPostAuthReverseAmount(totalPreAuthReverseAmount);
    return this;
  }

  /**
   * İlgili tarihte gerçekleşen [PostAuth] işlemlerinin toplam adedidir.
   *
   * @param totalPostAuthCount
   * @return
   */
  public SummaryReconciliationRequestFactory setTotalPostAuthCount(
      String totalPostAuthCount) {
    request.setTotalPostAuthCount(Integer.valueOf(totalPostAuthCount));
    return this;
  }

  /**
   * İlgili tarihte gerçekleşen [PostAuthReverse] işlemlerinin toplam adedidir.
   *
   * @param totalPostAuthReverseCount
   * @return
   */
  public SummaryReconciliationRequestFactory setTotalPostAuthReverseCount(
      String totalPostAuthReverseCount) {
    request.setTotalPostAuthReverseCount(Integer.valueOf(totalPostAuthReverseCount));
    return this;
  }

  /**
   * İlgili tarihte gerçekleşen [PreAuth] işlemlerinin toplam adedidir.
   *
   * @param totalPreAuthCount
   * @return
   */
  public SummaryReconciliationRequestFactory setTotalPreAuthCount(
      String totalPreAuthCount) {
    request.setTotalPreAuthCount(Integer.valueOf(totalPreAuthCount));
    return this;
  }

  /**
   * İlgili tarihte gerçekleşen [PreAuthReverse] işlemlerinin toplam adedidir.
   *
   * @param totalPreAuthReverseCount
   * @return
   */
  public SummaryReconciliationRequestFactory setTotalPreAuthReverseCount(String totalPreAuthReverseCount) {
    request.setTotalPreAuthReverseCount(Integer.valueOf(totalPreAuthReverseCount));
    return this;
  }

  /**
   * Üretilen request döndürülür.
   *
   * @return
   * @throws Exception clientIpAddress/ReconciliationDate/TotalSaleAmount/TotalReverseAmount/
   *         TotalRefundAmount/TotalSaleCount/TotalReverseCount/TotalRefundCount boş ise fırlatılır.
   */
  public SummaryReconciliationRequest build() throws Exception {
    validate();
    return request;
  }

  /**
   *
   * @throws Exception clientIpAddress/ReconciliationDate/TotalSaleAmount/TotalReverseAmount/
   *         TotalRefundAmount/TotalSaleCount/TotalReverseCount/TotalRefundCount boş ise fırlatılır.
   */
  private void validate() throws Exception {
    if (request.getRequestHeader().getClientIPAddress() == null) {
      throw new Exception("ClientIpAddress must be set first.");
    }
    if (request.getReconciliationDate() == null) {
      throw new Exception("ReconciliationDate must be set first.");
    }
    if (request.getTotalSaleAmount() == null) {
      throw new Exception("TotalSaleAmount must be set first.");
    }
    if (request.getTotalReverseAmount() == null) {
      throw new Exception("TotalReverseAmount must be set first.");
    }
    if (request.getTotalRefundAmount() == null) {
      throw new Exception("TotalRefundAmount must be set first.");
    }
    if (request.getTotalSaleCount() == null) {
      throw new Exception("TotalSaleCount must be set first.");
    }
    if (request.getTotalReverseCount() == null) {
      throw new Exception("TotalReverseCount must be set first.");
    }
    if (request.getTotalRefundCount() == null) {
      throw new Exception("TotalRefundCount must be set first.");
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
