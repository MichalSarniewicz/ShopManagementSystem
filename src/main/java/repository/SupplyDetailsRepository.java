package repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.SupplyDetails;

/**
 * This interface creates a repository with crud operations for supplies.
 * Interface extends CrudRepository.
 * 
 * @author Michał Sarniewicz
 *
 */
@Repository
public interface SupplyDetailsRepository extends CrudRepository<SupplyDetails, Long> {

	List<SupplyDetails> findByProductId(Long id);
	List<SupplyDetails> findAll();
}
