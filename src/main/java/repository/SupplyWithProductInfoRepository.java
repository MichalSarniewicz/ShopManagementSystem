package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import model.SupplyWithProductInfo;

/**
 * This interface creates a repository with crud operations for objects
 * SupplyWithProductInfo. We need this repository to execute 
 * query which uses many tables and passes it to one object.
 * Interface extends CrudRepository.
 * 
 * @author Michał Sarniewicz
 *
 */
public interface SupplyWithProductInfoRepository extends CrudRepository<SupplyWithProductInfo, Long> {

	//this query uses product id to find connected supplies
	@Query( value = "SELECT t2.id, t2.brand, t2.name, t2.grossPrice, t1.quantity,   t2.grossPrice * t1.quantity AS grossSum FROM " + 
			"(SELECT * FROM supplyDetails " + 
			"WHERE supplyID = ?#{[0]}) AS t1 " + 
			"INNER JOIN product AS t2 " + 
			"ON t1.productId = t2.id;", 
			  nativeQuery = true)
	List<SupplyWithProductInfo> findAllProductsBySupplyId(@Param("id") Long productId);
}

