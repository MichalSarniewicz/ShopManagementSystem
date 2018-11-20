package repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import model.SupplyDetails;

/**
 * This interface creates a repository with crud operations for supplies.
 * Interface extends CrudRepository.
 * 
 * @author Michał Sarniewicz
 *
 */
public interface SupplyDetailsRepository extends CrudRepository<SupplyDetails, Long> {

	List<SupplyDetails> findByProductId(Long id);
	List<SupplyDetails> findAll();
}
