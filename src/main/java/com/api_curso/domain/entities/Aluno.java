package com.api_curso.domain.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Aluno extends Pessoa {

    @Column(name = "nome_responsavel")
    private String nomeResponsavel;

    @ManyToMany
    private Set<Disciplina> disciplinas = new HashSet<>();
}
