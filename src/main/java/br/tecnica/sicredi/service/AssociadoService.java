package br.tecnica.sicredi.service;

import br.tecnica.sicredi.model.Associado;
import br.tecnica.sicredi.model.Pauta;

import java.util.List;

public interface AssociadoService {
    List<Associado> listaAssociado();
    Associado criarAssociado(final Associado associado);
    Associado alterarAssociado(final Long id,final Associado associado);
    Associado listaAssociadoPorId(final Long id);

}
