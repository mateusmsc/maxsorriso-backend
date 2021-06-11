package io.github.mateusmsc.maxsorriso.rest;

import io.github.mateusmsc.maxsorriso.model.entity.Status;
import io.github.mateusmsc.maxsorriso.model.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping ("/status")
public class StatusController {

    // Criando a variável de acesso ao banco
    private final StatusRepository repository;
    @Autowired
    public StatusController(StatusRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Status> getALl(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Status getById(@PathVariable("id") Integer id){
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Status não encontrado"));
    }
}
