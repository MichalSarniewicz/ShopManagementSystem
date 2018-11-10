package app;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import additionals.ProductWithOrderInfo;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Long> {

	List<OrderDetails> findByProductId(Long id);
	List<OrderDetails> findAll();
	List<OrderDetails> findByOrderId(Long id);
	/*
	@Query( value = "SELECT productId FROM ORDERDETAILS od WHERE od.orderId = ?#{[0]}", 
			  nativeQuery = true)
	ArrayList<Long> findAllProductsIdByOrderId(@Param("orderId") Long orderId);
	
	@Query( value = "SELECT quantity FROM ORDERDETAILS od WHERE od.orderId = ?#{[0]}", 
			  nativeQuery = true)
	ArrayList<Integer> findAllQuntitiesByOrderId(@Param("orderId") Long orderId);
	*/
	
	
	@Query( value = "SELECT t2.id, t2.brand, t2.name, t2.grossPrice, t1.quantity, t2.grossPrice* t1.quantity AS grossSum  FROM " + 
			"(SELECT * FROM orderDetails WHERE orderId = ?#{[0]}) AS t1 " + 
			"INNER JOIN " + 
			"PRODUCT AS t2 " + 
			"ON t1.productId = t2.id; ", 
			  nativeQuery = true)
	ResultSet findAllProductsByOrderId(@Param("id") Long orderId);
	
	
}
