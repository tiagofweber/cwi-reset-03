public class Ator extends Pessoa {

    private Integer qtdOscarsVencidos;

    public Ator(String nome, Integer idade, Genero genero, Integer qtdOscarsVencidos) {
        super(nome, idade, genero);
        this.qtdOscarsVencidos = qtdOscarsVencidos;
    }

}
