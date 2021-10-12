package br.com.cwi.reset.tiagofweber;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {
        FakeDatabase fakeDatabase = new FakeDatabase();

        AtorService atorService = new AtorService(fakeDatabase);

        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

/*        String nome2 = "Chyler Leigh Potts";
        LocalDate dataNascimento2 = LocalDate.of(1982, Month.APRIL, 10);
        StatusCarreira statusCarreira2 = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade2 = 1997;
        AtorRequest atorRequest2 = new AtorRequest(nome2, dataNascimento2, statusCarreira2, anoInicioAtividade2);*/

        try {
            atorService.criarAtor(atorRequest);
        } catch (CampoObrigatorioNaoInformadoException | NomeIncompletoException | DataNascimentoInvalidaException e) {
            System.out.println(e.getMessage());
        }

//        atorService.criarAtor(atorRequest2);

        List<Ator> atores = fakeDatabase.recuperaAtores();

//        System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
//        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());

        System.out.println("Quantidade de atores cadastrados: " + atores.size());

        for (int i = 0; i < atores.size(); i++) {
            System.out.println(atores.get(i).toString());
        }
    }
}
