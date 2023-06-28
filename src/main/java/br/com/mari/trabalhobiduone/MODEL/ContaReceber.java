package br.com.mari.trabalhobiduone.MODEL;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Contareceber")
public class ContaReceber {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long idcompra;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datacompra;
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name="idcliente")
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(Date datacompra) {
        this.datacompra = datacompra;
    }

    public Long getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Long idcompra) {
        this.idcompra = idcompra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaReceber that = (ContaReceber) o;
        return Objects.equals(idcompra, that.idcompra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcompra);
    }
}
