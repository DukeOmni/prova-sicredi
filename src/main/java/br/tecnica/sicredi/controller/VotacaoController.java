package br.tecnica.sicredi.controller;

import br.tecnica.sicredi.dto.VotoDTO;
import br.tecnica.sicredi.model.Associado;
import br.tecnica.sicredi.model.Votacao;
import br.tecnica.sicredi.service.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votacao")
public class VotacaoController {
    @Autowired
    private VotacaoService votacaoService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Votacao> listaVotacao(){
        return votacaoService.listaVotacao();
    }
    @PostMapping
    private Votacao criarVotacao(@RequestBody final Votacao votacao){
        return votacaoService.criarVotacao(votacao);
    }
    @PutMapping("{id}")
    private Votacao atualizarVotacao(@PathVariable final Long id, @RequestBody final VotoDTO votacao){
        try {
            return votacaoService.atualizaVotacao(id,votacao);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
