package br.com.cwi.reset.tiagofweber.request;

import br.com.cwi.reset.tiagofweber.model.TipoAtuacao;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PersonagemRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo id do ator")
    private Integer idAtor;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo id do nome do personagem")
    @NotEmpty(message = "Campo obrigatório não informado. Favor informar o campo id do nome do personagem")
    protected String nomePersonagem;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo id do descrição do personagem")
    @NotEmpty(message = "Campo obrigatório não informado. Favor informar o campo id do descrição do personagem")
    private String descricaoPersonagem;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo id do tipo atuação")
    private TipoAtuacao tipoAtuacao;

    public PersonagemRequest(Integer idAtor, String nomePersonagem, String descricaoPersonagem, TipoAtuacao tipoAtuacao) {
        this.idAtor = idAtor;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.tipoAtuacao = tipoAtuacao;
    }

    public Integer getIdAtor() {
        return idAtor;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public String getDescricaoPersonagem() {
        return descricaoPersonagem;
    }

    public TipoAtuacao getTipoAtuacao() {
        return tipoAtuacao;
    }
}
