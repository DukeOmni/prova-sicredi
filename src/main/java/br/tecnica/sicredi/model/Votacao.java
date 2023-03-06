package br.tecnica.sicredi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="votacao")
public class Votacao extends Entidade{
    
    @OneToOne
    @JoinColumn
    private Pauta pauta;

    @OneToMany
    @Column(name = "contra")
    private List<Associado> contra;

    @OneToMany
    @Column(name = "favor")
    private List<Associado> favor;

    @Column(name = "dataInicio")
    private Date dataInicio;

    @Column(name = "dataFim")
    private Date dataFim;
}
