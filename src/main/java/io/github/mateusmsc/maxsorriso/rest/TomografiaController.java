package io.github.mateusmsc.maxsorriso.rest;

import io.github.mateusmsc.maxsorriso.model.entity.Tomografia;
import io.github.mateusmsc.maxsorriso.model.repository.TomografiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tomografia")
public class TomografiaController {

    private final TomografiaRepository repository;
    @Autowired
    public TomografiaController(TomografiaRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Tomografia> getAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Tomografia getById(@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Tomografia não encontrado"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Tomografia save(@RequestBody @Valid Tomografia tomografia){
        return repository.save(tomografia);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
        repository
                .findById(id)
                .map(tomografia -> {
                    repository.delete(tomografia);
                    return tomografia;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Integer id, @RequestBody @Valid Tomografia tomografiaUpdated){
        repository
                .findById(id)
                .map(tomografia -> {
                    tomografia.setCod_projeto(tomografiaUpdated.getCod_projeto());
                    tomografia.setEspessura_tc(tomografiaUpdated.getEspessura_tc());
                    tomografia.setPaciente(tomografiaUpdated.getPaciente());
                    return repository.save(tomografia);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
