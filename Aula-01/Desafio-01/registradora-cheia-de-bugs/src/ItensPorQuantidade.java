public class ItensPorQuantidade {

    static int pao = 3600;
    static int fatiasDeTorta = 64;
    static int sanduiche = 20;
    static int leite = 20;
    static int cafe = 20;

    public static void removerItens(String item, int quantidade) {
        if ("pao".equals(item)) {
            ItensPorQuantidade.pao -= quantidade;
        } else if ("torta".equals(item)) {
            ItensPorQuantidade.fatiasDeTorta -= quantidade;
        } else if ("sanduiche".equals(item)) {
            ItensPorQuantidade.sanduiche -= quantidade;
        } else if ("leite".equals(item)) {
            ItensPorQuantidade.leite -= quantidade;
        } else if ("cafe".equals(item)) {
            ItensPorQuantidade.cafe -= quantidade;
        }
    }


}
