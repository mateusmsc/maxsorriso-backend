package io.github.mateusmsc.maxsorriso.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "doutor")
@Data
public class Doutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "telefone")
    private String telefone;

    @Column (name = "data_nascimento")
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data_nascimento;

    @NotNull
    @Column(name = "uf")
    private String uf;

    @NotNull
    @Column(name = "crm")
    private String crm;

}
