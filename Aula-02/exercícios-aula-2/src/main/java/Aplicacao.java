import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {
    public static void main(String args[]) {

        Diretor diretor1 = new Diretor("Andrew Niccol", LocalDate.of(1940, 2, 10), Genero.MASCULINO, 11);
        Diretor diretor2 = new Diretor("Francis Laurence", LocalDate.of(1977, 5, 27), Genero.MASCULINO, 15);

        Filme filme1 = new Filme(
                "O preço do amanhã.",
                "Acusado de um assassinato, um homem deve...",
                202,
                2011,
                4,
                 diretor1);
        Filme filme2 = new Filme(
                "Eu sou a Lenda",
                "Robert Neville é um brilhante cientista...",
                190,
                2007,
                5,
                diretor2
        );
        Filme filme3 = new Filme(
                "Old Guard",
                "Quatro guerreiros com o dom da imortalidade...",
                125,
                2020,
                4,
                diretor1
        );
        Filme filme4 = new Filme(
                "Harry Potter e a Ordem da Fênix",
                "A ordem da fênix foi uma organização fundada por Alvo Dumbledore...",
                170,
                2007,
                5,
                diretor2
        );

        List<Filme> filmes = new ArrayList<>();

        filmes.add(filme1);
        filmes.add(filme2);
        filmes.add(filme3);
        filmes.add(filme4);

        for (Filme filme: filmes) {
            filme.reproduzirFilme();
        }

//        Ator ator1 = new Ator("Will Smith", LocalDate.of(1974, 9, 15), Genero.MASCULINO, 11);

//        diretor1.apresentar();
//        ator1.apresentar();
    }
}
