package br.com.cwi.reset.tiagofweber;

public class NomeInvalidoException extends Exception {
    public NomeInvalidoException(String nome) {
        super("Já existe um ator cadastrado para o nome " + nome);
    }
}
