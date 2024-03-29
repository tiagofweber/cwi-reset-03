public class Filme {

    private String nome;
    private String descricao;
    private Integer duracao;
    private Integer anoDeLancamento;
    private Integer avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, Integer duracao, Integer anoDeLancamento, Integer avaliacao, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoDeLancamento = anoDeLancamento;
        try {
            this.setAvaliacao(avaliacao);
        } catch (AvaliacaoForaDoPadraoException e) {
            System.out.println(e.getMessage());
        }

        this.diretor = diretor;
    }

    public void reproduzirFilme() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Duração: " + this.duracao);
        System.out.println("Diretor:" + this.diretor.getNome());
    }

    public void setAvaliacao(Integer avaliacao) throws AvaliacaoForaDoPadraoException {
        if (avaliacao < 1 || avaliacao > 5) {
            throw new AvaliacaoForaDoPadraoException();
        }
        this.avaliacao = avaliacao;
    }
}
