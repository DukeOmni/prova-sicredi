package br.tecnica.sicredi.controller.erro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessageModel {
    private String descricao;

    public ErrorMessageModel(String descricao) {
        this.descricao = descricao;
    }
}
