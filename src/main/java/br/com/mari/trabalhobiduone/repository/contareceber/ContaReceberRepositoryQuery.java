package br.com.mari.trabalhobiduone.repository.contareceber;

import br.com.mari.trabalhobiduone.MODEL.ContaReceber;
import br.com.mari.trabalhobiduone.repository.filter.ContaReceberFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContaReceberRepositoryQuery {
    public Page<ContaReceber> filtrar(ContaReceberFilter contaReceberFilter, Pageable pageable);
}
