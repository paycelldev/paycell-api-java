package com.example.paycellwebapiclient.payment.client.provisionhistory;

import java.util.List;
import javax.xml.ws.Holder;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseSoapClient;
import com.turkcelltech.mf.tpay.web.provision.ExtraParameter;
import com.turkcelltech.mf.tpay.web.provision.GetProvisionHistoryRequest;
import com.turkcelltech.mf.tpay.web.provision.GetProvisionHistoryResponse;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;
import com.turkcelltech.mf.tpay.web.provision.ResponseHeader;
import com.turkcelltech.mf.tpay.web.provision.Transaction;

@Component
public class GetProvisionHistorySoapClient
    extends BaseSoapClient<GetProvisionHistoryRequest, GetProvisionHistoryResponse> {

  /**
   * GetProvisionHistory Soap methodu çağrılır.
   */
  @Override
  public GetProvisionHistoryResponse sendRequest(GetProvisionHistoryRequest request) {
    Holder<List<ExtraParameter>> extraParameters =
        new Holder<>(request.getExtraParameters());
    RequestHeader requestHeader = request.getRequestHeader();
    String merchantCode = request.getMerchantCode();
    Integer partitionNo = request.getPartitionNo();
    String reconciliationDate = request.getReconciliationDate();
    Holder<ResponseHeader> responseHeader = new Holder<>();
    Holder<Integer> nextPartitionNo = new Holder<>();
    Holder<List<Transaction>> transactionList = new Holder<>();

    provisionService.getProvisionHistory(extraParameters, requestHeader, merchantCode,
        partitionNo, reconciliationDate, responseHeader, nextPartitionNo,
        transactionList);

    GetProvisionHistoryResponse response = new GetProvisionHistoryResponse();
    response.getExtraParameters().addAll(extraParameters.value);
    response.setResponseHeader(responseHeader.value);
    response.setNextPartitionNo(nextPartitionNo.value);
    response.getTransactionList().addAll(transactionList.value);
    return response;
  }

}
