package br.tecnica.sicredi.controller.erro;

import br.tecnica.sicredi.excecao.VotacaoEncerradaException;
import br.tecnica.sicredi.excecao.VotacaoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroControler {
    @ExceptionHandler(value = VotacaoEncerradaException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessageModel votacaoEncerradaException(VotacaoEncerradaException ex) {
        return new ErrorMessageModel(ex.getMessage());
    }

    @ExceptionHandler(value = VotacaoNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessageModel estoqueNotFoundException(VotacaoNotFoundException ex) {
        return new ErrorMessageModel(ex.getMessage());
    }

    @ExceptionHandler(value = Throwable.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessageModel internalServerErrorException(Throwable t) {
        return new ErrorMessageModel(t.getMessage());
    }
}
