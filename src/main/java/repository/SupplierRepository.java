package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import model.Supplier;

/**
 * This interface creates a repository with crud operations for suppliers.
 * Interface extends CrudRepository.
 * 
 * @author Michał Sarniewicz
 *
 */
public interface SupplierRepository extends CrudRepository<Supplier, Long> {

	List<Supplier> findAll();
	List<Supplier> findByName(String name);
	//query is used to find a quntity of suppliers
	@Query( value = "SELECT max(id) FROM supplier; ", 
			  nativeQuery = true)
	Integer findMaxId();
}
