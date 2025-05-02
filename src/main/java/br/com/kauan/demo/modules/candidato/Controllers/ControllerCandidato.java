package br.com.kauan.demo.modules.candidato.Controllers;

import br.com.kauan.demo.modules.candidato.CandidatoEntity;
import br.com.kauan.demo.modules.candidato.CandidatoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidato")
public class ControllerCandidato {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @PostMapping("/")
    public CandidatoEntity create(@Valid @RequestBody CandidatoEntity candidato) {
        return this.candidatoRepository.save(candidato);
    }
}
