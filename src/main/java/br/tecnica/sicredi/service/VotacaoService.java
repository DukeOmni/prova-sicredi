package br.tecnica.sicredi.service;

import br.tecnica.sicredi.model.Votacao;

import java.util.List;

public interface VotacaoService {
    Votacao criarVotacao(final Votacao votacao);
    List<Votacao> listarVotacao();
    Votacao atualizaVotacao(final Votacao votacao);
    Votacao buscaPorId(final long id);

}
