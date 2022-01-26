package com.api_curso.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Disciplina extends BaseEntity {

    private String nome;

    @Column(columnDefinition="TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToMany
    @JoinTable(name = "disciplina_aluno",
            joinColumns = @JoinColumn(name = "disciplina_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    private Set<Aluno> alunos = new HashSet<>();

    public Boolean addAluno(Aluno aluno){
        return this.alunos.add(aluno);
    }

    public Boolean removeAluno(Aluno aluno) {
        return this.alunos.remove(aluno);
    }


}
