package app;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByName(String name);
	List<Product> findAll();
	
	@Query( value = "SELECT * FROM PRODUCT WHERE id IN ?#{[0]}", 
			  nativeQuery = true)
	ArrayList<Product> findByIds(List<Long> list);//mayby id instead ids?
}
