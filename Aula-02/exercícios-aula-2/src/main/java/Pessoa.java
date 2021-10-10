import java.time.LocalDate;

public class Pessoa {

    private String nome;
    private LocalDate dataDeNascimento;
    private Genero genero;

    public Pessoa(String nome, LocalDate dataDeNascimento, Genero genero) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.genero = genero;
    }

    public void apresentar() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + dataDeNascimento);
        System.out.println("Gênero: " + genero.getDescricao());
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public Genero getGenero() {
        return genero;
    }
}
