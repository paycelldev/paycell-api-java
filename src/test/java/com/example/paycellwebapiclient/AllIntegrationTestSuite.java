package com.example.paycellwebapiclient;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.example.paycellwebapiclient.card.client.CardClientTestSuite;
import com.example.paycellwebapiclient.payment.client.PaymentClientTestSuite;

@RunWith(Suite.class)
@SuiteClasses({CardClientTestSuite.class, PaymentClientTestSuite.class})
public class AllIntegrationTestSuite {

}
