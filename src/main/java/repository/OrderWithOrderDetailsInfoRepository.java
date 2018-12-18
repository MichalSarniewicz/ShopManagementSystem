package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import model.OrderWithOrderDetailsInfo;

/**
 * This interface creates a repository with crud operations for objects
 * OrderWithOrderDetailsInfo. We need this repository to execute 
 * query which uses many tables and passes it to one object.
 * Interface extends CrudRepository.
 * 
 * @author Michał Sarniewicz
 *
 */
public interface OrderWithOrderDetailsInfoRepository extends CrudRepository<OrderWithOrderDetailsInfo, Long> {

	//this query uses product id to find connected orders and more details
	@Query( value = "SELECT t2.id, t2.dateAndTime, t1.quantity FROM " + 
			"(SELECT * FROM orderDetails " + 
			"WHERE  productId = ?#{[0]}) AS t1 " + 
			"INNER JOIN orders AS t2 " + 
			"ON t2.id = t1.orderId; ", 
			  nativeQuery = true)
	List<OrderWithOrderDetailsInfo> findAllOrdersByProductId(@Param("id") Long productId);
}

