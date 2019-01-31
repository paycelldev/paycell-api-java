package com.example.paycellwebapiclient.card.client;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.example.paycellwebapiclient.card.client.delete.DeleteCardClientTest;
import com.example.paycellwebapiclient.card.client.query.GetCardsClientTest;
import com.example.paycellwebapiclient.card.client.register.RegisterCardClientTest;
import com.example.paycellwebapiclient.card.client.token.GetCardTokenRestClientTest;
import com.example.paycellwebapiclient.card.client.update.UpdateCardClientTest;

@RunWith(Suite.class)
@SuiteClasses({GetCardsClientTest.class, GetCardTokenRestClientTest.class,
    RegisterCardClientTest.class, DeleteCardClientTest.class, UpdateCardClientTest.class})
public class CardClientTestSuite {

}
