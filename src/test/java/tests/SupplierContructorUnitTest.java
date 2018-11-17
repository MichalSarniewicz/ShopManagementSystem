package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import app.ShopManagementSystemApplication;
import model.Supplier;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ShopManagementSystemApplication.class })
public class SupplierContructorUnitTest {

	@Test
	public void whenCreated_thenReturnSupplier() {

		// when
		Supplier supplier = new Supplier("supplier", "ul. Polna 10 05-077 Warszawa", "apple supplier", 504888222,
				"fdfdsf@op.pl");

		// then
		assertEquals("supplier", supplier.getName());
		assertEquals("ul. Polna 10 05-077 Warszawa", supplier.getAdress());
		assertEquals("apple supplier", supplier.getComment());
		assertEquals(504888222, supplier.getPhoneNumber());
		assertEquals("fdfdsf@op.pl", supplier.getEmail());
	}
}
