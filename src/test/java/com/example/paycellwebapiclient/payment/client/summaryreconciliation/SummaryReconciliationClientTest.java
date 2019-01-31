package com.example.paycellwebapiclient.payment.client.summaryreconciliation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.paycellwebapiclient.common.util.BaseClient.ConnectionMethod;
import com.turkcelltech.mf.tpay.web.provision.SummaryReconciliationRequest;
import com.turkcelltech.mf.tpay.web.provision.SummaryReconciliationResponse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SummaryReconciliationClientTest {

  @Autowired
  SummaryReconciliationClient summaryReconciliationClient;

  @Test
  public void testSummaryReconciliationRest() throws Exception {
    SummaryReconciliationRequestFactory factory =
        new SummaryReconciliationRequestFactory();
    factory.setClientIPAddress("4.4.4.4");
    factory.setReconciliationDate("20160404");
    factory.setTotalSaleAmount("0");
    factory.setTotalReverseAmount("0");
    factory.setTotalRefundAmount("0");
    factory.setTotalSaleCount(0);
    factory.setTotalReverseCount(0);
    factory.setTotalRefundCount(0);

    SummaryReconciliationRequest request = factory.build();
    SummaryReconciliationResponse response =
        summaryReconciliationClient.summaryReconciliation(request, ConnectionMethod.REST);
    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());
  }

  @Test
  public void testSummaryReconciliationSoap() throws Exception {
    SummaryReconciliationRequestFactory factory =
        new SummaryReconciliationRequestFactory();
    factory.setClientIPAddress("4.4.4.4");
    factory.setReconciliationDate("20160404");
    factory.setTotalSaleAmount("0");
    factory.setTotalReverseAmount("0");
    factory.setTotalRefundAmount("0");
    factory.setTotalSaleCount(0);
    factory.setTotalReverseCount(0);
    factory.setTotalRefundCount(0);

    SummaryReconciliationRequest request = factory.build();
    SummaryReconciliationResponse response =
        summaryReconciliationClient.summaryReconciliation(request, ConnectionMethod.SOAP);
    assertNotNull(response);
    assertEquals("Success", response.getResponseHeader().getResponseDescription());
  }

}
