package com.example.paycellwebapiclient.payment.client.summaryreconciliation;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.JsonRestClient;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.turkcelltech.mf.tpay.web.provision.SummaryReconciliationRequest;
import com.turkcelltech.mf.tpay.web.provision.SummaryReconciliationResponse;

@Component
public class SummaryReconciliationRestClient
    extends JsonRestClient<SummaryReconciliationRequest, SummaryReconciliationResponse> {

  /**
   * SummaryReconciliation Rest Methodunun urlsi verilir.
   */
  @Override
  public String getUrl() {
    return PaycellWebApiConstants.RestConstants.SUMMARY_RECONCILIATION_URL;
  }

}
