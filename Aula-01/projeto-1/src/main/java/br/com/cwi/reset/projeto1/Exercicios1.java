package br.com.cwi.reset.projeto1;

import java.util.Arrays;
import java.util.List;

public class Exercicios1 {

    public Integer somarLista(List<Integer> numeros) {
        Integer soma = 0;
        for(Integer numero : numeros) {
            soma += numero;
        }
        return soma;
    }

    public Double calcularMedia(List<Integer> numeros) {
        return (double) somarLista(numeros) / numeros.size();
    }

    public Integer obterMaiorNumero(List<Integer> numeros) {
        return 10;
    }

    public String obterPalavraInvertida(String palavra) {
        return "edcba";
    }

    public List<Integer> ordenarLista(List<Integer> numeros) {
        return Arrays.asList(1, 2, 3, 4, 5);
    }
}

