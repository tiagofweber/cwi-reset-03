import java.time.LocalDate;

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

        // filme1.reproduzirFilme();
         filme2.reproduzirFilme();

        Ator ator1 = new Ator("Will Smith", LocalDate.of(1974, 9, 15), Genero.MASCULINO, 11);

//        diretor1.apresentar();
//        ator1.apresentar();
    }
}
