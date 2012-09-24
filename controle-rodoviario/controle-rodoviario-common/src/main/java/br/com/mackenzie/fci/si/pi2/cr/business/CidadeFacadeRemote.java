/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.business;

import br.com.mackenzie.fci.si.pi2.cr.entity.Cidade;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author leonardo.rafaeli
 */
@Remote
public interface CidadeFacadeRemote {

    void create(Cidade cidade);

    void edit(Cidade cidade);

    void remove(Cidade cidade);

    Cidade find(Object id);

    List<Cidade> findAll();

    List<Cidade> findRange(int[] range);

    int count();
    
}
