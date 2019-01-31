package com.example.paycellwebapiclient.ui.payment.provision;

public interface ProvisionForMarketPlaceListener {

  void sendProvisionForMarketPlace();

  void sendProvisionForMarketPlaceThreeD();

  void listenProvisionForMarketPlaceThreeD();

  void addExtraParameter();

  void addSubMerchant();

  void addCustomerEMail();

  void deleteExtraParameter(String id);

  void deleteSubMerchant(String id);

  void deleteCustomerEMail(String id);

}
