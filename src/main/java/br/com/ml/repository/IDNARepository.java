package br.com.ml.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ml.entity.DNA;
import br.com.ml.entity.DNAStats;

@Repository
public interface IDNARepository extends JpaRepository<DNA, Long> {

	@Query("SELECT new br.com.ml.entity.DNAStats((SELECT COUNT(1) FROM DNA) ,COUNT(1)) FROM DNA u WHERE u.mutante = true")
	DNAStats findMutanteCount();
	
}
