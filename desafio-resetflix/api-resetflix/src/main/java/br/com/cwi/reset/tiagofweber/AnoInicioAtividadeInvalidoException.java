package br.com.cwi.reset.tiagofweber;

public class AnoInicioAtividadeInvalidoException extends Exception {
    public AnoInicioAtividadeInvalidoException(String pessoa) {
        super(String.format("Ano de início de atividade inválido para o %s cadastrado.", pessoa));
    }
}
