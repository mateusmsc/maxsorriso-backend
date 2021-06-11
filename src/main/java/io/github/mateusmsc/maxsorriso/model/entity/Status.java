package io.github.mateusmsc.maxsorriso.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "status_caso")
@Data
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descricao")
    private String descricao;

}
