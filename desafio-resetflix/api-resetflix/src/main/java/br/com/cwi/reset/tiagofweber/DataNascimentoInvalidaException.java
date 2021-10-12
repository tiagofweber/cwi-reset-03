package br.com.cwi.reset.tiagofweber;

public class DataNascimentoInvalidaException extends Exception {

    public DataNascimentoInvalidaException(String pessoa) {
        super(String.format("Não é possível cadastrar %s não nascidos.", pessoa));
    }
}
