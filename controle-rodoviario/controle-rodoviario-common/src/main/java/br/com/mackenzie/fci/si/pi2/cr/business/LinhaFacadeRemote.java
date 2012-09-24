/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.business;

import br.com.mackenzie.fci.si.pi2.cr.entity.Linha;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author leonardo.rafaeli
 */
@Remote
public interface LinhaFacadeRemote {

    void create(Linha linha);

    void edit(Linha linha);

    void remove(Linha linha);

    Linha find(Object id);

    List<Linha> findAll();

    List<Linha> findRange(int[] range);

    int count();
    
}
