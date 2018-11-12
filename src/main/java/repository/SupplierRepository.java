package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import model.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {

	List<Supplier> findAll();
	
	@Query( value = "SELECT max(id) FROM supplier; ", 
			  nativeQuery = true)
	Integer findMaxId();
}
