package br.com.cwi.reset.tiagofweber.request;

import br.com.cwi.reset.tiagofweber.model.StatusCarreira;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AtorRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo nome")
    @NotEmpty(message = "Campo obrigatório não informado. Favor informar o campo nome")
    private String nome;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo data de nascimento")
    private LocalDate dataNascimento;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo status carreira")
    private StatusCarreira statusCarreira;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo ano de início de atividade")
    private Integer anoInicioAtividade;

    public AtorRequest(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

    public void setStatusCarreira(StatusCarreira statusCarreira) {
        this.statusCarreira = statusCarreira;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }

    public void setAnoInicioAtividade(Integer anoInicioAtividade) {
        this.anoInicioAtividade = anoInicioAtividade;
    }
}
