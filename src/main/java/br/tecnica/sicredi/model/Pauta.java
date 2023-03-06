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


}
