package br.tecnica.sicredi.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="associado")
public class Associado extends Entidade{

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;
}
