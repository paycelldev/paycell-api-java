package com.example.paycellwebapiclient.threedsession.get;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.JsonRestClient;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;

@Component
public class GetThreeDSessionRestClient
    extends JsonRestClient<GetThreeDSessionRequest, GetThreeDSessionResponse> {

  /**
   * GetThreeDSession Rest Methodunun urlsi verilir.
   */
  @Override
  public String getUrl() {
    return PaycellWebApiConstants.RestConstants.GET_THREE_D_SESSION_URL;
  }

  /**
   * GetThreeDSessionmethodu çağrılır.
   *
   * @param request servis isteği
   * @return servis cevabı
   * @throws Exception servis ulaşımı sırasında bir hata oluşursa fırlatılır.
   */
  public GetThreeDSessionResponse getThreeDSession(GetThreeDSessionRequest request)
      throws Exception {
    return sendRequest(request, GetThreeDSessionResponse.class);
  }

}
