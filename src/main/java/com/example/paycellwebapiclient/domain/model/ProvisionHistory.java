package com.example.paycellwebapiclient.domain.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.payment.client.provisionhistory.GetProvisionHistoryClient;
import com.example.paycellwebapiclient.payment.client.provisionhistory.GetProvisionHistoryRequestFactory;
import com.turkcelltech.mf.tpay.web.provision.GetProvisionHistoryRequest;
import com.turkcelltech.mf.tpay.web.provision.GetProvisionHistoryResponse;

@Component
@Scope("prototype")
public class ProvisionHistory {

  private String reconciliationDate;

  private List<Transaction> transactionList;

  @Autowired
  private GetProvisionHistoryClient getProvisionHistoryClient;

  @Autowired
  private WebApplicationContext webApplicationContext;

  public void retrieveProvisionHistory(String clientIPAddress, ConnectionMethod connectionMethod) throws Exception {
    GetProvisionHistoryRequest request = null;;
    GetProvisionHistoryResponse response = null;
    List<Transaction> retrievedTransactionList = new ArrayList<>();
    do {
      GetProvisionHistoryRequestFactory factory = new GetProvisionHistoryRequestFactory();
      factory.setClientIPAddress(clientIPAddress);
      factory.setReconciliationDate(reconciliationDate);
      factory.setPartitonNo(response != null ? response.getNextPartitionNo() : null);
      request = factory.build();

      response = getProvisionHistoryClient.getProvisionHistory(request, connectionMethod);
      if (response.getResponseHeader().getResponseCode()
          .contentEquals(PaycellWebApiConstants.SUCCESS_CODE)) {
        for (com.turkcelltech.mf.tpay.web.provision.Transaction transactionItem : response
            .getTransactionList()) {
          Transaction transaction = webApplicationContext.getBean(Transaction.class);
          BeanUtils.copyProperties(transactionItem, transaction);
          retrievedTransactionList.add(transaction);
        }
        setTransactionList(retrievedTransactionList);
      } else {
        throw new Exception(
            "Bad Request: " + response.getResponseHeader().getResponseDescription());
      }
    } while (response.getNextPartitionNo() != null);
  }

  public String getReconciliationDate() {
    return reconciliationDate;
  }

  public void setReconciliationDate(String reconciliationDate) {
    this.reconciliationDate = reconciliationDate;
  }

  public List<Transaction> getTransactionList() {
    return transactionList;
  }

  public void setTransactionList(List<Transaction> transactionList) {
    this.transactionList = transactionList;
  }


}
