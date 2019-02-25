package com.example.paycellwebapiclient.domain.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.payment.client.summaryreconciliation.SummaryReconciliationClient;
import com.example.paycellwebapiclient.payment.client.summaryreconciliation.SummaryReconciliationRequestFactory;
import com.turkcelltech.mf.tpay.web.provision.SummaryReconciliationRequest;
import com.turkcelltech.mf.tpay.web.provision.SummaryReconciliationResponse;

@Component
@Scope("prototype")
public class SummaryReconciliation {

  private String reconciliationDate;

  private String totalPostAuthAmount;

  private String totalPostAuthReverseAmount;

  private String totalPreAuthAmount;

  private String totalPreAuthReverseAmount;

  private String totalPostAuthCount;

  private String totalPostAuthReverseCount;

  private String totalPreAuthCount;

  private String totalPreAuthReverseCount;

  private String totalSaleAmount;

  private String totalReverseAmount;

  private String totalRefundAmount;

  private Integer totalSaleCount;

  private Integer totalReverseCount;

  private Integer totalRefundCount;

  private String responseTotalPostAuthAmount;

  private String responseTotalPostAuthReverseAmount;

  private String responseTotalPreAuthAmount;

  private String responseTotalPreAuthReverseAmount;

  private String responseTotalPostAuthCount;

  private String responseTotalPostAuthReverseCount;

  private String responseTotalPreAuthCount;

  private String responseTotalPreAuthReverseCount;

  private String responseTotalSaleAmount;

  private String responseTotalReverseAmount;

  private String responseTotalRefundAmount;

  private Integer responseTotalSaleCount;

  private Integer responseTotalReverseCount;

  private Integer responseTotalRefundCount;

  private String reconciliationResult;

  @Autowired
  private SummaryReconciliationClient summaryReconciliationClient;

  public void summaryReconciliation(String clientIPAddress, ConnectionMethod connectionMethod) throws Exception {
    SummaryReconciliationRequestFactory factory =
        new SummaryReconciliationRequestFactory();
    factory.setClientIPAddress(clientIPAddress);
    factory.setReconciliationDate(reconciliationDate);
    factory.setTotalSaleAmount(totalSaleAmount);
    factory.setTotalReverseAmount(totalReverseAmount);
    factory.setTotalRefundAmount(totalRefundAmount);
    factory.setTotalSaleCount(totalSaleCount);
    factory.setTotalReverseCount(totalReverseCount);
    factory.setTotalRefundCount(totalRefundCount);
    factory.setTotalPostAuthAmount(totalPostAuthAmount);
    factory.setTotalPostAuthCount(totalPostAuthCount);
    factory.setTotalPostAuthReverseAmount(totalPostAuthReverseAmount);
    factory.setTotalPostAuthReverseCount(totalPostAuthReverseCount);
    factory.setTotalPreAuthAmount(totalPreAuthAmount);
    factory.setTotalPreAuthCount(totalPreAuthCount);
    factory.setTotalPreAuthReverseAmount(totalPreAuthReverseAmount);
    factory.setTotalPreAuthReverseAmount(totalPreAuthReverseAmount);
    factory.setTotalPostAuthReverseCount(totalPostAuthReverseCount);
    SummaryReconciliationRequest request = factory.build();

    SummaryReconciliationResponse response =
        summaryReconciliationClient.summaryReconciliation(request, connectionMethod);
    if (response.getResponseHeader().getResponseCode()
        .contentEquals(PaycellWebApiConstants.SUCCESS_CODE)) {
      setReconciliationResult(response.getReconciliationResult());
      setResponseTotalSaleAmount(response.getTotalSaleAmount());
      setResponseTotalReverseAmount(response.getTotalReverseAmount());
      setResponseTotalRefundAmount(response.getTotalRefundAmount());
      setResponseTotalSaleCount(response.getTotalSaleCount());
      setResponseTotalReverseCount(response.getTotalReverseCount());
      setResponseTotalRefundCount(response.getTotalRefundCount());
      setResponseTotalPostAuthAmount(response.getTotalPostAuthAmount());
      setResponseTotalPostAuthCount(response.getTotalPostAuthCount() != null ? response.getTotalPostAuthCount().toString() : null);
      setResponseTotalPostAuthReverseAmount(response.getTotalPostAuthReverseAmount());
      setResponseTotalPostAuthReverseCount(response.getTotalPostAuthReverseCount() != null ? response.getTotalPostAuthReverseCount().toString() : null);
      setResponseTotalPreAuthAmount(response.getTotalPreAuthAmount());
      setResponseTotalPreAuthCount(response.getTotalPreAuthCount() != null ? response.getTotalPreAuthCount().toString() : null);
      setResponseTotalPreAuthReverseAmount(response.getTotalPreAuthReverseAmount());
      setResponseTotalPreAuthReverseCount(response.getTotalPreAuthReverseCount() != null ? response.getTotalPreAuthReverseCount().toString() : null);
    } else {
      throw new Exception(
          "Bad Request: " + response.getResponseHeader().getResponseDescription());
    }
  }

  public String getTotalPostAuthAmount() {
    return totalPostAuthAmount;
  }

  public void setTotalPostAuthAmount(String totalPostAuthAmount) {
    this.totalPostAuthAmount = totalPostAuthAmount;
  }

