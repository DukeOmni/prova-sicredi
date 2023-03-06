package br.tecnica.sicredi.service;

import br.tecnica.sicredi.dto.ApiExternaDTO;
import br.tecnica.sicredi.model.Associado;
import br.tecnica.sicredi.model.AssociadoStatus;
import br.tecnica.sicredi.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
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
    public Associado alterarAssociado(final Long id,final Associado associado) {
        return this.associadoRepository.saveAndFlush(associado);
    }

    @Override
    public Associado listaAssociadoPorId(final Long id) {
        return this.associadoRepository.findById(id).orElse(null);
    }

    //Bonus de verificar cpf Associado
    @Override
    public ResponseEntity<AssociadoStatus> verificaVoto(final String cpf) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https://www.4devs.com.br/ferramentas_online.php");

        ApiExternaDTO apiExternaDTO = new ApiExternaDTO("validar_cpf", cpf);
        ResponseEntity<String> apiExternaResult = restTemplate.postForEntity(uri, apiExternaDTO, String.class);

        return new ResponseEntity<>(AssociadoStatus.geraStatusAleatorio(), apiExternaResult.getStatusCode());

    }
}
