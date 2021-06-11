package io.github.mateusmsc.maxsorriso.model.repository;

import io.github.mateusmsc.maxsorriso.model.entity.Caso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CasoRepository extends JpaRepository <Caso, Integer>{
}
