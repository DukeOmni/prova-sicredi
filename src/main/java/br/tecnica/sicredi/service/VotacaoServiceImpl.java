package br.tecnica.sicredi.service;

import br.tecnica.sicredi.model.Votacao;
import br.tecnica.sicredi.repository.VotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotacaoServiceImpl implements VotacaoService{
    @Autowired
    private VotacaoRepository votacaoRepository;

    @Override
    public Votacao criarVotacao(Votacao votacao) {
        return this.votacaoRepository.saveAndFlush(votacao);
    }

    @Override
    public List<Votacao> listaVotacao() {
        return this.votacaoRepository.findAll();
    }

    @Override
    public Votacao atualizaVotacao(final Long id,final Votacao votacao) {
        return this.votacaoRepository.saveAndFlush(votacao);
    }

    @Override
    public Votacao buscaPorId(final Long id) {
        return this.votacaoRepository.findById(id).orElse(null);
    }
}
