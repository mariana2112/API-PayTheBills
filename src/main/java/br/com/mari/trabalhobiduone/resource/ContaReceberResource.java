package br.com.mari.trabalhobiduone.resource;

import br.com.mari.trabalhobiduone.MODEL.ContaReceber;
import br.com.mari.trabalhobiduone.repository.ContaReceberRepository;
import br.com.mari.trabalhobiduone.repository.filter.ContaReceberFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contareceber")
public class ContaReceberResource {

    @Autowired
    ContaReceberRepository contaReceberRepository;

    @GetMapping
    public Page<ContaReceber> pesquisar( ContaReceberFilter contaReceberFilter, Pageable pageable) {
        return contaReceberRepository.filtrar(contaReceberFilter, pageable);
    }

    @GetMapping("/todos")
    public List<ContaReceber> listarTodos() {
        return contaReceberRepository.findAll();
    }

    @PostMapping("criar")
    public ContaReceber save(ContaReceber contaReceber) {
        return contaReceberRepository.save(contaReceber);
    }
}
