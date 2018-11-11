package app;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Long> {

	List<OrderDetails> findByProductId(Long id);
	List<OrderDetails> findAll();
	List<OrderDetails> findByOrderId(Long id);
	
}
