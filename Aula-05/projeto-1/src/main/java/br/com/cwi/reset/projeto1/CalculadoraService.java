package br.com.cwi.reset.projeto1;

public class CalculadoraService {

    private LeitorTeclado leitorTeclado = new LeitorTeclado();

    public Double multiplicar(Double primeiroNumero, Double segundoNumero) {
        return primeiroNumero * segundoNumero;
    }

    public Double somar(Double primeiroNumero, Double segundoNumero) {
        return primeiroNumero + segundoNumero;
    }

    public Double subtrair(Double primeiroNumero, Double segundoNumero) {
        return primeiroNumero - segundoNumero;
    }

    public Double multiplicarUsandoTeclado() {
        Double numeroUm = leitorTeclado.lerDouble("Digite o primeiro número: ");
        Double numeroDois = leitorTeclado.lerDouble("Digite o segundo número: ");
        return multiplicar(numeroUm, numeroDois);
    }
}
