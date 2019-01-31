package com.example.paycellwebapiclient.card.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.paycellwebapiclient.card.client.token.HashDataGenerator;

@RestController
public class HashRestController {

  /**
   * Servis isteği yapılmadan önceki hashleme için kullanılır.
   * @param request
   * @return
   */
  @PostMapping("/hashRequest")
  public String hashRequest(@RequestBody HashRequestRequest request) {
    return HashDataGenerator.generateForRequest(request.getTransactionId(),
        request.getTransactionDateTime());
  }

  /**
   * Servisin döndüğü hash değerinin kontrolü için kullanılır.
   * @param response
   * @return
   */
  @PostMapping("/hashResponse")
  public String hashResponse(@RequestBody HashResponseRequest response) {
    return HashDataGenerator.generateForResponse(response.getTransactionId(),
        response.getResponseDateTime(), response.getResponseCode(),
        response.getCardToken());
  }



}
