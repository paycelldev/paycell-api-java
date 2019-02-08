package com.example.paycellwebapiclient.common.util;

public class PaycellWebApiConstants {

  public static final String APPLICATION_NAME = "PAYCELLTEST";
  public static final String APPLICATION_PASSWORD = "PaycellTestPassword";
  public static final String SECURE_CODE = "PAYCELL12345";
  public static final String EULAID = "17";
  public static final String MERCHANT_CODE = "9998";
  public static final String REFERENCE_NUMBER_PREFIX = "001";

  public static final String GET_CARD_TOKEN_URL =
      "https://omccstb.turkcell.com.tr/paymentmanagement/rest/getCardTokenSecure";
  public static final String THREE_D_SECURE_URL =
      "https://omccstb.turkcell.com.tr/paymentmanagement/rest/threeDSecure";

  public static final String SUCCESS_CODE = "0";

  public class RestConstants {
    public static final String GET_CARDS_URL =
        "https://tpay-test.turkcell.com.tr/tpay/provision/services/restful/getCardToken/getCards/";
    public static final String REGISTER_CARD_URL =
        "https://tpay-test.turkcell.com.tr/tpay/provision/services/restful/getCardToken/registerCard/";
    public static final String UPDATE_CARD_URL =
        "https://tpay-test.turkcell.com.tr/tpay/provision/services/restful/getCardToken/updateCard/";
    public static final String DELETE_CARD_URL =
        "https://tpay-test.turkcell.com.tr/tpay/provision/services/restful/getCardToken/deleteCard/";
    public static final String PROVISION_URL =
        "https://tpay-test.turkcell.com.tr/tpay/provision/services/restful/getCardToken/provision/";
    public static final String INQUIRE_URL =
        "https://tpay-test.turkcell.com.tr/tpay/provision/services/restful/getCardToken/inquire/";
    public static final String REVERSE_URL =
        "https://tpay-test.turkcell.com.tr/tpay/provision/services/restful/getCardToken/reverse/";
    public static final String REFUND_URL =
        "https://tpay-test.turkcell.com.tr/tpay/provision/services/restful/getCardToken/refund/";
    public static final String SUMMARY_RECONCILIATION_URL =
        "https://tpay-test.turkcell.com.tr/tpay/provision/services/restful/getCardToken/summaryReconciliation/";
    public static final String GET_THREE_D_SESSION_URL =
        "https://tpay-test.turkcell.com.tr/tpay/provision/services/restful/getCardToken/getThreeDSession/";
    public static final String GET_THREE_D_SESSION_RESULT_URL =
        "https://tpay-test.turkcell.com.tr/tpay/provision/services/restful/getCardToken/getThreeDSessionResult/";
    public static final String GET_PROVISION_HISTORY_URL =
        "https://tpay-test.turkcell.com.tr/tpay/provision/services/restful/getCardToken/getProvisionHistory";
    public static final String PROVISION_FOR_MARKET_PLACE_URL =
        "https://tpay-test.turkcell.com.tr/tpay/provision/services/restful/getCardToken/provisionForMarketPlace/";
    public static final String GET_TERMS_OF_SERVICE_CONTENT_URL =
        "https://tpay-test.turkcell.com.tr/tpay/provision/services/restful/getCardToken/getTermsOfServiceContent";

  }

  public class SoapConstants {
    public static final String PROVISION_SERVICES_URL =
        "https://tpay-test.turkcell.com.tr/tpay/provision/services/ws";
  }

}
