public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int qtd) {
        double precoTotal = 0;

        if ("pao".equals(item)) {
            precoTotal = 12.75 * ((double) qtd * 60 / 1000);
        } else if ("torta".equals(item)) {
            precoTotal = 96.00 * ((double) qtd / 16);
        } else if ("leite".equals(item)) {
            precoTotal = 4.48 * qtd;
        } else if ("cafe".equals(item)) {
            precoTotal = 9.56 * qtd;
        } else if ("sanduiche".equals(item)) {
            precoTotal = 4.5 * qtd;
        }

        return precoTotal;
    }
}
