package br.com.mari.trabalhobiduone.repository.filter;

import java.math.BigDecimal;
import java.util.Date;

public class ContaReceberFilter {
    private Date datacompra;

    private BigDecimal valor;

    public Date getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(Date datacompra) {
        this.datacompra = datacompra;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
