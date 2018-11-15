package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import model.Product;

/**
 * This interface creates a repository with crud operations for products.
 * Interface extends CrudRepository.
 * 
 * @author Michał Sarniewicz
 *
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByName(String name);
	List<Product> findAll();
	
	//query used to find quantity of products
	@Query( value = "SELECT max(id) FROM product; ", 
			  nativeQuery = true)
	Integer findMaxId();
}
