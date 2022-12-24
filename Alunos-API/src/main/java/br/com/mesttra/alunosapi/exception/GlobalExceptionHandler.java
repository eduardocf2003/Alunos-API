package br.com.mesttra.alunosapi.exception;

import br.com.mesttra.alunosapi.dto.ErroValidacaoResponseDTO;
import br.com.mesttra.alunosapi.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final int POSICAO_ERR = 0;

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler({ErroDeNegocioException.class})
    public @ResponseBody ResponseDTO handleBusinessErrors(Exception e) {
        return new ResponseDTO(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
        public @ResponseBody List<ErroValidacaoResponseDTO> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        List<ErroValidacaoResponseDTO> resposta = new ArrayList<ErroValidacaoResponseDTO>();

        for (ObjectError err : e.getBindingResult().getAllErrors()) {

            String erroCompleto = err.getCodes()[POSICAO_ERR];
            String erroCampo = erroCompleto.substring(erroCompleto.lastIndexOf('.') + 1, erroCompleto.length());

            resposta.add(new ErroValidacaoResponseDTO(erroCampo, err.getDefaultMessage()));
        }

        return resposta;
    }

}