  public String getTotalPostAuthReverseAmount() {
    return totalPostAuthReverseAmount;
  }

  public void setTotalPostAuthReverseAmount(String totalPostAuthReverseAmount) {
    this.totalPostAuthReverseAmount = totalPostAuthReverseAmount;
  }

  public String getTotalPreAuthAmount() {
    return totalPreAuthAmount;
  }

  public void setTotalPreAuthAmount(String totalPreAuthAmount) {
    this.totalPreAuthAmount = totalPreAuthAmount;
  }

  public String getTotalPreAuthReverseAmount() {
    return totalPreAuthReverseAmount;
  }

  public void setTotalPreAuthReverseAmount(String totalPreAuthReverseAmount) {
    this.totalPreAuthReverseAmount = totalPreAuthReverseAmount;
  }

  public String getTotalPostAuthCount() {
    return totalPostAuthCount;
  }

  public void setTotalPostAuthCount(String totalPostAuthCount) {
    this.totalPostAuthCount = totalPostAuthCount;
  }

  public String getTotalPostAuthReverseCount() {
    return totalPostAuthReverseCount;
  }

  public void setTotalPostAuthReverseCount(String totalPostAuthReverseCount) {
    this.totalPostAuthReverseCount = totalPostAuthReverseCount;
  }

  public String getTotalPreAuthCount() {
    return totalPreAuthCount;
  }

  public void setTotalPreAuthCount(String totalPreAuthCount) {
    this.totalPreAuthCount = totalPreAuthCount;
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

  public Integer getTotalSaleCount() {
    return totalSaleCount;
  }

  public void setTotalSaleCount(Integer totalSaleCount) {
    this.totalSaleCount = totalSaleCount;
  }

  public Integer getTotalReverseCount() {
    return totalReverseCount;
  }

  public void setTotalReverseCount(Integer totalReverseCount) {
    this.totalReverseCount = totalReverseCount;
  }

  public Integer getTotalRefundCount() {
    return totalRefundCount;
  }

  public void setTotalRefundCount(Integer totalRefundCount) {
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

  public Integer getResponseTotalSaleCount() {
    return responseTotalSaleCount;
  }

  public void setResponseTotalSaleCount(Integer integer) {
    this.responseTotalSaleCount = integer;
  }

  public Integer getResponseTotalReverseCount() {
    return responseTotalReverseCount;
  }

  public void setResponseTotalReverseCount(Integer responseTotalReverseCount) {
    this.responseTotalReverseCount = responseTotalReverseCount;
  }

  public Integer getResponseTotalRefundCount() {
    return responseTotalRefundCount;
  }

  public void setResponseTotalRefundCount(Integer responseTotalRefundCount) {
    this.responseTotalRefundCount = responseTotalRefundCount;
  }

  public String getReconciliationResult() {
    return reconciliationResult;
  }

  public void setReconciliationResult(String reconciliationResult) {
    this.reconciliationResult = reconciliationResult;
  }

  public String getResponseTotalPostAuthAmount() {
    return responseTotalPostAuthAmount;
  }

  public void setResponseTotalPostAuthAmount(String responseTotalPostAuthAmount) {
    this.responseTotalPostAuthAmount = responseTotalPostAuthAmount;
  }

  public String getResponseTotalPostAuthReverseAmount() {
    return responseTotalPostAuthReverseAmount;
  }

  public void setResponseTotalPostAuthReverseAmount(
      String responseTotalPostAuthReverseAmount) {
    this.responseTotalPostAuthReverseAmount = responseTotalPostAuthReverseAmount;
  }

  public String getResponseTotalPreAuthAmount() {
    return responseTotalPreAuthAmount;
  }

  public void setResponseTotalPreAuthAmount(String responseTotalPreAuthAmount) {
    this.responseTotalPreAuthAmount = responseTotalPreAuthAmount;
  }

  public String getResponseTotalPreAuthReverseAmount() {
    return responseTotalPreAuthReverseAmount;
  }

  public void setResponseTotalPreAuthReverseAmount(
      String responseTotalPreAuthReverseAmount) {
    this.responseTotalPreAuthReverseAmount = responseTotalPreAuthReverseAmount;
  }

  public String getResponseTotalPostAuthCount() {
    return responseTotalPostAuthCount;
  }

  public void setResponseTotalPostAuthCount(String responseTotalPostAuthCount) {
    this.responseTotalPostAuthCount = responseTotalPostAuthCount;
  }

  public String getResponseTotalPostAuthReverseCount() {
    return responseTotalPostAuthReverseCount;
  }

  public void setResponseTotalPostAuthReverseCount(
      String responseTotalPostAuthReverseCount) {
    this.responseTotalPostAuthReverseCount = responseTotalPostAuthReverseCount;
  }

  public String getResponseTotalPreAuthCount() {
    return responseTotalPreAuthCount;
  }

  public void setResponseTotalPreAuthCount(String responseTotalPreAuthCount) {
    this.responseTotalPreAuthCount = responseTotalPreAuthCount;
  }

  public String getResponseTotalPreAuthReverseCount() {
    return responseTotalPreAuthReverseCount;
  }

  public void setResponseTotalPreAuthReverseCount(String responseTotalPreAuthReverseCount) {
    this.responseTotalPreAuthReverseCount = responseTotalPreAuthReverseCount;
  }

}
