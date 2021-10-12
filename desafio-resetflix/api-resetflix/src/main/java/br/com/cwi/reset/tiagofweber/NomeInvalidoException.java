package br.com.cwi.reset.tiagofweber;

public class NomeInvalidoException extends Exception {
    public NomeInvalidoException(String cargo, String nome) {
        super(String.format("Já existe um %s cadastrado para o nome %s", cargo, nome));
    }
}
