package com.example.paycellwebapiclient.threedsession.get;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreeDSecurePageResultHandler {


  @GetMapping("/handleThreeDSecurePageResult")
  public void handle(String response) {
    System.out.println(response);
  }


}
