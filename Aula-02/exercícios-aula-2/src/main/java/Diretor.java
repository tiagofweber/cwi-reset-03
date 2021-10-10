import java.time.LocalDate;

public class Diretor  extends Pessoa {

    private Integer qtdFilmesDirigidos;

    public Diretor(String nome, LocalDate dataDeNascimento, Genero genero, Integer qtdFilmesDirigidos) {
        super(nome, dataDeNascimento, genero);
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
    }

    public Integer getQtdFilmesDirigidos() {
        return qtdFilmesDirigidos;
    }
}
