public enum Genero {

    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    NAO_BINARIO("Não Binário");

    private String descricao;
    
    Genero(String descricao) {
        this.descricao = descricao;
    }

}
