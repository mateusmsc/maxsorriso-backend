package io.github.mateusmsc.maxsorriso.rest;

import io.github.mateusmsc.maxsorriso.model.entity.Caso;
import io.github.mateusmsc.maxsorriso.model.repository.CasoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/caso")
public class CasoController {
    private  final CasoRepository repository;
    @Autowired
    public CasoController(CasoRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Caso> getAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Caso getById(@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Caso não encontrado"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Caso save (@RequestBody @Valid Caso caso){
        return repository.save(caso);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
        repository
                .findById(id)
                .map(caso -> {
                    repository.delete(caso);
                    return caso;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Integer id, @RequestBody @Valid Caso casoUpdated){
        repository
                .findById(id)
                .map(caso -> {
                    caso.setPaciente(casoUpdated.getPaciente());
                    caso.setDoutor(casoUpdated.getDoutor());
                    caso.setStatus(casoUpdated.getStatus());
                    caso.setTomografia(casoUpdated.getTomografia());
                    caso.setData_cirurgia(casoUpdated.getData_cirurgia());
                    return repository.save(caso);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
