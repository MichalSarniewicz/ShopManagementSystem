package app;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

	List<Order> findByid(Long id);

	List<Order> findAll();
	
}
