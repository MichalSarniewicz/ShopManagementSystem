package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByName(String name);
	List<Product> findAll();
	
	@Query( value = "SELECT max(id) FROM product; ", 
			  nativeQuery = true)
	Integer findMaxId();
}
