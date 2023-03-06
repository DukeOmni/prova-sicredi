package br.tecnica.sicredi.controller;

import br.tecnica.sicredi.model.Associado;
import br.tecnica.sicredi.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/associado")
public class AssociadoController {
    @Autowired
    private AssociadoService associadoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Associado> listaAssociado(){
        return associadoService.listaAssociado();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Associado listarAssociadoPorId(@PathVariable final Long id){
        return associadoService.listaAssociadoPorId(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Associado cadastrarAssociado(@RequestBody final Associado associado){
        //TODO bonus
        return associadoService.criarAssociado(associado);
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Associado alterarAssociado(@PathVariable Long id,@RequestBody final Associado associado){
        return associadoService.alterarAssociado(id,associado);
    }
}
