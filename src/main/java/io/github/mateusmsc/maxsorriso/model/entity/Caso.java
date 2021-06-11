package io.github.mateusmsc.maxsorriso.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "casos")
@Data
public class Caso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @OneToOne
    @JoinColumn ( name = "id_status")
    private Status status;

    @NotNull
    @OneToOne
    @JoinColumn ( name = "id_tomografia")
    private Tomografia tomografia;

    @Column (name = "data_cirurgia")
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data_cirurgia;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_doutor")
    private Doutor doutor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

}
