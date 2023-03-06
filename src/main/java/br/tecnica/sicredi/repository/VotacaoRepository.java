package br.tecnica.sicredi.repository;

import br.tecnica.sicredi.model.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotacaoRepository extends JpaRepository<Votacao,Long> {
}
