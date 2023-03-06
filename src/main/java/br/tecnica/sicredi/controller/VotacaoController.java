package br.tecnica.sicredi.controller;

import br.tecnica.sicredi.model.Votacao;
import br.tecnica.sicredi.service.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votacao")
public class VotacaoController {
    @Autowired
    private VotacaoService votacaoService;

    @PostMapping
    private Votacao criarVotacao(@RequestBody final Votacao votacao){
        return votacaoService.criarVotacao(votacao);
    }
    @PutMapping
    private Votacao atualizarVotacao(@RequestBody final Votacao votacao){
        return votacaoService.atualizaVotacao(votacao);
    }
}
