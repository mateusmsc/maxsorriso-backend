package io.github.mateusmsc.maxsorriso.rest;

import io.github.mateusmsc.maxsorriso.model.entity.Doutor;
import io.github.mateusmsc.maxsorriso.model.repository.DoutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/doutor")
public class DoutorController {

    private final DoutorRepository repository;
    @Autowired
    public DoutorController(DoutorRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Doutor> getAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Doutor getById(@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Doutor não encontrado"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Doutor save(@RequestBody @Valid Doutor doutor){
        return repository.save(doutor);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
        repository
                .findById(id)
                .map(doutor -> {
                    repository.delete(doutor);
                    return doutor;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Integer id, @RequestBody @Valid Doutor doutorUpdate ){
        repository
                .findById(id)
                .map(doutor ->{
                    doutor.setNome(doutorUpdate.getNome());
                    doutor.setEmail(doutorUpdate.getEmail());
                    doutor.setData_nascimento(doutorUpdate.getData_nascimento());
                    doutor.setCrm(doutorUpdate.getCrm());
                    doutor.setTelefone(doutorUpdate.getTelefone());
                    doutor.setUf(doutorUpdate.getUf());
                    return repository.save(doutor);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
