package br.com.kauan.demo.modules.candidato;

import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data //getter e setter para todos os meus atributos
public class CandidatoEntity {
    private UUID id;
    private String nome;
    private String username;
    @Email(message = "O campo deve conter um e-mail valído") //anotações em cima dos atributos reference apenas a eles
    private String email;

    @Length(min = 8, max = 15, message = "A senha deve conter de 8 a 15 caracteres")
    private String senha;
    private String descricao;
    private String curriculo;
}
