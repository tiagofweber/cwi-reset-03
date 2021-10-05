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
        Integer maiorNumero = 0;
        for (Integer numero : numeros) {
            if (numero > maiorNumero) {
                maiorNumero = numero;
            }
        }
        return maiorNumero;
    }

    public String obterPalavraInvertida(String palavra) {
        String palavraInvertida = "";

        for (int i = palavra.length() - 1; i >= 0; i--) {
            palavraInvertida += palavra.charAt(i);
        }
        return palavraInvertida;
    }

    public List<Integer> ordenarLista(List<Integer> numeros) {
        Integer[] ints = numeros.toArray(new Integer[numeros.size()]);
        Integer aux;
        for (int i = 0; i < numeros.size() - 1; i++) {
            for (int j = i + 1; j < numeros.size(); j++) {
                if (ints[j] < ints[i]) {
                    aux = ints[j];
                    ints[j] = ints[i];
                    ints[i] = aux;
                }
            }
        }
        return Arrays.asList(ints);
    }
}

