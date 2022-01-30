package com.api_curso.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Aluno extends Pessoa {

    @Column(name = "nome_responsavel")
    private String nomeResponsavel;

    @ManyToMany(mappedBy = "alunos")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Disciplina> disciplinas = new HashSet<>();
}
