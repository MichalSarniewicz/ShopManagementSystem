package tests;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import app.ShopManagementSystemApplication;
import model.Supply;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ShopManagementSystemApplication.class })
public class SupplyContructorUnitTest {

	@Test
	public void whenCreated_thenReturnSupply() {

		// given
		BigDecimal netSum = new BigDecimal("2113.01");
		BigDecimal grossSum = new BigDecimal("2599.00");
		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0");

		// when
		Supply supply = new Supply(netSum, grossSum, timestamp, (long) 1);

		// then
		assertEquals(netSum, supply.getNetSum());
		assertEquals(grossSum, supply.getGrossSum());
		assertEquals(timestamp, supply.getDateAndTime());
		assertEquals(Long.valueOf(1), supply.getSupplierId());
	}
}
