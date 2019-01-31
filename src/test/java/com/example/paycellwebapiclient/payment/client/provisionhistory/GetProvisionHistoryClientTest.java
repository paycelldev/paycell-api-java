package com.example.paycellwebapiclient.payment.client.provisionhistory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.turkcelltech.mf.tpay.web.provision.GetProvisionHistoryRequest;
import com.turkcelltech.mf.tpay.web.provision.GetProvisionHistoryResponse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GetProvisionHistoryClientTest {

  @Autowired
  GetProvisionHistoryClient getProvisionHistoryClient;

  @Test
  public void testGetProvisionHistoryRest() throws Exception {
    GetProvisionHistoryRequestFactory factory = new GetProvisionHistoryRequestFactory();
    factory.setClientIPAddress("4.4.4.4");
    factory.setReconciliationDate("20181121");
    GetProvisionHistoryRequest request = factory.build();
    GetProvisionHistoryResponse response =
        getProvisionHistoryClient.getProvisionHistory(request, ConnectionMethod.REST);
    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());
  }

  @Test
  public void testGetProvisionHistorySoap() throws Exception {
    GetProvisionHistoryRequestFactory factory = new GetProvisionHistoryRequestFactory();
    factory.setClientIPAddress("4.4.4.4");
    factory.setReconciliationDate("20181121");
    GetProvisionHistoryRequest request = factory.build();
    GetProvisionHistoryResponse response =
        getProvisionHistoryClient.getProvisionHistory(request, ConnectionMethod.SOAP);
    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());
  }

}
