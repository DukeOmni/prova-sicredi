package br.tecnica.sicredi.controller;

import br.tecnica.sicredi.model.Associado;
import br.tecnica.sicredi.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/api/associado")
public class AssociadoController {
    @Autowired
    private AssociadoService associadoService;

    @GetMapping
    public List<Associado> listaAssociado(){
        return associadoService.listaAssociado();
    }
}
