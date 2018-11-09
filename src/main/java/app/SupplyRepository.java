package app;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SupplyRepository extends CrudRepository<Supply, Long> {

	List<Supply> findByid(Long id);
	List<Supply> findAll();
	
}
