package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import model.Supply;

public interface SupplyRepository extends CrudRepository<Supply, Long> {

	List<Supply> findBySupplierId(Long id);
	List<Supply> findAll();
	
	@Query( value = "SELECT max(id) FROM supply; ", 
			  nativeQuery = true)
	Integer findMaxId();
}
