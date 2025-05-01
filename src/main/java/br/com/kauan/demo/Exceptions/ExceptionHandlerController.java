package br.com.kauan.demo.Exceptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/*
 * Essa classe cuida dos erros da aplicação.
 * Toda vez que der erro de validação em algum campo, ela entra em ação e monta uma resposta bonitinha para o usuário.
 */
@ControllerAdvice // Diz ao Spring que essa classe vai tratar erros de forma global (para toda a aplicação)
public class ExceptionHandlerController {

    private final MessageSource messageSource;

    // Aqui a gente recebe o MessageSource que serve para pegar as mensagens de erro de forma traduzida (ex: português, inglês etc.)
    public ExceptionHandlerController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /*
     * Esse metodo será chamado automaticamente quando algum dado enviado estiver errado
     * (por exemplo: campo obrigatório que veio vazio, email mal formatado, etc.)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessageDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        List<ErrorMessageDTO> dto = new ArrayList<>(); // Aqui vamos guardar todos os erros encontrados

        // Para cada erro de validação que aconteceu...
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            // Pegamos a mensagem de erro traduzida (por exemplo: "O campo nome é obrigatório")
            String errorMessage = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            // Criamos um objeto com a mensagem e o nome do campo que deu erro
            dto.add(new ErrorMessageDTO(errorMessage, error.getField()));
        });

        // Retornamos todos os erros com o status 400 (BAD REQUEST) em formato de JSON
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
