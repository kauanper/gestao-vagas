package br.com.kauan.demo.modules.candidato.useCases;

import br.com.kauan.demo.Exceptions.UsurnameExiste;
import br.com.kauan.demo.modules.candidato.CandidatoEntity;
import br.com.kauan.demo.modules.candidato.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidadeUseCase {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public CandidatoEntity execute(CandidatoEntity candidatoEntity) {
        this.candidatoRepository
                .findByUsernameOrEmail(candidatoEntity.getUsername(), candidatoEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UsurnameExiste();
                });
        return this.candidatoRepository.save(candidatoEntity);
    }
}
