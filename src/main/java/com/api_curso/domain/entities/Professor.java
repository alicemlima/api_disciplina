package com.api_curso.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Professor extends Pessoa {

    private String area;

    @OneToMany(mappedBy="professor")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Disciplina> disciplinas = new HashSet<>();
}
