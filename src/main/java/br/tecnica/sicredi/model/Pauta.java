package br.tecnica.sicredi.model;

import jakarta.persistence.*;

import lombok.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="pauta")
public class Pauta extends Entidade{

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "dataInicio")
    private Date dataInicio;

    @Column(name = "dataFim")
    private Date dataFim;

    @OneToMany(mappedBy="id")
    private Set<Associado> aFavor;

    @OneToMany(mappedBy="id")
    private Set<Associado> contra;
}
