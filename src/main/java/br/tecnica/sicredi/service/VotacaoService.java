package br.tecnica.sicredi.service;

import br.tecnica.sicredi.dto.VotoDTO;
import br.tecnica.sicredi.excecao.AssociadoNotFoundException;
import br.tecnica.sicredi.excecao.VotacaoEncerradaException;
import br.tecnica.sicredi.excecao.VotacaoNotFoundException;
import br.tecnica.sicredi.model.Votacao;

import java.util.List;

public interface VotacaoService {
    Votacao criarVotacao(final Votacao votacao);
    List<Votacao> listaVotacao();
    Votacao atualizaVotacao(final Long idVotacao, final VotoDTO votacao) throws VotacaoEncerradaException, VotacaoNotFoundException, AssociadoNotFoundException;
    Votacao buscaPorId(final Long id);

}
