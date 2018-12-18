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
import model.Supply;
import repository.SupplyRepository;

/*
 * Integration test for Supply repository
 */
@ContextConfiguration(classes=ShopManagementSystemApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class SupplyRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private SupplyRepository supplyRepository;

	@Test
	public void whenFindByNetPrice_thenReturnSupply() {

		// given
		BigDecimal netSum = new BigDecimal("2113.01");
		BigDecimal grossSum = new BigDecimal("2599.00");
		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0");

		Supply supply = new Supply(netSum, grossSum, timestamp, (long) 1);
		entityManager.persist(supply);
		entityManager.flush();

		// when
		List<Supply> found = supplyRepository.findByNetSum(supply.getNetSum());

		// then
		assertThat(found.get(0).getNetSum()).isEqualTo(supply.getNetSum());
	}
}