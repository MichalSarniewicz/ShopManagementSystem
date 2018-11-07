package app;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SupplyDetailsRepository extends CrudRepository<SupplyDetails, Long> {

	List<SupplyDetails> findByProductId(Long id);
	List<SupplyDetails> findAll();
}
