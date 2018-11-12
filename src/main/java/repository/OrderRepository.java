package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

	List<Order> findByid(Long id);

	List<Order> findAll();
	
	@Query( value = "SELECT max(id) FROM orders; ", 
			  nativeQuery = true)
	Integer findMaxId();
}
