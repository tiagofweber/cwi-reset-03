public class Diretor  extends Pessoa {

    private Integer qtdFilmesDirigidos;

    public Diretor(String nome, Integer idade, Genero genero, Integer qtdFilmesDirigidos) {
        super(nome, idade, genero);
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
    }

    public Integer getQtdFilmesDirigidos() {
        return qtdFilmesDirigidos;
    }
}
