package com.example.paycellwebapiclient.card.client.token;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.paycellwebapiclient.common.util.PaycellWebApiConstants;
import com.example.paycellwebapiclient.common.util.UniqueIdGenerator;

public class GetCardTokenRequestFactory {

  private static final String CREDIT_CARD_NO_PATTERN = "\\d{16}";

  private static SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");

  private GetCardTokenRequest request;

  public GetCardTokenRequestFactory() {
    request = new GetCardTokenRequest();
    request.setHeader(createRequestHeader());
  }

  public GetCardTokenRequestFactory setCreditCardNo(String creditCardNo)
      throws Exception {
    if (creditCardNo != null && !creditCardNo.matches(CREDIT_CARD_NO_PATTERN)) {
      throw new Exception("CreditCardNo must match pattern: " + CREDIT_CARD_NO_PATTERN);
    }
    request.setCreditCardNo(creditCardNo);
    return this;
  }

  public GetCardTokenRequestFactory setExpireDate(String expireDateMonth,
      String expireDateYear) {
    request.setExpireDateMonth(expireDateMonth);
    request.setExpireDateYear(expireDateYear);
    return this;
  }

  public GetCardTokenRequestFactory setCvcNo(String cvcNo) {
    request.setCvcNo(cvcNo);
    return this;
  }

  public GetCardTokenRequest build() throws Exception {
    preBuild();
    return request;
  }

  private void preBuild() {
    String transactionId = request.getHeader().getTransactionId();
    String transactionDateTime = request.getHeader().getTransactionDateTime();
    String hashData =
        HashDataGenerator.generateForRequest(transactionId, transactionDateTime);
    request.setHashData(hashData);
  }

  private RequestHeader createRequestHeader() {
    RequestHeader requestHeader = new RequestHeader();
    requestHeader.setApplicationName(PaycellWebApiConstants.APPLICATION_NAME);
    requestHeader.setTransactionDateTime(sdf.format(new Date()));
    requestHeader.setTransactionId(UniqueIdGenerator.generateTransactionId());
    return requestHeader;
  }

}
