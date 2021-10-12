package br.com.cwi.reset.tiagofweber;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {
        FakeDatabase fakeDatabase = new FakeDatabase();

        AtorService atorService = new AtorService(fakeDatabase);

        // Cadastro de Atores para testes
        AtorRequest atorRequest = new AtorRequest(
                "Will Smith",
                LocalDate.of(1968, Month.SEPTEMBER, 25),
                StatusCarreira.EM_ATIVIDADE,
                1986
        );

        AtorRequest atorRequest2 = new AtorRequest(
            "Chyler Leigh Potts",
            LocalDate.of(1982, Month.APRIL, 10),
            StatusCarreira.EM_ATIVIDADE,
            1997
         );

        AtorRequest atorRequest3 = new AtorRequest(
                "Emma Watson",
                LocalDate.of(1990, Month.APRIL, 15),
                StatusCarreira.APOSENTADO,
                1999
        );

        try {
            atorService.criarAtor(atorRequest);
        } catch (CampoObrigatorioNaoInformadoException | NomeIncompletoException | DataNascimentoInvalidaException | AnoInicioAtividadeInvalidoException | NomeInvalidoException e) {
            System.out.println(e.getMessage());
        }

        try {
            atorService.criarAtor(atorRequest2);
        } catch (CampoObrigatorioNaoInformadoException | NomeIncompletoException | DataNascimentoInvalidaException | AnoInicioAtividadeInvalidoException | NomeInvalidoException e) {
            System.out.println(e.getMessage());
        }

        try {
            atorService.criarAtor(atorRequest3);
        } catch (CampoObrigatorioNaoInformadoException | NomeIncompletoException | DataNascimentoInvalidaException | AnoInicioAtividadeInvalidoException | NomeInvalidoException e) {
            System.out.println(e.getMessage());
        }

        List<Ator> atores = atorService.consultarAtores();

/*
        System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());
*/

        System.out.println("Quantidade de atores cadastrados: " + atores.size());

        for (Ator ator: atores) {
            System.out.println(ator.toString());
        }

        // Teste de consultar ator
        try {
            System.out.println(atorService.consultarAtor(null));
        } catch (CampoObrigatorioNaoInformadoException e) {
            System.out.println(e.getMessage());
        }

    }
}
