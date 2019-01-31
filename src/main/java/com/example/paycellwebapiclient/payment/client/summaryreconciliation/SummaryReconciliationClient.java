package com.example.paycellwebapiclient.payment.client.summaryreconciliation;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient;
import com.turkcelltech.mf.tpay.web.provision.SummaryReconciliationRequest;
import com.turkcelltech.mf.tpay.web.provision.SummaryReconciliationResponse;

@Component
public class SummaryReconciliationClient
    extends BaseClient<SummaryReconciliationRequest, SummaryReconciliationResponse> {

  /**
   * @param request servis isteği
   * @param connectionMethod SOAP/REST
   * @return servis cevabı
   * @throws Exception servise ulaşırken hata alınırsa oluşur
   */
  public SummaryReconciliationResponse summaryReconciliation(
      SummaryReconciliationRequest request, ConnectionMethod connectionMethod)
      throws Exception {
    return sendRequest(request, SummaryReconciliationResponse.class, connectionMethod);
  }

}
