package br.com.cwi.reset.tiagofweber;

public class NomeIncompletoException extends Exception {

    public NomeIncompletoException() {
        super("Deve ser informado no mínimo nome e sobrenome para o ator.");
    }
}
