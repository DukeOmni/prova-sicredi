package br.tecnica.sicredi.service;

import br.tecnica.sicredi.excecao.VotacaoEncerradaException;
import br.tecnica.sicredi.excecao.VotacaoNotFoundException;
import br.tecnica.sicredi.model.Votacao;
import br.tecnica.sicredi.repository.VotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class VotacaoServiceImpl implements VotacaoService{
    @Autowired
    private VotacaoRepository votacaoRepository;

    static final long DEFAULT_EM_MILIS = 60000;

    @Override
    public Votacao criarVotacao(Votacao votacao) {
        //se não tiver data informada, deve estar aberta apenas por 1 minuto
        if(Objects.isNull(votacao.getDataFim())){
            votacao.setDataFim(new Date(votacao.getDataInicio().getTime()+DEFAULT_EM_MILIS));
            return this.votacaoRepository.saveAndFlush(votacao);
        }
        return this.votacaoRepository.saveAndFlush(votacao);
    }

    @Override
    public List<Votacao> listaVotacao() {
        return this.votacaoRepository.findAll();
    }

    @Override
    public Votacao atualizaVotacao(final Long id, final Votacao remove) throws VotacaoEncerradaException, VotacaoNotFoundException {
        final Votacao votacao=this.votacaoRepository.findById(id).orElseThrow(this::votacaoNotFoundException);
        //verifica se votação ainda está aberta
        final int estadoVotacao=new Date().compareTo(votacao.getDataFim());
        if(estadoVotacao>=0){
            throw new VotacaoEncerradaException("A votação está fechada");
        }
        return this.votacaoRepository.saveAndFlush(votacao);
    }

    @Override
    public Votacao buscaPorId(final Long id) {
        return this.votacaoRepository.findById(id).orElse(null);
    }

    protected String mensagemNotFound(){
        return "Votação não encontrada";
    };

    protected VotacaoNotFoundException votacaoNotFoundException() {
        return new VotacaoNotFoundException(mensagemNotFound());
    }
}
