package io.github.mateusmsc.maxsorriso.model.repository;

import io.github.mateusmsc.maxsorriso.model.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository <Paciente, Integer>{

    /*
    @Query(value = "SELECT * FROM paciente", nativeQuery = true)
    List<Paciente> findTodos();
    */
}
