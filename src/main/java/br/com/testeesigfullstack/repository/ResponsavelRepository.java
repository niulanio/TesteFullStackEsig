package br.com.testeesigfullstack.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.testeesigfullstack.model.Responsavel;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long>{
	

}
