package com.example.paycellwebapiclient.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UniqueIdGenerator {

  private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

  public static synchronized String generateTransactionId() {
    return PaycellWebApiConstants.REFERENCE_NUMBER_PREFIX + sdf.format(new Date());
  }

  public static synchronized String generateReferenceNumber() {
    return PaycellWebApiConstants.REFERENCE_NUMBER_PREFIX + sdf.format(new Date());
  }

}
