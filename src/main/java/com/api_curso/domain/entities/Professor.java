package com.api_curso.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Professor extends Pessoa {

    private String area;

    @OneToMany(mappedBy="professor")
    private Set<Disciplina> disciplinas = new HashSet<>();
}
