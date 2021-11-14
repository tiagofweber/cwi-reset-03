package br.com.cwi.reset.projeto1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculadoraServiceTest {

    @Mock
    private LeitorTeclado leitorTeclado;

    @InjectMocks
    private CalculadoraService calculadora;

    @Test
    public void quandoMultiplicarDoisNumerosInteirosPositivosDeveRetornarSuaMultiplicacao() {
        // Arrange
        Double numeroUm = 2.0;
        Double numeroDois = 3.0;
        Double resultadoEsperado = 6.0;

        // Action
        Double resultado = calculadora.multiplicar(numeroUm, numeroDois);

        // Assert
        Assertions.assertEquals(resultadoEsperado, resultado, "O valor esperado deveria ser " + resultadoEsperado + " obtemos o resultado " + resultado);
    }

    @Test
    public void quandoMultiplicarDoisNumerosNegativosDeveRetornarAMultiplicacaoPositiva() {
        // Arrange
        Double numeroUm = -8.0;
        Double numeroDois = -8.0;
        Double resultadoEsperado = 64.0;

        // Action
        Double resultado = calculadora.multiplicar(numeroUm, numeroDois);

        // Assert
        Assertions.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void quandoMultiplicarUmNumeroNegativoPorUmNumeroPositivoDeveRetornarAMultiplicacaoNegativa() {
        // Arrange
        Double numeroUm = -6.0;
        Double numeroDois = 6.0;
        Double resultadoEsperado = -36.0;

        // Action
        Double resultado = calculadora.multiplicar(numeroUm, numeroDois);

        // Assert
        Assertions.assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void testeMultiplicarLendoInformacoesDoUsuario() {
        // Arrange
//        Mockito.when(leitorTeclado.lerDouble()).thenReturn(2.0, 4.0);

        Mockito.doReturn(2.0).when(leitorTeclado).lerDouble("Digite o primeiro número: ");
        Mockito.doReturn(4.0).when(leitorTeclado).lerDouble("Digite o segundo número: ");

        Double expected = 8.0;

        // Action
        Double result = calculadora.multiplicarUsandoTeclado();

        // Assert
        Assertions.assertEquals(expected, result);
        Mockito.verify(leitorTeclado, Mockito.times(1)).lerDouble("Digite o primeiro número: ");
        Mockito.verify(leitorTeclado, Mockito.times(1)).lerDouble("Digite o segundo número: ");
    }
}
