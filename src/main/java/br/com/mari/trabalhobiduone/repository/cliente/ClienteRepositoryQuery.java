package br.com.mari.trabalhobiduone.repository.cliente;

import br.com.mari.trabalhobiduone.MODEL.Cliente;
import br.com.mari.trabalhobiduone.repository.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {
    public Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable);
}
