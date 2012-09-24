/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.business;

import br.com.mackenzie.fci.si.pi2.cr.entity.Carro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author leonardo.rafaeli
 */
@Stateless
public class CarroFacade extends AbstractFacade<Carro> implements CarroFacadeRemote {
    @PersistenceContext(unitName = "CRPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarroFacade() {
        super(Carro.class);
    }
    
}
