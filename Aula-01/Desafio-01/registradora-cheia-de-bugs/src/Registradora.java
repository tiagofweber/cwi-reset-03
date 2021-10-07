
public class Registradora {

    public static void main(String[] args) {
//        primeiroBug();

//        segundoBug();

//        terceiroBug();

//        quartoBug();

//        quintoBug();

        sextoBug();
    }

    private static double registrarItem(String item, int quantidade) {
        double precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);

        boolean vendaConcluida = true;

        while (QuantidadeMinimaItem.precisaReposicao(item, quantidade)) {
            if ("pao".equals(item) || "sanduiche".equals(item) || "torta".equals(item)) {
                if (!DataProjeto.cozinhaEmFuncionamento()) {
                    vendaConcluida = false;
                    precoItem = 0;
                    System.out.println("Cozinha fechada!");
                    System.out.println("Reposição de " + item + " indisponível.");
                    if ("pao".equals(item)) {
                        System.out.println("A quantidade restante em estoque é " + ItensPorQuantidade.pao + ".");
                    } else if ("sanduiche".equals(item)) {
                        System.out.println("A quantidade restante em estoque é " + ItensPorQuantidade.sanduiche + ".");
                    } else if ("torta".equals(item)) {
                        System.out.println("A quantidade restante em estoque é " + ItensPorQuantidade.fatiasDeTorta + ".");
                    }
                    break;
                } else {
                    ReposicaoCozinha.reporItem(item);
                }
            } else if ("leite".equals(item) || "cafe".equals(item)) {
                ReposicaoFornecedor.reporItem(item);
            }
        }

        if (vendaConcluida) {
            ItensPorQuantidade.removerItens(item, quantidade);
        }

        return precoItem;

    }

    private static void primeiroBug() {
        DataProjeto data = DataProjeto.criarDataComCozinhaFuncionando();
        String item = "sanduiche";
        int quantidade = 4;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void segundoBug() {
        DataProjeto.criarDataComCozinhaEncerradaMasComDiaUtil();
        String item = "torta";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void terceiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "cafe";
        int quantidade = 40;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void quartoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

    private static void quintoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "pao";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void sextoBug() {
        DataProjeto.criarDataComCozinhaEncerradaSemDiaUtil();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        if (precoTotal != 0) {
            System.out.println(String.format("Valor total: %.2f", precoTotal));
        }

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        if (precoTotal2 != 0) {
            System.out.println(String.format("Valor total: %.2f", precoTotal2));
        }


    }

}
