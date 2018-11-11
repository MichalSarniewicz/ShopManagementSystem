package repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

	List<Order> findByid(Long id);

	List<Order> findAll();
	
}
