package io.github.mateusmsc.maxsorriso.rest;

import io.github.mateusmsc.maxsorriso.model.entity.Paciente;
import io.github.mateusmsc.maxsorriso.model.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteRepository repository;
    @Autowired
    public PacienteController(PacienteRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Paciente> getAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Paciente getById(@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Paciente não encontrado"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente save(@RequestBody @Valid Paciente paciente){
        return repository.save(paciente);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
        repository
                .findById(id)
                .map(paciente -> {
                    repository.delete(paciente);
                    return paciente;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Integer id, @RequestBody @Valid Paciente pacienteUpdated){
        repository
                .findById(id)
                .map(paciente -> {
                    paciente.setEmail(pacienteUpdated.getEmail());
                    paciente.setNome(pacienteUpdated.getNome());
                    paciente.setTelefone(pacienteUpdated.getTelefone());
                    paciente.setData_nascimento(pacienteUpdated.getData_nascimento());
                    return repository.save(paciente);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
