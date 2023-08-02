package entidades;

import java.util.Date;

public class Venda {
    
    private int codigo;
    private int quantidadeVendida;
    private Date dataVenda;

    
    public Venda(int codigo, int quantidadeVendida, Date dataVenda) {
        this.codigo = codigo;
        this.quantidadeVendida = quantidadeVendida;
        this.dataVenda = dataVenda;
    }


    public int getCodigo() {
        return codigo;
    }


    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }


    public Date getDataVenda() {
        return dataVenda;
    }
    

}
