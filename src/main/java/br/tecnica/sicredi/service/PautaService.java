package br.tecnica.sicredi.service;

import br.tecnica.sicredi.model.Pauta;
import br.tecnica.sicredi.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PautaService {
    Pauta criarPauta(final Pauta pauta);
    Pauta alterarPauta(final Long id,final Pauta pauta);
    List<Pauta> listaPauta();
    Pauta listaPautaPorId(final Long id);

}
