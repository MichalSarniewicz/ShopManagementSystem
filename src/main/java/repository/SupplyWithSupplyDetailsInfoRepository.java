package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.SupplyWithSupplyDetailsInfo;

/**
 * This interface creates a repository with crud operations for objects
 * SupplyWithSupplyDetailsInfo. We need this repository to execute 
 * query which uses many tables and passes it to one object.
 * Interface extends CrudRepository.
 * 
 * @author Michał Sarniewicz
 *
 */
@Repository
public interface SupplyWithSupplyDetailsInfoRepository extends CrudRepository<SupplyWithSupplyDetailsInfo, Long> {

	//this query uses product id to find connected supplies
	@Query( value = "SELECT t2.id, t2.dateAndTime, t1.quantity FROM " + 
			"(SELECT * FROM supplyDetails " + 
			"WHERE  productId = ?#{[0]}) AS t1 " + 
			"INNER JOIN supply AS t2 " + 
			"ON t2.id = t1.supplyId;", 
			  nativeQuery = true)
	List<SupplyWithSupplyDetailsInfo> findAllSuppliesByProductId(@Param("id") Long productId);
}

