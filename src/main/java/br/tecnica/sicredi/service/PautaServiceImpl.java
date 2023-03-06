package br.tecnica.sicredi.service;

import br.tecnica.sicredi.model.Pauta;
import br.tecnica.sicredi.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PautaServiceImpl implements PautaService{
    @Autowired
    private PautaRepository pautaRepository;

    @Override
    public Pauta criarPauta(final Pauta pauta) {
        return this.pautaRepository.saveAndFlush(pauta);
    }

    @Override
    public Pauta alterarPauta(Pauta pauta) {
        return this.pautaRepository.saveAndFlush(pauta);
    }

    @Override
    public List<Pauta> listaPauta() {
        return this.pautaRepository.findAll();
    }

    @Override
    public Pauta listaPautaPorId(final long id) {
        return this.pautaRepository.findById(id).orElse(null);
    }
}
