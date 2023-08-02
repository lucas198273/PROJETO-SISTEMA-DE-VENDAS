package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controle {

    private Map<Integer, Produto> EstoqueProdutos = new HashMap<>();

    private List<Venda> RegistroVendas = new ArrayList<>();

    protected void registrarVenda(int codigoProduto, int quantidadeVendida) {
        Date dataAtual = new Date(); // Obtem a data atual
        Venda venda = new Venda(codigoProduto, quantidadeVendida, dataAtual);
        RegistroVendas.add(venda);
        System.out.println("Venda registrada com sucesso!");
    }

    public void realizarVenda(int codigo, int quantidade) {
        Produto produto = EstoqueProdutos.get(codigo);
        if (produto != null) { // Produto existente true

            int quantidadeAtual = produto.getQuantidadeEstoque();
            if (quantidadeAtual < quantidade) {
                System.out.println("QUANTIDADE INSUFICIENTE NO ESTOQUE");
            } else {
                removerQuantidadeEstoque(codigo, quantidade);
                System.out.println("==***************************************************==");
                System.out.println(
                        "\nVenda Realizada /*Resta " + produto.getQuantidadeEstoque() + " Unidades Deste Produto* /");
                registrarVenda(codigo, quantidade);
                System.out.println();
            }
        }
    }

    public void exibirRegistroVendas() {

        if (RegistroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            for (Venda venda : RegistroVendas) {
                Produto produto = EstoqueProdutos.get(venda.getCodigo());
                if (produto != null) { // item do registro de vendas tambem esta no estoque de produtos
                    System.out.println("" + "codigo: #" + venda.getCodigo() + "\n Quantidade vendida: "
                            + venda.getQuantidadeVendida());
                }
                else{
                    System.out.println("ITEM NAO CONSTA NO ESTOQUE DE PRODUTOS ");
                }
            }
        }
    }

    public void adcionarProdutoEstoque(Integer codigo, Produto produto) {
        EstoqueProdutos.put(codigo, produto);
        System.out.println("*/Adicionado/*");
    }

    public void deletarDoEstoque(Integer codigo, Produto produto) {
        EstoqueProdutos.remove(codigo, produto);
        System.out.println("*/Removido/*");
    }

    public void adicionarQuantidadeEstoque(int codigo, int quantidade) {
        Produto produto = EstoqueProdutos.get(codigo);
        if (produto != null) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + quantidade);
        } else {
            System.out.println("*/Produto nao encontrado/*");
        }
    }

    public void removerQuantidadeEstoque(int codigo, int quantidade) {
        Produto produto = EstoqueProdutos.get(codigo);
        if (produto != null) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
        } else {
            System.out.println("*/Produto nao encontrado/*");
        }
    }

    public void exibirEstoque() {
        for (Map.Entry<Integer, Produto> produto : EstoqueProdutos.entrySet()) {
            int codigo = produto.getKey();
            Produto valor = produto.getValue();
            System.out.println("===============================================================================");
            System.out.println("CODIGO : " + codigo + "     NOME : " + valor.getNome()
                    + " \n QUANTIDADE EM ESTOQUE : " +
                    valor.getQuantidadeEstoque() + " ||| Data Vencimento: " + valor.getDataVencimento() + "\n");
        }
    }

    public void itemEstoqueProdutosMaiorQue(int valorFiltragem) {
        for (Map.Entry<Integer, Produto> produto : EstoqueProdutos.entrySet()) {
            int codigo = produto.getKey();
            Produto valor = produto.getValue();
            if (valor.getQuantidadeEstoque() >= valorFiltragem) {
                System.out.println("===============================================================================");
                System.out.println("CODIGO : " + codigo + "     NOME : " + valor.getNome()
                        + " \n QUANTIDADE EM ESTOQUE : " +
                        valor.getQuantidadeEstoque() + " ||| Data Vencimento: " + valor.getDataVencimento() + "\n");
            }

        }
    }

    public void dataVencimentoMaiorQue(Date date) {
        for (Map.Entry<Integer, Produto> produto : EstoqueProdutos.entrySet()) {
            if (produto != null) {
                Produto valor = produto.getValue();
                int codigo = produto.getKey();
                if (valor.getDataVencimento().after(date)) {
                    System.out.println("CODIGO : " + codigo + "     NOME : " + valor.getNome()
                            + " \n QUANTIDADE EM ESTOQUE : " +
                            valor.getQuantidadeEstoque() + " ||| Data Vencimento: " + valor.getDataVencimento()
                            + "CLASSIFICAÇÃO DO PRODUTO: " + valor.getTipoProduto() + "\n");
                }
            }
        }
    }

    public void dataVencimentoMenorQue(Date date) {
        for (Map.Entry<Integer, Produto> produto : EstoqueProdutos.entrySet()) {
            if (produto != null) {
                Produto valor = produto.getValue();
                int codigo = produto.getKey();
                if (valor.getDataVencimento().before(date)) {
                    System.out.println("CODIGO : " + codigo + "     NOME : " + valor.getNome()
                            + " \n QUANTIDADE EM ESTOQUE : " +
                            valor.getQuantidadeEstoque() + " ||| Data Vencimento: " + valor.getDataVencimento()
                            + "  CLASSIFICAÇÃO DO PRODUTO: " + valor.getTipoProduto() + "\n");
                }
            }
        }
    }

    public void filtraTipoDoProduto(TipoProduto tipoProduto) {
        for (Map.Entry<Integer, Produto> produto : EstoqueProdutos.entrySet()) {
            int codigo = produto.getKey();
            Produto valor = produto.getValue();
            if (produto != null) {
                if (valor.getTipoProduto().equals(tipoProduto)) { // Comparação de Objeto se faz com " .EQUALS() ".
                    System.out.println("CODIGO : " + codigo + "     NOME : " + valor.getNome()
                            + " \n QUANTIDADE EM ESTOQUE : " +
                            valor.getQuantidadeEstoque() + " ||| Data Vencimento: " + valor.getDataVencimento() + "\n");
                }
            }
        }
    }

}
