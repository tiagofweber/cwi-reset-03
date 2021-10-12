package br.com.cwi.reset.tiagofweber;

public class AnoInicioAtividadeInvalidoException extends Exception {
    public AnoInicioAtividadeInvalidoException() {
        super("Ano de início de atividade inválido para o ator cadastrado.");
    }
}
