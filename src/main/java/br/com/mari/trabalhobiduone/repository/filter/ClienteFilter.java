package br.com.mari.trabalhobiduone.repository.filter;

import java.math.BigDecimal;
import java.util.Date;

public class ClienteFilter {
    private String nome;

    private Date datacompra;

    private BigDecimal valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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
