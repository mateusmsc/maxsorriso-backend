package io.github.mateusmsc.maxsorriso.rest;

import io.github.mateusmsc.maxsorriso.model.entity.Casos;
import io.github.mateusmsc.maxsorriso.model.repository.CasosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/casos")
public class CasosController {
    private  final CasosRepository repository;
    @Autowired
    public CasosController(CasosRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Casos> getAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Casos getById(@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Caso não encontrado"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Casos save (@RequestBody @Valid Casos casos){
        return repository.save(casos);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
        repository
                .findById(id)
                .map(casos -> {
                    repository.delete(casos);
                    return casos;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Integer id, @RequestBody @Valid Casos casosUpdated){
        repository
                .findById(id)
                .map(casos -> {
                    casos.setPaciente(casosUpdated.getPaciente());
                    casos.setDoutor(casosUpdated.getDoutor());
                    casos.setStatus(casosUpdated.getStatus());
                    casos.setTomografia(casosUpdated.getTomografia());
                    casos.setData_cirurgia(casosUpdated.getData_cirurgia());
                    return repository.save(casos);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
