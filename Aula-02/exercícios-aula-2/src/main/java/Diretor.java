public class Diretor  extends Pessoa {

    private int qtdFilmesDirigidos;

    public Diretor(String nome, Integer idade, Genero genero, int qtdFilmesDirigidos) {
        super(nome, idade, genero);
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
    }

    public int getQtdFilmesDirigidos() {
        return qtdFilmesDirigidos;
    }
}
