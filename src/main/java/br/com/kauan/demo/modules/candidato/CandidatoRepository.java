package br.com.kauan.demo.modules.candidato;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
                                                           //Entidade       //tipo de Id dela
public interface CandidatoRepository extends JpaRepository<CandidatoEntity, UUID> {

    /*
    * no Spring Data Jpa, conseguimos criar alguns metedos de forma automatizada utilizando
    * algumas palavras como atalho.
    * Ao escrever findBy o spring irá fazer um select (Or, And tbm são palavras automatizadas)
    */
    CandidatoEntity findByUsernameOrEmail(String username, String email);
}