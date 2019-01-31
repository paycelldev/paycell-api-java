package com.example.paycellwebapiclient.card.client.token;

import static com.example.paycellwebapiclient.common.util.PaycellWebApiConstants.APPLICATION_NAME;
import static com.example.paycellwebapiclient.common.util.PaycellWebApiConstants.APPLICATION_PASSWORD;
import static com.example.paycellwebapiclient.common.util.PaycellWebApiConstants.SECURE_CODE;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashDataGenerator {

  /**
   * PAYCELL tarafından iletilecek applicationPwd ve secureCode ile input parametreleri hash'lenir.
   * Hash data oluşturulmasında kullanılacak olan güvenlik parametreleri (applicationName,
   * applicationPwd, secureCode) server tarafında tutulmalıdır, hash oluşturma işlemi server tarafında
   * yapılmalıdır, ancak oluşan değerler uygulama/client tarafında iletilerek getCardToken servisi
   * uygulama/client tarafından çağrılmalıdır.
   *
   * hashData 2 aşamada oluşturulacaktır. Her iki aşamada da ilgili parametreler büyük harfe
   * dönüştürülerek data oluşturulmalıdır.
   *
   * İlk aşamada securityData hashlenerek oluşturulur. securityData oluşturulurken applicationName ve
   * applicationPwd değeri büyük harfe çevrilir. Oluşan securityData değeri ikinci aşamadaki hashData
   * üretiminde kullanılmak üzere büyük harfe dönüştürülür.
   *
   * İkinci aşamada, oluşturulan securityData ile diğer değerler büyük harfe çevrilerek birleştirilip
   * elde edilen değer hashlenerek hashData oluşturulur.
   *
   * securityData: applicationPwd+ applicationName hashData: applicationName+ transactionId+
   * transactionDateTime+ secureCode + securityData
   *
   * @param transactionId
   * @param transactionDateTime
   * @return
   */
  public static String generateForRequest(String transactionId,
      String transactionDateTime) {
    String securityData =
        APPLICATION_PASSWORD.toUpperCase() + APPLICATION_NAME.toUpperCase();

    securityData = hash(securityData).toUpperCase();

    String hashData = APPLICATION_NAME.toUpperCase() + transactionId.toUpperCase()
        + transactionDateTime.toUpperCase() + SECURE_CODE.toUpperCase() + securityData;
    hashData = hash(hashData);
    return hashData;
  }

  /**
   * ResponseBody'de dönülen hashData ile üye işyerinin oluşturacağı hashData eşit olmalıdır. Bu
   * kontrol üye işyeri tarafından yapılır.
   *
   * Üye işyerinin oluşturacağı hashData 2 aşamada oluşturulacaktır.
   *
   * İlk aşamada securityData hashlenerek oluşturulur.
   *
   * İkinci aşamada oluşturulan securityData ile diğer değerler birleştirilerek elde edilen değer
   * hashlenerek hashData oluşturulur. securityData: applicationPwd+ applicationName
   *
   * hashData: applicationName+ transactionId+ responseDateTime + responseCode + cardToken +
   * secureCode + securityData
   *
   * @param transactionId
   * @param responseDateTime
   * @param responseCode
   * @param cardToken
   * @return
   */
  public static String generateForResponse(String transactionId, String responseDateTime,
      String responseCode, String cardToken) {
    String securityData =
        APPLICATION_PASSWORD.toUpperCase() + APPLICATION_NAME.toUpperCase();
    securityData = hash(securityData);
    String hashData = hash(APPLICATION_NAME.toUpperCase() + transactionId.toUpperCase()
        + responseDateTime.toUpperCase() + responseCode.toUpperCase()
        + cardToken.toUpperCase() + SECURE_CODE.toUpperCase()
        + securityData.toUpperCase());
    return hashData;
  }

  /**
   * Text sha1 ile hashlenerek Base64 ile gösterilir.
   *
   * @param text
   * @return
   */
  private static String hash(String text) {
    try {
      MessageDigest sha1 = MessageDigest.getInstance("SHA-256");
      return Base64.getEncoder().encodeToString(sha1.digest(text.getBytes()));
    } catch (NoSuchAlgorithmException e) {
      return null;
    }
  }

}
