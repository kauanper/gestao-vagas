package br.com.kauan.demo.modules.candidato.Controllers;

import br.com.kauan.demo.modules.candidato.CandidatoEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidato")
public class ControllerCandidato {

    @PostMapping("/")
    public void create(@Valid @RequestBody CandidatoEntity candidato) {
        System.out.println("candidato = " + candidato.getNome());
    }
}
