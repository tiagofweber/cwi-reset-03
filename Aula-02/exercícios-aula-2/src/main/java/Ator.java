import java.time.LocalDate;

public class Ator extends Pessoa {

    private Integer qtdOscarsVencidos;

    public Ator(String nome, LocalDate dataDeNascimento, Genero genero, Integer qtdOscarsVencidos) {
        super(nome, dataDeNascimento, genero);
        this.qtdOscarsVencidos = qtdOscarsVencidos;
    }

}
