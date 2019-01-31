package com.example.paycellwebapiclient.payment.client.refund;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.BaseClient;
import com.turkcelltech.mf.tpay.web.provision.RefundRequest;
import com.turkcelltech.mf.tpay.web.provision.RefundResponse;

@Component
public class RefundClient extends BaseClient<RefundRequest, RefundResponse> {

  /**
   * @param request servis isteği
   * @param connectionMethod SOAP/REST
   * @return servis cevabı
   * @throws Exception servise ulaşırken hata alınırsa oluşur
   */
  public RefundResponse refund(RefundRequest request, ConnectionMethod connectionMethod)
      throws Exception {
    return sendRequest(request, RefundResponse.class, connectionMethod);
  }

}
