package br.dev.pauloroberto.algafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EntidadeEmUsoException extends NegocioException {
    public EntidadeEmUsoException(String mensagem) {
        super(mensagem);
    }
}
