package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import model.SupplyWithProductInfo;

public interface SupplyWithProductInfoRepository extends CrudRepository<SupplyWithProductInfo, Long> {

	@Query( value = "SELECT t2.id, t2.brand, t2.name, t2.grossPrice, t1.quantity,   t2.grossPrice * t1.quantity AS grossSum FROM " + 
			"(SELECT * FROM supplyDetails " + 
			"WHERE supplyID = ?#{[0]}) AS t1 " + 
			"INNER JOIN product AS t2 " + 
			"ON t1.productId = t2.id;", 
			  nativeQuery = true)
	List<SupplyWithProductInfo> findAllProductsBySupplyId(@Param("id") Long productId);
}

