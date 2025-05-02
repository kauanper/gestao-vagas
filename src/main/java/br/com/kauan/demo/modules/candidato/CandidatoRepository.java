package br.com.kauan.demo.modules.candidato;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CandidatoRepository extends JpaRepository<CandidatoEntity, UUID> {

}