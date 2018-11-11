package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import model.OrderWithOrderDetailsInfo;

public interface OrderWithOrderDetailsInfoRepository extends CrudRepository<OrderWithOrderDetailsInfo, Long> {

	@Query( value = "SELECT t2.id, t2.dateAndTime, t1.quantity FROM " + 
			"(SELECT * FROM orderDetails " + 
			"WHERE  productId = ?#{[0]}) AS t1 " + 
			"INNER JOIN orders AS t2 " + 
			"ON t2.id = t1.orderId; ", 
			  nativeQuery = true)
	List<OrderWithOrderDetailsInfo> findAllOrdersByProductId(@Param("id") Long productId);
}

