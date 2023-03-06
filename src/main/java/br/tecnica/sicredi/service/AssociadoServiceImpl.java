package br.tecnica.sicredi.service;

import br.tecnica.sicredi.model.Associado;
import br.tecnica.sicredi.model.Pauta;
import br.tecnica.sicredi.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociadoServiceImpl implements AssociadoService{
    @Autowired
    private AssociadoRepository associadoRepository;

    @Override
    public List<Associado> listaAssociado() {
        return this.associadoRepository.findAll();
    }
    @Override
    public Associado criarAssociado(final Associado pauta) {
        return this.associadoRepository.saveAndFlush(pauta);
    }

    @Override
    public Associado alterarAssociado(final Associado associado) {
        return this.associadoRepository.saveAndFlush(associado);
    }

    @Override
    public Associado listaAssociadoPorId(final long id) {
        return this.associadoRepository.findById(id).orElse(null);
    }
}
