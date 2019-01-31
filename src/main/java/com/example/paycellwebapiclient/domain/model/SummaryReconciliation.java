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

  private String totalSaleAmount;

  private String totalReverseAmount;

  private String totalRefundAmount;

  private Integer totalSaleCount;

  private Integer totalReverseCount;

  private Integer totalRefundCount;

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
    } else {
      throw new Exception(
          "Bad Request: " + response.getResponseHeader().getResponseDescription());
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

}
