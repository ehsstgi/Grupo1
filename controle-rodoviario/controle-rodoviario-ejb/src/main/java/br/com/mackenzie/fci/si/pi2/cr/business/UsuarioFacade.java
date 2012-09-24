/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.business;

import br.com.mackenzie.fci.si.pi2.cr.entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author leonardo.rafaeli
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeRemote {

    @PersistenceContext(unitName = "CRPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario findByLogin(String login, String password) {
        StringBuilder sb = new StringBuilder();
        sb.append("select u from Usuario u");

        if (login != null) {
            sb.append(" where ");
            sb.append("u.email = '" + login + "' and u.senha = '" + password + "'" );
        }
        List resultList = em.createQuery(sb.toString()).getResultList();
        if (resultList.size() == 0) {
            return null;
        }
        return (Usuario) resultList.get(0);
    }
}
