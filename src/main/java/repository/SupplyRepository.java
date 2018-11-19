package repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Supply;

/**
 * This interface creates a repository with crud operations for supplies.
 * Interface extends CrudRepository.
 * 
 * @author Michał Sarniewicz
 *
 */
@Repository
public interface SupplyRepository extends CrudRepository<Supply, Long> {

	List<Supply> findBySupplierId(Long id);
	List<Supply> findAll();
	List<Supply> findByNetSum(BigDecimal netSum);
	
	//this query is used to find quantity of supplies
	@Query( value = "SELECT max(id) FROM supply; ", 
			  nativeQuery = true)
	Integer findMaxId();
	
	
}
