package br.com.kauan.demo.modules.candidato.Controllers;

import br.com.kauan.demo.modules.candidato.CandidatoEntity;
import br.com.kauan.demo.modules.candidato.useCases.CreateCandidadeUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidato")
public class ControllerCandidato {

    @Autowired
    private CreateCandidadeUseCase createCandidadeUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidatoEntity candidato) {
        try{
            var result = this.createCandidadeUseCase.execute(candidato);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
