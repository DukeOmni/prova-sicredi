package br.tecnica.sicredi.controller;

import br.tecnica.sicredi.model.Pauta;
import br.tecnica.sicredi.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pauta")
public class PautaController {
    @Autowired
    public PautaService pautaService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pauta> listarPautas(){
        return pautaService.listaPauta();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pauta listarPautasPorId(@RequestParam final long id){
        return pautaService.listaPautaPorId(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pauta cadastrarPauta(@RequestBody final Pauta pauta){
        return pautaService.criarPauta(pauta);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Pauta alterarPauta(@RequestBody final Pauta pauta){
        return pautaService.alterarPauta(pauta);
    }
}
