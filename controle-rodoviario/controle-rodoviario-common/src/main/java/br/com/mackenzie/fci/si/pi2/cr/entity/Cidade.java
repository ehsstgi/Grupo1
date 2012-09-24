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
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @TableGenerator(name="CIDADE_GEN", table="SEQUENCE_TABLE", pkColumnName="SEQ_NAME",
        valueColumnName="SEQ_COUNT", pkColumnValue="CIDADE_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="CIDADE_GEN")
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    private String nome;
    private String estado;

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public String getNome() {
        return nome;
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
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
}
