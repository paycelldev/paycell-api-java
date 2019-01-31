package com.example.paycellwebapiclient.threedsession.result;

import org.springframework.stereotype.Component;
import com.example.paycellwebapiclient.common.util.JsonRestClient;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;

@Component
public class GetThreeDSessionResultRestClient extends
    JsonRestClient<GetThreeDSessionResultRequest, GetThreeDSessionResultResponse> {

  /**
   * GetThreeDSessionResult Rest Methodunun urlsi verilir.
   */
  @Override
  public String getUrl() {
    return PaycellWebApiConstants.RestConstants.GET_THREE_D_SESSION_RESULT_URL;
  }

  /**
   * GetThreeDSessionResult methodu çağrılır.
   *
   * @param request servis isteği
   * @return servis cevabı
   * @throws Exception servis ulaşımı sırasında bir hata oluşursa fırlatılır.
   */
  public GetThreeDSessionResultResponse getThreeDSessionResult(
      GetThreeDSessionResultRequest request) throws Exception {
    return sendRequest(request, GetThreeDSessionResultResponse.class);
  }

}
