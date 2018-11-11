package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import model.SupplyWithSupplyDetailsInfo;

public interface SupplyWithSupplyDetailsInfoRepository extends CrudRepository<SupplyWithSupplyDetailsInfo, Long> {

	@Query( value = "SELECT t2.id, t2.dateAndTime, t1.quantity FROM " + 
			"(SELECT * FROM supplyDetails " + 
			"WHERE  productId = ?#{[0]}) AS t1 " + 
			"INNER JOIN supply AS t2 " + 
			"ON t2.id = t1.supplyId;", 
			  nativeQuery = true)
	List<SupplyWithSupplyDetailsInfo> findAllSuppliesByProductId(@Param("id") Long productId);
}

