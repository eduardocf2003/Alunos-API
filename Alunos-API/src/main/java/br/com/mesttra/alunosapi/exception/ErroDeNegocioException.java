package br.com.mesttra.alunosapi.exception;

public class ErroDeNegocioException extends Exception {
    private static final long serialVersionUID = 118470146055125885L;

    public ErroDeNegocioException(String message) {
        super(message);
    }
}
