package br.com.mari.trabalhobiduone.repository.contareceber;


import br.com.mari.trabalhobiduone.MODEL.ContaReceber;
import br.com.mari.trabalhobiduone.repository.filter.ContaReceberFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ContaReceberRepositoryImpl implements ContaReceberRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<ContaReceber> filtrar(ContaReceberFilter contaReceberFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ContaReceber> criteria = builder.createQuery(ContaReceber.class);
        Root<ContaReceber> root = criteria.from(ContaReceber.class);

        Predicate[] predicates = criarRestricoes(contaReceberFilter, builder , root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("datacompra")));

        TypedQuery<ContaReceber> query = manager.createQuery(criteria);

        adicionarRestricoesDePagina(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(contaReceberFilter));
    }

    private Long total(ContaReceberFilter contaReceberFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<ContaReceber> root = criteria.from(ContaReceber.class);

        Predicate[] predicates = criarRestricoes(contaReceberFilter, builder , root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("datacompra")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }

    private void adicionarRestricoesDePagina(TypedQuery<ContaReceber> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalDeRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistro = paginaAtual * totalDeRegistrosPorPagina;

        query.setFirstResult(primeiroRegistro);
        query.setMaxResults(totalDeRegistrosPorPagina);
    }

    private Predicate[] criarRestricoes(ContaReceberFilter contaReceberFilter, CriteriaBuilder builder, Root<ContaReceber> root) {
        List<Predicate> predicates = new ArrayList<>();

        if(contaReceberFilter.getDatacompra() != null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("datacompra"), contaReceberFilter.getDatacompra()));
        }

        if(contaReceberFilter.getDatacompra() != null){
            predicates.add(builder.lessThanOrEqualTo(root.get("datacompra"), contaReceberFilter.getDatacompra()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
