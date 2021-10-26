package br.com.cwi.reset.tiagofweber.request;

import br.com.cwi.reset.tiagofweber.model.Genero;
import br.com.cwi.reset.tiagofweber.model.PersonagemAtor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class FilmeRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo nome")
    @NotEmpty(message = "Campo obrigatório não informado. Favor informar o campo nome")
    private String nome;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo ano de lançamento")
    private Integer anoLancamento;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo capa do filme")
    @NotEmpty(message = "Campo obrigatório não informado. Favor informar o campo capa do filme")
    private String capaFilme;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo gêneros")
    private List<Genero> generos;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo id do diretor")
    private Integer idDiretor;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo id do estúdio")
    private Integer idEstudio;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo resumo")
    @NotEmpty(message = "Campo obrigatório não informado. Favor informar o campo resumo")
    private String resumo;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo personagens")
    @NotEmpty(message = "Deve ser informado pelo menos um gênero para o cadastro do filme")
    private List<PersonagemRequest> personagens;

    public FilmeRequest(String nome, Integer anoLancamento, String capaFilme, List<Genero> generos, Integer idDiretor, Integer idEstudio, String resumo, List<PersonagemRequest> personagens) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.generos = generos;
        this.idDiretor = idDiretor;
        this.idEstudio = idEstudio;
        this.resumo = resumo;
        this.personagens = personagens;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public String getCapaFilme() {
        return capaFilme;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public Integer getIdDiretor() {
        return idDiretor;
    }

    public Integer getIdEstudio() {
        return idEstudio;
    }

    public String getResumo() {
        return resumo;
    }

    public List<PersonagemRequest> getPersonagens() {
        return personagens;
    }
}
