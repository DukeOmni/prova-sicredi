package br.tecnica.sicredi.service;

import br.tecnica.sicredi.excecao.VotacaoEncerradaException;
import br.tecnica.sicredi.excecao.VotacaoNotFoundException;
import br.tecnica.sicredi.model.Votacao;

import java.util.List;

public interface VotacaoService {
    Votacao criarVotacao(final Votacao votacao);
    List<Votacao> listaVotacao();
    Votacao atualizaVotacao(final Long id, final Votacao votacao) throws VotacaoEncerradaException, VotacaoNotFoundException;
    Votacao buscaPorId(final Long id);

}
