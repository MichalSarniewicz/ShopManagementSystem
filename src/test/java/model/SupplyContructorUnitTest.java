package model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import app.ShopManagementSystemApplication;
import model.Supply;

@ContextConfiguration(classes=ShopManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
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
