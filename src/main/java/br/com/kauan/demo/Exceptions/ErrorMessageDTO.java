package br.com.kauan.demo.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //adiciona os Getters e os Setters
@AllArgsConstructor //cria um construtor
public class ErrorMessageDTO {
    private String message;
    private String field;
}