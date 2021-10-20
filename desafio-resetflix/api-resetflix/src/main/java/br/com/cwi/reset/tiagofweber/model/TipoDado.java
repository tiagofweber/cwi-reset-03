package br.com.cwi.reset.tiagofweber.model;

public enum TipoDado {
    ID("id"),
    NOME("nome"),
    ANO_LANCAMENTO("ano de lançamento"),
    CAPA_FILME("capa do filme"),
    GENERO("gênero"),
    ID_DIRETOR("id diretor"),
    ID_ESTUDIO("id estúdio"),
    RESUMO("resumo"),
    PERSONAGENS("personagens"),
    DESCRICAO("descrição");

    private String descricao;

    TipoDado(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
