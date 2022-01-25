package com.api_curso.domain.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@MappedSuperclass
public class Pessoa extends BaseEntity {

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Column(name = "data_de_nascimento")
    private LocalDate dataDeNascimento;
}
