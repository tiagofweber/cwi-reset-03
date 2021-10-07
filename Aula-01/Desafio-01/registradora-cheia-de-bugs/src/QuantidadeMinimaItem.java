public class QuantidadeMinimaItem {

    public static boolean precisaReposicao(String item, int quantidade) {
        boolean fazerReposição = false;

        if ("pao".equals(item)) {
            if (ItensPorQuantidade.pao < 600 || (ItensPorQuantidade.pao - quantidade) <= 0)
            fazerReposição = true;
        } else if ("torta".equals(item)) {
            if (ItensPorQuantidade.fatiasDeTorta < 10 || (ItensPorQuantidade.fatiasDeTorta - quantidade) <= 0) {
                fazerReposição = true;
            }
        } else if ("sanduiche".equals(item)) {
            if (ItensPorQuantidade.sanduiche <= 1 || (ItensPorQuantidade.sanduiche - quantidade) < 0) {
                fazerReposição = true;
            }
        } else if ("cafe".equals(item)) {
            if (ItensPorQuantidade.cafe < 12 || (ItensPorQuantidade.cafe - quantidade) <= 0) {
                fazerReposição = true;
            }
        } else if ("leite".equals(item)) {
            if (ItensPorQuantidade.leite < 12 || (ItensPorQuantidade.leite - quantidade) <= 0) {
                fazerReposição = true;
            }
        }

        return fazerReposição;
    }
}
