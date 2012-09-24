/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.business;

import br.com.mackenzie.fci.si.pi2.cr.entity.Cidade;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author leonardo.rafaeli
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UsuarioService implements UsuarioServiceRemote {

    @PersistenceContext(unitName="CRPU")
    private EntityManager em;
    
    @Override
    public String testeNome(String nome) {
        Cidade cidade = new Cidade();
        cidade.setNome("São Paulo");
        cidade.setEstado("SP");
        em.persist(cidade);
        em.flush();
        return "Olá, " + nome + ", bem vindo!";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
