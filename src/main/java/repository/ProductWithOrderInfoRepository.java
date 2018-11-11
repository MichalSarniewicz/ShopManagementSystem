package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import model.ProductWithOrderInfo;

public interface ProductWithOrderInfoRepository extends CrudRepository<ProductWithOrderInfo, Long> {

	@Query( value = "SELECT t2.id, t2.brand, t2.name, t2.grossPrice, t1.quantity, t2.grossPrice*t1.quantity AS grossSum  FROM " + 
			"(SELECT * FROM orderDetails WHERE orderId = ?#{[0]}) AS t1 " + 
			"INNER JOIN " + 
			"PRODUCT AS t2 " + 
			"ON t1.productId = t2.id; ", 
			  nativeQuery = true)
	List<ProductWithOrderInfo> findAllProductsByOrderId(@Param("id") Long orderId);
}

