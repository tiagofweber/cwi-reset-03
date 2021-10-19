package br.com.cwi.reset.tiagofweber.exception;

public class DataNascimentoInvalidaException extends Exception {
    public DataNascimentoInvalidaException(String tipo) {
        super(String.format("Não é possível cadastrar %s não nascindos", tipo));
    }
}
