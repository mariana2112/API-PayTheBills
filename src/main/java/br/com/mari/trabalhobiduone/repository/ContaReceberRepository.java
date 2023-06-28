package br.com.mari.trabalhobiduone.repository;

import br.com.mari.trabalhobiduone.MODEL.ContaReceber;
import br.com.mari.trabalhobiduone.repository.contareceber.ContaReceberRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaReceberRepository extends JpaRepository<ContaReceber, Long>, ContaReceberRepositoryQuery {
}
