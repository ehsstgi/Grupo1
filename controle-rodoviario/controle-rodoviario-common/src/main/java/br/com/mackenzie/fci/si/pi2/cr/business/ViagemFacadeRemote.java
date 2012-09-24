/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.business;

import br.com.mackenzie.fci.si.pi2.cr.entity.Viagem;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author leonardo.rafaeli
 */
@Remote
public interface ViagemFacadeRemote {

    void create(Viagem viagem);

    void edit(Viagem viagem);

    void remove(Viagem viagem);

    Viagem find(Object id);

    List<Viagem> findAll();

    List<Viagem> findRange(int[] range);

    int count();

    public java.util.List<br.com.mackenzie.fci.si.pi2.cr.entity.Viagem> listarViagens(java.lang.Long idOrigem, java.lang.Long idDestino, java.lang.String date);
    
}
