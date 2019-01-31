package com.example.paycellwebapiclient.ui.payment.provisionhistory;

import java.util.List;

public class ProvisionHistoryViewDto implements ProvisionHistoryListener{

  private String reconciliationDate;

  private List<TransactionViewDto> transactionList;

  private ProvisionHistoryListener provisionHistoryListener;

  public ProvisionHistoryViewDto(ProvisionHistoryListener provisionHistoryListener) {
    this.provisionHistoryListener = provisionHistoryListener;
  }

  @Override
  public void retrieveProvisionHistory() {
    if(provisionHistoryListener != null) {
      provisionHistoryListener.retrieveProvisionHistory();
    }
  }

  public String getReconciliationDate() {
    return reconciliationDate;
  }

  public void setReconciliationDate(String reconciliationDate) {
    this.reconciliationDate = reconciliationDate;
  }

  public List<TransactionViewDto> getTransactionList() {
    return transactionList;
  }

  public void setTransactionList(List<TransactionViewDto> transactionList) {
    this.transactionList = transactionList;
  }

}
