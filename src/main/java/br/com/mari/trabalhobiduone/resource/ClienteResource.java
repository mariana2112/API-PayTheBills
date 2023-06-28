package br.com.mari.trabalhobiduone.resource;


import br.com.mari.trabalhobiduone.MODEL.Cliente;
import br.com.mari.trabalhobiduone.repository.ClienteRepository;
import br.com.mari.trabalhobiduone.repository.filter.ClienteFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    public Page<Cliente> pesquisar(ClienteFilter clienteFilter, Pageable pageable) {
        return clienteRepository.filtrar(clienteFilter, pageable);
    }

    @GetMapping("/todos")
    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @PostMapping("criar")
    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

}
