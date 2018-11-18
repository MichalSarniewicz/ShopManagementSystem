package tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import app.ShopManagementSystemApplication;
import model.Order;
import repository.OrderRepository;

@SpringBootTest(classes = { ShopManagementSystemApplication.class })
@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private OrderRepository orderRepository;

	@Test
	public void whenFindByNetPrice_thenReturnOrder() {

		// given
		BigDecimal netPrice = new BigDecimal("2113.01");
		BigDecimal grossPrice = new BigDecimal("2599.00");
		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0");

		Order order = new Order(netPrice, grossPrice, timestamp, 1, 1);
		entityManager.persist(order);
		entityManager.flush();

		// when
		List<Order> found = orderRepository.findByNetPrice(order.getNetPrice());

		// then
		assertThat(found.get(0).getNetPrice()).isEqualTo(order.getNetPrice());
	}
}