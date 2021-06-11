package io.github.mateusmsc.maxsorriso.model.repository;

import io.github.mateusmsc.maxsorriso.model.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PacienteRepository extends JpaRepository <Paciente, Integer>{

}
