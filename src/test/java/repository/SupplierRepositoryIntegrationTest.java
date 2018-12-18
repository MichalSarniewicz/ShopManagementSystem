package repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import app.ShopManagementSystemApplication;
import model.Supplier;
import repository.SupplierRepository;

/*
 * Integration test for Supplier repository
 */
@ContextConfiguration(classes = { ShopManagementSystemApplication.class })
@RunWith(SpringRunner.class)
@DataJpaTest
public class SupplierRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private SupplierRepository supplierRepository;

	@Test
	public void whenFindByName_thenReturnSupplier() {

		// given
		Supplier supplier = new Supplier("supplier", "ul. Polna 10 05-077 Warszawa", "apple supplier", 504888222,
				"fdfdsf@op.pl");
		entityManager.persist(supplier);
		entityManager.flush();

		// when
		List<Supplier> found = supplierRepository.findByName(supplier.getName());

		// then
		assertThat(found.get(0).getName()).isEqualTo(supplier.getName());
	}
}