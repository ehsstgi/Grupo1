/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *
 * @author leonardo.rafaeli
 */
@Entity
public class Passagem implements Serializable {

    @Id
    @TableGenerator(name="PASSAGEM_GEN", table="SEQUENCE_TABLE", pkColumnName="SEQ_NAME",
        valueColumnName="SEQ_COUNT", pkColumnValue="PASSAGEM_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="PASSAGEM_GEN")
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    private static final long serialVersionUID = 1L;
    @ManyToOne
    private Viagem viagem;
    @ManyToOne
    private Usuario usuario;
    private String formaPagamento;
    private String nomePassageiro;
    private String documentoPassageiro;
    private Integer numeroAssento;

    public Integer getNumeroAssento() {
        return numeroAssento;
    }

    public void setNumeroAssento(Integer numeroAssento) {
        this.numeroAssento = numeroAssento;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public String getDocumentoPassageiro() {
        return documentoPassageiro;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public String getNomePassageiro() {
        return nomePassageiro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setNomePassageiro(String nome) {
        this.nomePassageiro = nome;
    }

    public void setFormaPgto(String formaPgto) {
        this.formaPagamento = formaPgto;
    }

    public void setDocumentoPassageiro(String docPass) {
        this.documentoPassageiro = docPass;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passagem)) {
            return false;
        }
        Passagem other = (Passagem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.mackenzie.fci.si.pi2.entity.Passagem[ id=" + id + " ]";
    }
}
