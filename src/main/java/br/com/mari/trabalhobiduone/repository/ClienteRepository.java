package br.com.mari.trabalhobiduone.repository;

import br.com.mari.trabalhobiduone.MODEL.Cliente;
import br.com.mari.trabalhobiduone.repository.cliente.ClienteRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteRepositoryQuery {
}
