/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.business;

import br.com.mackenzie.fci.si.pi2.cr.entity.Cidade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author leonardo.rafaeli
 */
@Stateless
public class CidadeFacade extends AbstractFacade<Cidade> implements CidadeFacadeRemote {
    
    @PersistenceContext(unitName = "CRPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CidadeFacade() {
        super(Cidade.class);
    }
    
    @Override
    public List<Cidade> findAll() {
        return em.createQuery("SELECT c FROM Cidade c ORDER BY c.nome").getResultList();       
    }
    
}
