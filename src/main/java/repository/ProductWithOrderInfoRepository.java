package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.ProductWithOrderInfo;

/**
 * This interface creates a repository with crud operations for objects
 * ProductWithOrderInfo. We need this repository to execute 
 * query which uses many tables and passes it to one object.
 * Interface extends CrudRepository.
 * 
 * @author Michał Sarniewicz
 *
 */
@Repository
public interface ProductWithOrderInfoRepository extends CrudRepository<ProductWithOrderInfo, Long> {

	//this query uses order id to find connected products
	@Query( value = "SELECT t2.id, t2.brand, t2.name, t2.grossPrice, t1.quantity, t2.grossPrice*t1.quantity AS grossSum  FROM " + 
			"(SELECT * FROM orderDetails WHERE orderId = ?#{[0]}) AS t1 " + 
			"INNER JOIN " + 
			"PRODUCT AS t2 " + 
			"ON t1.productId = t2.id; ", 
			  nativeQuery = true)
	List<ProductWithOrderInfo> findAllProductsByOrderId(@Param("id") Long orderId);
}

