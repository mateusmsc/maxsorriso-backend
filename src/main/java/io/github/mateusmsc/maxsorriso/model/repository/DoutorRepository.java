package io.github.mateusmsc.maxsorriso.model.repository;

import io.github.mateusmsc.maxsorriso.model.entity.Doutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoutorRepository extends JpaRepository <Doutor, Integer> {
}
