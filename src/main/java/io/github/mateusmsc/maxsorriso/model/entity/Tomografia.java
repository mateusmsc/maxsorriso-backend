package io.github.mateusmsc.maxsorriso.model.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Blob;

@Entity
@Table(name = "tomografia")
@Data
public class Tomografia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "cod_projeto")
    private String cod_projeto;

    @NotNull
    @Column(name = "espessura_tc")
    private Integer espessura_tc;

    @Column(name = "dicom")
    private Blob dicom;

    @NotNull
    @OneToOne
    @JoinColumn ( name = "id_paciente")
    private Paciente paciente;
}
