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
public class Carro implements Serializable {

    @Id
    @TableGenerator(name="CARRO_GEN", table="SEQUENCE_TABLE", pkColumnName="SEQ_NAME",
        valueColumnName="SEQ_COUNT", pkColumnValue="CARRO_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="CARRO_GEN")
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setAssentos(Integer assentos) {
        this.assentos = assentos;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    private static final long serialVersionUID = 1L;

    private String descricao;
    private Integer assentos;

    public Integer getAssentos() {
        return assentos;
    }

    public String getDescricao() {
        return descricao;
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
        if (!(object instanceof Carro)) {
            return false;
        }
        Carro other = (Carro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.mackenzie.fci.si.pi2.entity.Carro[ id=" + id + " ]";
    }
    
}
