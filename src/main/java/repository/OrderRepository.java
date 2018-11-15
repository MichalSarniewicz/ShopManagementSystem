package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import model.Order;

/**
 * This interface creates a repository with crud operations for orders.
 * Interface extends CrudRepository.
 * 
 * @author Michał Sarniewicz
 *
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

	List<Order> findByid(Long id);

	List<Order> findAll();

	//this query is used to find quantity of orders.
	@Query( value = "SELECT max(id) FROM orders; ", 
			  nativeQuery = true)
	Integer findMaxId();
}
