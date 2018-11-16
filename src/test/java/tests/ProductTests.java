package tests;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import app.ShopManagementSystemApplication;
import model.Product;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={ShopManagementSystemApplication.class})
public class ProductTests {

	@Test
	public void productConstructorTest(){
	
	BigDecimal netPrice =  new BigDecimal("10.12");
	BigDecimal grossPrice =  new BigDecimal("12.09");
	
	Product product = new Product("Iphone", "Apple", 10, "phones", netPrice, grossPrice, 23, 4, 6, "piece");
	
	assertEquals("Iphone", product.getName());
	assertEquals("Apple", product.getBrand());
	assertEquals(10, product.getQuantity());
	assertEquals(netPrice, product.getNetPrice());
	assertEquals(grossPrice, product.getGrossPrice());
	assertEquals(23, product.getTaxRate());
	assertEquals(4, product.getQuantityInStore());
	assertEquals(6, product.getQuantityInWarehouse());
	assertEquals("piece", product.getUnit());
	}
}
