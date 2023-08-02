package programa;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entidades.Alimentos;
import entidades.Bebidas;
import entidades.Controle;
import entidades.Produto;
import entidades.TipoProduto;

public class Programa {

    public static void main(String[] args) throws ParseException {

        System.out.println("Sistema Iniciado");
        Controle estoque = new Controle();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Produto produto1 = new Bebidas(1, 55, "Whisky Belga", TipoProduto.BEBIDA_ALCOOLICA, sdf.parse("05/05/2055"));
        Produto produto2 = new Bebidas(2, 55, "Whisky Chileno", TipoProduto.BEBIDA_ALCOOLICA, sdf.parse("05/05/2050"));
        Produto produto3 = new Bebidas(3, 55, "Whisky Françes", TipoProduto.BEBIDA_ALCOOLICA, sdf.parse("05/05/2045"));
        Produto produto4 = new Bebidas(4, 55, "Whisky Alemao", TipoProduto.BEBIDA_ALCOOLICA, sdf.parse("05/05/2040"));
        Produto produto5 = new Bebidas(5, 55, "Whisky Italiano", TipoProduto.BEBIDA_ALCOOLICA, sdf.parse("05/05/2035"));
        Produto produto6 = new Bebidas(6, 55, "Whisky Chileno", TipoProduto.BEBIDA_ALCOOLICA, sdf.parse("05/05/2030"));
        Produto produto7 = new Alimentos(7, 10, "Torta de Frango", TipoProduto.ALIMENTO, sdf.parse("05/08/2030"));
        Produto produto8 = new Alimentos(8, 10, "Torta de Pessego", TipoProduto.ALIMENTO, sdf.parse("05/08/2030"));

        estoque.adcionarProdutoEstoque(produto1.getCodigo(), produto1);
        estoque.adcionarProdutoEstoque(produto2.getCodigo(), produto2);
        estoque.adcionarProdutoEstoque(produto3.getCodigo(), produto3);
        estoque.adcionarProdutoEstoque(produto4.getCodigo(), produto4);
        estoque.adcionarProdutoEstoque(produto5.getCodigo(), produto5);
        estoque.adcionarProdutoEstoque(produto6.getCodigo(), produto6);
        estoque.adcionarProdutoEstoque(produto7.getCodigo(), produto7);
        estoque.adcionarProdutoEstoque(produto8.getCodigo(), produto8);

        estoque.exibirEstoque();

        System.out.println("===================================================\n\n");

        // System.out.println("Chamando Metodo de filtragem por valor");

        // estoque.itemEstoqueProdutosMaiorQue( 16);

        System.out.println("===================================================\n\n");
        System.out.println("Chamando Metodo de filtragem por valor 16");
        estoque.adicionarQuantidadeEstoque(4, 3);
        estoque.adicionarQuantidadeEstoque(3, 10);
        estoque.itemEstoqueProdutosMaiorQue(22);

        System.out.println("================================================");
        System.out.println("\n\n====Filtrando por data SUPERIOR A DATA DATA PASSADA COMO PARAMETRO ");

        estoque.dataVencimentoMaiorQue(sdf.parse("05/05/2044"));

        System.out.println();
        System.out.println("\n\n====Filtrando por data ANTERIOR A DATA DATA PASSADA COMO PARAMETRO \n ");

        estoque.dataVencimentoMenorQue(sdf.parse("06/10/2041"));

        System.out.println("\n Testando metodo de filtragem na enumeração / Tipo Do Produto Alimento");

        estoque.filtraTipoDoProduto(TipoProduto.ALIMENTO);

        System.out.println("\n\n Testando metodo para realizar vendas: ");
        estoque.realizarVenda(8, 9);

        estoque.exibirEstoque();

        estoque.realizarVenda(5, 5);
        estoque.exibirEstoque();

        System.out.println("==================");
        System.out.println("Registro de Vendas");
        estoque.exibirRegistroVendas();
        System.out.println("==================");

    }
}
