package br.com.cwi.reset.tiagofweber;

public class AtorNaoCadastradoException extends Exception {
    public AtorNaoCadastradoException(Integer id) {
        super("Nenhum ator encontrado com o parâmetro id=" + id + ", favor verifique os parâmetros informados.");
    }
}
