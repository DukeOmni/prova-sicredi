package br.tecnica.sicredi.service;

import br.tecnica.sicredi.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PautaServiceImpl implements PautaService{
    @Autowired
    private PautaRepository pautaRepository;
}