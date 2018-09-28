package com.fmalessio.mercadolibre.Mutants.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.fmalessio.mercadolibre.Mutants.entity.Dna;

@NoRepositoryBean
interface MyBaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
	Optional<T> findById(ID id);

	<S extends T> S save(S entity);
}

public interface DnaRepository extends MyBaseRepository<Dna, String> {

	Dna findByDna(String dna);

	Long countByIsMutant(boolean isMutant);

}
