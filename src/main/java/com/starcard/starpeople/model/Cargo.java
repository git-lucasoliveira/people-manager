package com.starcard.starpeople.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cargos")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "setor_id", nullable = false)
    private Setor setor;

}
