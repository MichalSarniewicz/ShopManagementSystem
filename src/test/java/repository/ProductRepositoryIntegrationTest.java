package repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import app.ShopManagementSystemApplication;
import model.Product;
import repository.ProductRepository;

/*
 * Integration test for Product repository
 */
@ContextConfiguration(classes=ShopManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void whenFindByName_thenReturnProduct() {

		// given
		BigDecimal netPrice = new BigDecimal("2113.01");
		BigDecimal grossPrice = new BigDecimal("2599.00");

		Product product = new Product("Iphone", "Apple", 10, "phones", netPrice, grossPrice, 23, 4, 6, "piece");
		entityManager.persist(product);
		entityManager.flush();

		// when
		List<Product> found = productRepository.findByName(product.getName());

		// then
		assertThat(found.get(0).getName()).isEqualTo(product.getName());
	}
}