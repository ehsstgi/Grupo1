/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author leonardo.rafaeli
 */
@Entity
public class Linha implements Serializable {

   @Id
    @TableGenerator(name="LINHA_GEN", table="SEQUENCE_TABLE", pkColumnName="SEQ_NAME",
        valueColumnName="SEQ_COUNT", pkColumnValue="LINHA_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="LINHA_GEN")
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    private static final long serialVersionUID = 1L;

    private String nome;
    @ManyToOne
    private Cidade origem;
    @ManyToOne
    private Cidade destino;

    public void setDestino(Cidade destino) {
        this.destino = destino;
    }

    public Cidade getDestino() {
        return destino;
    }

    public String getNome() {
        return nome;
    }

    public Cidade getOrigem() {
        return origem;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setOrigem(Cidade origem) {
        this.origem = origem;
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
        if (!(object instanceof Linha)) {
            return false;
        }
        Linha other = (Linha) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.mackenzie.fci.si.pi2.entity.Linha[ id=" + id + " ]";
    }
}
