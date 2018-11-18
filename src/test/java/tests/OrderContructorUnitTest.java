package tests;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import app.ShopManagementSystemApplication;
import model.Order;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ShopManagementSystemApplication.class })
public class OrderContructorUnitTest {

	@Test
	public void whenCreated_thenReturnOrder() {

		// given
		BigDecimal netPrice = new BigDecimal("2113.01");
		BigDecimal grossPrice = new BigDecimal("2599.00");
		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0");

		// when
		Order order = new Order(netPrice, grossPrice, timestamp, 1, 1);

		// then
		assertEquals(netPrice, order.getNetPrice());
		assertEquals(grossPrice, order.getGrossPrice());
		assertEquals(timestamp, order.getDateAndTime());
		assertEquals(1, order.getEmployeeId());
		assertEquals(1, order.getCashdeskId());
	}
}