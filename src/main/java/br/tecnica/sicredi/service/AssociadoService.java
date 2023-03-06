package br.tecnica.sicredi.service;

import br.tecnica.sicredi.excecao.AssociadoNotFoundException;
import br.tecnica.sicredi.model.Associado;
import br.tecnica.sicredi.model.AssociadoStatus;
import br.tecnica.sicredi.model.Pauta;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.List;

public interface AssociadoService {
    List<Associado> listaAssociado();
    Associado criarAssociado(final Associado associado);
    Associado alterarAssociado(final Long id,final Associado associado);
    Associado listaAssociadoPorId(final Long id) throws AssociadoNotFoundException;

    //Bonus de verificar cpf Associado
    ResponseEntity<AssociadoStatus> verificaVoto(String cpf) throws URISyntaxException;
}
