package br.tecnica.sicredi.service;

import br.tecnica.sicredi.dto.ApiExternaDTO;
import br.tecnica.sicredi.model.Associado;
import br.tecnica.sicredi.model.AssociadoStatus;
import br.tecnica.sicredi.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
        String url = "https://www.4devs.com.br/ferramentas_online.php";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("acao", "validar_cpf");
        map.add("txt_cpf", cpf);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        String response = restTemplate.postForObject( url, request , String.class );

        return new ResponseEntity<>(AssociadoStatus.geraStatusAleatorio(), response.contains("Verdadeiro")? HttpStatus.OK:HttpStatus.NOT_FOUND);

    }
}
