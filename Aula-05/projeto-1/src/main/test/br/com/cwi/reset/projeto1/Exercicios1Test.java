package br.com.cwi.reset.projeto1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicios1Test {

    private Exercicios1 exercicios1 = new Exercicios1();

    @Test
    public void testSomarListaCom5NumerosInteirosPositivos() {
        // Arrange
        List<Integer> numeros = Arrays.asList(5, 14, 21, 7, 9);
        Integer expected = 56;

        // Action
        Integer result = exercicios1.somarLista(numeros);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSomarListaCom4InteirosE1Negativo() {
        // Arrange
        List<Integer> numeros = Arrays.asList(5, 14, 21, 7, -17);
        Integer expected = 30;

        // Action
        Integer result = exercicios1.somarLista(numeros);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSomarListaCom3NumerosNegativos() {
        // Arrange
        List<Integer> numeros = Arrays.asList(-10, -7, -18);
        Integer expected = -35;

        // Action
        Integer result = exercicios1.somarLista(numeros);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSomarListaComTodosElementosComoZero() {
        // Arrange
        List<Integer> numeros = Arrays.asList(0, 0, 0, 0);
        Integer expected = 0;

        // Action
        Integer result = exercicios1.somarLista(numeros);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSomarListaVazia() {
        // Arrange
        List<Integer> numeros = Arrays.asList();
        Integer expected = 0;

        // Action
        Integer result = exercicios1.somarLista(numeros);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCalcularMediaCom5NumerosInteirosPositivos() {
        // Arrange
        List<Integer> numeros = Arrays.asList(5, 14, 21, 7, 9);
        Double expected = 11.2;

        // Action
        Double result = exercicios1.calcularMedia(numeros);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCalcularMediaCom4InteirosE1Negativo() {
        // Arrange
        List<Integer> numeros = Arrays.asList(5, 14, 21, 7, -17);
        Double expected = 6.0;

        // Action
        Double result = exercicios1.calcularMedia(numeros);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCalcularMediaCom3NumerosNegativos() {
        // Arrange
        List<Integer> numeros = Arrays.asList(-10, -7, -18);
        Double expected = -11.666666666666666;

        // Action
        Double result = exercicios1.calcularMedia(numeros);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCalcularMediaComTodosElementosComoZero() {
        // Arrange
        List<Integer> numeros = Arrays.asList(0, 0, 0, 0);
        Double expected = 0.0;

        // Action
        Double result = exercicios1.calcularMedia(numeros);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCalcularMediaListaVazia() {
        // Arrange
        List<Integer> lista = new ArrayList<>();

        // Action
        Throwable exception = Assertions.assertThrows(ArithmeticException.class, () -> exercicios1.calcularMedia(lista));
    }

    @Test
    public void testObterPalavraInvertidaAbacate() {
        // Arrange
        String palavra = "Abacate";
        String expected = "etacabA";

        // Action
        String result = exercicios1.obterPalavraInvertida(palavra);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testObterPalavraInvertidaBanana() {
        // Arrange
        String palavra = "Banana";
        String expected = "ananaB";

        // Action
        String result = exercicios1.obterPalavraInvertida(palavra);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testObterPalavraInvertidaPessego() {
        // Arrange
        String palavra = "Pêssego";
        String expected = "ogessêP";

        // Action
        String result = exercicios1.obterPalavraInvertida(palavra);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testObterPalavraInvertidaMorango() {
        // Arrange
        String palavra = "Morango";
        String expected = "ognaroM";

        // Action
        String result = exercicios1.obterPalavraInvertida(palavra);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testeOrdenarListaComPositivos() {
        // Arrange
        List<Integer> lista = Arrays.asList(5, 4, 3, 2, 1);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        // Action
        List<Integer> result = exercicios1.ordenarLista(lista);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testeOrdenarListaComPositivosENegativos() {
        // Arrange
        List<Integer> lista = Arrays.asList(5, -20, 3, -2, 1);
        List<Integer> expected = Arrays.asList(-20, -2, 1, 3, 5);

        // Action
        List<Integer> result = exercicios1.ordenarLista(lista);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testeOrdenarListaComListaNull() {
        // Action
        Assertions.assertThrows(NullPointerException.class, () -> exercicios1.ordenarLista(null));
    }
}
