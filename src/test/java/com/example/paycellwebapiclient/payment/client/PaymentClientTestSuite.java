package com.example.paycellwebapiclient.payment.client;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.example.paycellwebapiclient.payment.client.inquire.InquireClientTest;
import com.example.paycellwebapiclient.payment.client.provision.ProvisionClientTest;
import com.example.paycellwebapiclient.payment.client.provisionformarketplace.ProvisionForMarketPlaceClientTest;
import com.example.paycellwebapiclient.payment.client.provisionhistory.GetProvisionHistoryClientTest;
import com.example.paycellwebapiclient.payment.client.refund.RefundClientTest;
import com.example.paycellwebapiclient.payment.client.reverse.ReverseClientTest;
import com.example.paycellwebapiclient.payment.client.summaryreconciliation.SummaryReconciliationClientTest;

@RunWith(Suite.class)
@SuiteClasses({ProvisionClientTest.class, ProvisionForMarketPlaceClientTest.class,
    InquireClientTest.class, GetProvisionHistoryClientTest.class, RefundClientTest.class,
    ReverseClientTest.class, SummaryReconciliationClientTest.class})
public class PaymentClientTestSuite {



}
