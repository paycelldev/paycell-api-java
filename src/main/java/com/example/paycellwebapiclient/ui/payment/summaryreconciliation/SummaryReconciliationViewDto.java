package com.example.paycellwebapiclient.ui.payment.summaryreconciliation;

public class SummaryReconciliationViewDto implements SummaryReconciliationListener {

  private String reconciliationDate;

  private String totalSaleAmount;

  private String totalReverseAmount;

  private String totalRefundAmount;

  private String totalSaleCount;

  private String totalReverseCount;

  private String totalRefundCount;

  private String responseTotalSaleAmount;

  private String responseTotalReverseAmount;

  private String responseTotalRefundAmount;

  private String responseTotalSaleCount;

  private String responseTotalReverseCount;

  private String responseTotalRefundCount;

  private String reconciliationResult;

  private SummaryReconciliationListener summaryReconciliationListener;

  public SummaryReconciliationViewDto(
      SummaryReconciliationListener summaryReconciliationListener) {
    this.summaryReconciliationListener = summaryReconciliationListener;
  }

  @Override
  public void summaryReconciliation() {
    if (summaryReconciliationListener != null) {
      summaryReconciliationListener.summaryReconciliation();
    }
  }

  public String getReconciliationDate() {
    return reconciliationDate;
  }

  public void setReconciliationDate(String reconciliationDate) {
    this.reconciliationDate = reconciliationDate;
  }

  public String getTotalSaleAmount() {
    return totalSaleAmount;
  }

  public void setTotalSaleAmount(String totalSaleAmount) {
    this.totalSaleAmount = totalSaleAmount;
  }

  public String getTotalReverseAmount() {
    return totalReverseAmount;
  }

  public void setTotalReverseAmount(String totalReverseAmount) {
    this.totalReverseAmount = totalReverseAmount;
  }

  public String getTotalRefundAmount() {
    return totalRefundAmount;
  }

  public void setTotalRefundAmount(String totalRefundAmount) {
    this.totalRefundAmount = totalRefundAmount;
  }

  public String getTotalSaleCount() {
    return totalSaleCount;
  }

  public void setTotalSaleCount(String totalSaleCount) {
    this.totalSaleCount = totalSaleCount;
  }

  public String getTotalReverseCount() {
    return totalReverseCount;
  }

  public void setTotalReverseCount(String totalReverseCount) {
    this.totalReverseCount = totalReverseCount;
  }

  public String getTotalRefundCount() {
    return totalRefundCount;
  }

  public void setTotalRefundCount(String totalRefundCount) {
    this.totalRefundCount = totalRefundCount;
  }

  public String getResponseTotalSaleAmount() {
    return responseTotalSaleAmount;
  }

  public void setResponseTotalSaleAmount(String responseTotalSaleAmount) {
    this.responseTotalSaleAmount = responseTotalSaleAmount;
  }

  public String getResponseTotalReverseAmount() {
    return responseTotalReverseAmount;
  }

  public void setResponseTotalReverseAmount(String responseTotalReverseAmount) {
    this.responseTotalReverseAmount = responseTotalReverseAmount;
  }

  public String getResponseTotalRefundAmount() {
    return responseTotalRefundAmount;
  }

  public void setResponseTotalRefundAmount(String responseTotalRefundAmount) {
    this.responseTotalRefundAmount = responseTotalRefundAmount;
  }

  public String getResponseTotalSaleCount() {
    return responseTotalSaleCount;
  }

  public void setResponseTotalSaleCount(String responseTotalSaleCount) {
    this.responseTotalSaleCount = responseTotalSaleCount;
  }

  public String getResponseTotalReverseCount() {
    return responseTotalReverseCount;
  }

  public void setResponseTotalReverseCount(String responseTotalReverseCount) {
    this.responseTotalReverseCount = responseTotalReverseCount;
  }

  public String getResponseTotalRefundCount() {
    return responseTotalRefundCount;
  }

  public void setResponseTotalRefundCount(String responseTotalRefundCount) {
    this.responseTotalRefundCount = responseTotalRefundCount;
  }

  public String getReconciliationResult() {
    return reconciliationResult;
  }

  public void setReconciliationResult(String reconciliationResult) {
    this.reconciliationResult = reconciliationResult;
  }

}
