package com.example.paycellwebapiclient.ui.payment.summaryreconciliation;

public class SummaryReconciliationViewDto implements SummaryReconciliationListener {

  private String reconciliationDate;

  private String totalPostAuthAmount;

  private String totalPostAuthCount;

  private String totalPostAuthReverseAmount;

  private String totalPostAuthReverseCount;

  private String totalPreAuthAmount;

  private String totalPreAuthCount;

  private String totalPreAuthReverseAmount;

  private String totalPreAuthReverseCount;

  private String totalSaleAmount;

  private String totalReverseAmount;

  private String totalRefundAmount;

  private String totalSaleCount;

  private String totalReverseCount;

  private String totalRefundCount;

  private String responseTotalPostAuthAmount;

  private String responseTotalPostAuthCount;

  private String responseTotalPostAuthReverseAmount;

  private String responseTotalPostAuthReverseCount;

  private String responseTotalPreAuthAmount;

  private String responseTotalPreAuthCount;

  private String responseTotalPreAuthReverseAmount;

  private String responseTotalPreAuthReverseCount;

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

  public String getTotalPostAuthAmount() {
    return totalPostAuthAmount;
  }

  public void setTotalPostAuthAmount(String totalPostAuthAmount) {
    this.totalPostAuthAmount = totalPostAuthAmount;
  }

  public String getTotalPostAuthCount() {
    return totalPostAuthCount;
  }

  public void setTotalPostAuthCount(String totalPostAuthCount) {
    this.totalPostAuthCount = totalPostAuthCount;
  }

  public String getTotalPostAuthReverseAmount() {
    return totalPostAuthReverseAmount;
  }

  public void setTotalPostAuthReverseAmount(String totalPostAuthReverseAmount) {
    this.totalPostAuthReverseAmount = totalPostAuthReverseAmount;
  }

  public String getTotalPostAuthReverseCount() {
    return totalPostAuthReverseCount;
  }

  public void setTotalPostAuthReverseCount(String totalPostAuthReverseCount) {
    this.totalPostAuthReverseCount = totalPostAuthReverseCount;
  }

  public String getTotalPreAuthAmount() {
    return totalPreAuthAmount;
  }

  public void setTotalPreAuthAmount(String totalPreAuthAmount) {
    this.totalPreAuthAmount = totalPreAuthAmount;
  }

  public String getTotalPreAuthCount() {
    return totalPreAuthCount;
  }

  public void setTotalPreAuthCount(String totalPreAuthCount) {
    this.totalPreAuthCount = totalPreAuthCount;
  }

  public String getTotalPreAuthReverseAmount() {
    return totalPreAuthReverseAmount;
  }

  public void setTotalPreAuthReverseAmount(String totalPreAuthReverseAmount) {
    this.totalPreAuthReverseAmount = totalPreAuthReverseAmount;
  }

  public String getTotalPreAuthReverseCount() {
    return totalPreAuthReverseCount;
  }

  public void setTotalPreAuthReverseCount(String totalPreAuthReverseCount) {
    this.totalPreAuthReverseCount = totalPreAuthReverseCount;
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

  public String getResponseTotalPostAuthAmount() {
    return responseTotalPostAuthAmount;
  }

  public void setResponseTotalPostAuthAmount(String responseTotalPostAuthAmount) {
    this.responseTotalPostAuthAmount = responseTotalPostAuthAmount;
  }

  public String getResponseTotalPostAuthCount() {
    return responseTotalPostAuthCount;
  }

  public void setResponseTotalPostAuthCount(String responseTotalPostAuthCount) {
    this.responseTotalPostAuthCount = responseTotalPostAuthCount;
  }

  public String getResponseTotalPostAuthReverseAmount() {
    return responseTotalPostAuthReverseAmount;
  }

  public void setResponseTotalPostAuthReverseAmount(
      String responseTotalPostAuthReverseAmount) {
    this.responseTotalPostAuthReverseAmount = responseTotalPostAuthReverseAmount;
  }

  public String getResponseTotalPostAuthReverseCount() {
    return responseTotalPostAuthReverseCount;
  }

  public void setResponseTotalPostAuthReverseCount(
      String responseTotalPostAuthReverseCount) {
    this.responseTotalPostAuthReverseCount = responseTotalPostAuthReverseCount;
  }

  public String getResponseTotalPreAuthAmount() {
    return responseTotalPreAuthAmount;
  }

  public void setResponseTotalPreAuthAmount(String responseTotalPreAuthAmount) {
    this.responseTotalPreAuthAmount = responseTotalPreAuthAmount;
  }

  public String getResponseTotalPreAuthCount() {
    return responseTotalPreAuthCount;
  }

  public void setResponseTotalPreAuthCount(String responseTotalPreAuthCount) {
    this.responseTotalPreAuthCount = responseTotalPreAuthCount;
  }

  public String getResponseTotalPreAuthReverseAmount() {
    return responseTotalPreAuthReverseAmount;
  }

  public void setResponseTotalPreAuthReverseAmount(
      String responseTotalPreAuthReverseAmount) {
    this.responseTotalPreAuthReverseAmount = responseTotalPreAuthReverseAmount;
  }

  public String getResponseTotalPreAuthReverseCount() {
    return responseTotalPreAuthReverseCount;
  }

  public void setResponseTotalPreAuthReverseCount(String responseTotalPreAuthReverseCount) {
    this.responseTotalPreAuthReverseCount = responseTotalPreAuthReverseCount;
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
