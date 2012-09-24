/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.business;

import br.com.mackenzie.fci.si.pi2.cr.entity.Carro;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author leonardo.rafaeli
 */
@Remote
public interface CarroFacadeRemote {

    void create(Carro carro);

    void edit(Carro carro);

    void remove(Carro carro);

    Carro find(Object id);

    List<Carro> findAll();

    List<Carro> findRange(int[] range);

    int count();
    
}
