public class Aplicacao {
    public static void main(String args[]) {

        Diretor diretor1 = new Diretor("Andrew Niccol", 45, 11, Genero.MASCULINO);
        Diretor diretor2 = new Diretor("Francis Laurence", 39, 15, Genero.MASCULINO);

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

        filme1.reproduzirFilme();
        filme2.reproduzirFilme();

        diretor1.apresentar();
    }
}
