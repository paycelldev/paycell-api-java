package com.example.paycellwebapiclient.payment.client.summaryreconciliation;

import java.util.List;
import javax.xml.ws.Holder;
import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseSoapClient;
import com.turkcelltech.mf.tpay.web.provision.ExtraParameter;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;
import com.turkcelltech.mf.tpay.web.provision.ResponseHeader;
import com.turkcelltech.mf.tpay.web.provision.SummaryReconciliationRequest;
import com.turkcelltech.mf.tpay.web.provision.SummaryReconciliationResponse;

@Component
public class SummaryReconciliationSoapClient
    extends BaseSoapClient<SummaryReconciliationRequest, SummaryReconciliationResponse> {

  /**
   * SummaryReconciliation Soap methodu çağrılır.
   */
  @Override
  public SummaryReconciliationResponse sendRequest(SummaryReconciliationRequest request) {
    Holder<List<ExtraParameter>> extraParameters =
        new Holder<>(request.getExtraParameters());
    String merchantCode = request.getMerchantCode();
    Holder<String> reconciliationDate = new Holder<>(request.getReconciliationDate());
    RequestHeader requestHeader = request.getRequestHeader();
    Holder<String> totalRefundAmount = new Holder<>(request.getTotalRefundAmount());
    Holder<Integer> totalRefundCount = new Holder<>(request.getTotalRefundCount());
    Holder<String> totalReverseAmount = new Holder<>(request.getTotalReverseAmount());
    Holder<Integer> totalReverseCount = new Holder<>(request.getTotalReverseCount());
    Holder<String> totalSaleAmount = new Holder<>(request.getTotalSaleAmount());
    Holder<Integer> totalSaleCount = new Holder<>(request.getTotalSaleCount());
    Holder<String> reconciliationResult = new Holder<>();
    Holder<ResponseHeader> responseHeader = new Holder<>();

    provisionService.summaryReconciliation(extraParameters, merchantCode,
        reconciliationDate, requestHeader, totalRefundAmount, totalRefundCount,
        totalReverseAmount, totalReverseCount, totalSaleAmount, totalSaleCount,
        reconciliationResult, responseHeader);

    SummaryReconciliationResponse response = new SummaryReconciliationResponse();
    response.getExtraParameters().addAll(extraParameters.value);
    response.setReconciliationDate(reconciliationDate.value);
    response.setTotalRefundAmount(totalRefundAmount.value);
    response.setTotalRefundCount(totalRefundCount.value);
    response.setTotalReverseAmount(totalReverseAmount.value);
    response.setTotalReverseCount(totalReverseCount.value);
    response.setTotalSaleAmount(totalSaleAmount.value);
    response.setTotalSaleCount(totalSaleCount.value);
    response.setReconciliationResult(reconciliationResult.value);
    response.setResponseHeader(responseHeader.value);
    return response;
  }

}
