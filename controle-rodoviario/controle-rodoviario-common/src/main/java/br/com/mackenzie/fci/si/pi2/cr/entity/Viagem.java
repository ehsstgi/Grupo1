/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author leonardo.rafaeli
 */
@Entity
public class Viagem implements Serializable {

    @Id
    @TableGenerator(name="VIAGEM_GEN", table="SEQUENCE_TABLE", pkColumnName="SEQ_NAME",
        valueColumnName="SEQ_COUNT", pkColumnValue="VIAGEM_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="VIAGEM_GEN")
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    private static final long serialVersionUID = 1L;
    @ManyToOne
    private Cidade destino;
    @ManyToOne
    private Carro carro;
    private BigDecimal distancia;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    private String descricao;
    private BigDecimal duracao;
    @ManyToOne
    private Linha linha;
    @ManyToOne
    private Cidade origem;
    private BigDecimal valor;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDestino(Cidade destino) {
        this.destino = destino;
    }

    public void setDistancia(BigDecimal distancia) {
        this.distancia = distancia;
    }

    public void setDuracao(BigDecimal duracao) {
        this.duracao = duracao;
    }

    public void setLinha(Linha linha) {
        this.linha = linha;
    }

    public void setOrigem(Cidade origem) {
        this.origem = origem;
    }

    public Carro getCarro() {
        return carro;
    }

    public Date getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public Cidade getDestino() {
        return destino;
    }

    public BigDecimal getDistancia() {
        return distancia;
    }

    public BigDecimal getDuracao() {
        return duracao;
    }

    public Linha getLinha() {
        return linha;
    }

    public Cidade getOrigem() {
        return origem;
    }
    
    public String getDataHoraFormatada() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(data);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Viagem)) {
            return false;
        }
        Viagem other = (Viagem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.mackenzie.fci.si.pi2.entity.Viagem[ id=" + id + " ]";
    }
}
