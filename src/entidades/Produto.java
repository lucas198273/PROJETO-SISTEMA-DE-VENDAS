
package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Produto extends Controle{

    private int codigo;
    private int quantidadeEstoque;
    private String nome;
    private Date dataVencimento;
    private TipoProduto tipoProduto;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    

    public Produto(int codigo, int quantidadeEstoque, String nome, TipoProduto tipoProduto,Date dataVencimento) {
        this.codigo = codigo;
        this.quantidadeEstoque = quantidadeEstoque;
        this.nome = nome;
        this.dataVencimento = dataVencimento;
        this.tipoProduto = tipoProduto;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }


 

    @Override
    public String toString() {
        return "Produto{" +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", nome='" + nome + '\'' +
                ", dataVencimento=" + sdf.format(dataVencimento) +
                '}';
                
    }
}
