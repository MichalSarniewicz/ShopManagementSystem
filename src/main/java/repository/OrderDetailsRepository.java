package repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import model.OrderDetails;

/**
 * This interface creates a repository with crud operations for details of orders.
 * Interface extends CrudRepository.
 * 
 * @author Michał Sarniewicz
 *
 */
public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Long> {

	List<OrderDetails> findByProductId(Long id);
	List<OrderDetails> findAll();
	List<OrderDetails> findByOrderId(Long id);
}
