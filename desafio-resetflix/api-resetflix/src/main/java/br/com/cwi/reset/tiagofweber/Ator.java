package br.com.cwi.reset.tiagofweber;

import java.time.LocalDate;

public class Ator extends Pessoa {

    private StatusCarreira statusCarreira;

    public Ator(Integer id, String nome, LocalDate dataNascimento, Integer anoInicioAtividade, StatusCarreira statusCarreira) {
        super(id, nome, dataNascimento, anoInicioAtividade);
        this.statusCarreira = statusCarreira;
    }
}
