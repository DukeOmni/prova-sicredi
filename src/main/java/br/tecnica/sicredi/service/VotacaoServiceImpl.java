package br.tecnica.sicredi.service;

import br.tecnica.sicredi.dto.VotoDTO;
import br.tecnica.sicredi.excecao.AssociadoNotFoundException;
import br.tecnica.sicredi.excecao.VotacaoEncerradaException;
import br.tecnica.sicredi.excecao.VotacaoNotFoundException;
import br.tecnica.sicredi.model.Associado;
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
    @Autowired
    private AssociadoService associadoService;

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
    public Votacao atualizaVotacao(final Long idVotacao, final VotoDTO voto) throws VotacaoEncerradaException, VotacaoNotFoundException, AssociadoNotFoundException {
        final Votacao votacao=this.votacaoRepository.findById(idVotacao).orElseThrow(this::votacaoNotFoundException);
        final Associado associado=this.associadoService.listaAssociadoPorId(voto.getIdAssociado());
        //verifica se votação ainda está aberta
        final int estadoVotacao=new Date().compareTo(votacao.getDataFim());
        if(estadoVotacao>=0){
            throw new VotacaoEncerradaException("A votação está fechada");
        }else{
            if (voto.getOpiniao().toLowerCase().contains("sim")){
                votacao.getFavor().add(associado);
            }else{
                votacao.getContra().add(associado);
            }
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
