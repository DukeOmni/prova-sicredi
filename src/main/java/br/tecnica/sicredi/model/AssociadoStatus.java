package br.tecnica.sicredi.model;

import java.util.Random;

public enum AssociadoStatus {
    ABLE_TO_VOTE,
    UNABLE_TO_VOTE;

    //Regra do estado aleatório do associado
    public static AssociadoStatus geraStatusAleatorio() {
        AssociadoStatus[] values = AssociadoStatus.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }
}
