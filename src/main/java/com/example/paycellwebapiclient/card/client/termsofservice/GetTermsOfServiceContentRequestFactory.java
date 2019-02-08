package com.example.paycellwebapiclient.card.client.termsofservice;

import static com.example.paycellwebapiclient.common.util.PaycellWebApiConstants.APPLICATION_NAME;
import static com.example.paycellwebapiclient.common.util.PaycellWebApiConstants.APPLICATION_PASSWORD;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.paycellwebapiclient.common.util.UniqueIdGenerator;
import com.turkcelltech.mf.tpay.web.provision.GetTermsOfServiceContentRequest;
import com.turkcelltech.mf.tpay.web.provision.RequestHeader;

public class GetTermsOfServiceContentRequestFactory {

  private static final SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");

  private GetTermsOfServiceContentRequest request;


  public GetTermsOfServiceContentRequestFactory() {
    request = new GetTermsOfServiceContentRequest();
    request.setRequestHeader(createRequestHeader());
  }

  /**
   * Müşteri IP bilgisi
   *
   * @param clientIPAddress
   * @return
   */
  public GetTermsOfServiceContentRequestFactory setClientIPAddress(String clientIPAddress) {
    request.getRequestHeader().setClientIPAddress(clientIPAddress);
    return this;
  }



  /**
   * Üretilen request döndürülür.
   *
   * @return
   * @throws Exception clientIpAddress boş ise fırlatılır.
   */
  public GetTermsOfServiceContentRequest build() throws Exception {
    validate();
    return request;
  }


  /**
   *
   * @throws Exception clientIpAddress boş ise fırlatılır.
   */
  private void validate() throws Exception {
    if (request.getRequestHeader().getClientIPAddress() == null) {
      throw new Exception("ClientIpAddress must be set first.");
    }
  }



  /**
   * Request header oluşturulur.
   *
   * ApplicationName: Paycell tarafından kayıt sırasında belirlenerek, üye iş yerine verilir.
   *
   * ApplicationPassword: Paycell tarafından kayıt sırasında belirlenerek, üye iş yerine verilir.
   *
   * TransactionDateTime: işlem tarihi YYYYMMddHHmmssSSS formatı kullanılır.
   *
   * TransactionId: işlem tekil numarasıdır, üye iş yeri tarafından oluşturulur. "\\d{20}" formatında
   * olmalıdır.
   *
   * @return Oluşturulan header bilgisi
   */
  private RequestHeader createRequestHeader() {
    RequestHeader requestHeader = new RequestHeader();
    requestHeader.setApplicationName(APPLICATION_NAME);
    requestHeader.setApplicationPwd(APPLICATION_PASSWORD);
    requestHeader.setTransactionDateTime(sdf.format(new Date()));
    requestHeader.setTransactionId(UniqueIdGenerator.generateTransactionId());
    return requestHeader;
  }
}
