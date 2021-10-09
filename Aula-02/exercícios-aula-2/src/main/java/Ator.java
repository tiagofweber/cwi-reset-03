public class Ator {

    private String nome;
    private Integer idade;
    private Integer qtdOscarsVencidos;
    private Genero genero;

    public Ator(String nome, Integer idade, Integer qtdOscarsVencidos, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.qtdOscarsVencidos = qtdOscarsVencidos;
        this.genero = genero;
    }

    public void apresentar() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Gênero: " + genero);
    }

}
