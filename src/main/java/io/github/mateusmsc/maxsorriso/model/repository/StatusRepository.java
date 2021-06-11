package io.github.mateusmsc.maxsorriso.model.repository;

import io.github.mateusmsc.maxsorriso.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
}
