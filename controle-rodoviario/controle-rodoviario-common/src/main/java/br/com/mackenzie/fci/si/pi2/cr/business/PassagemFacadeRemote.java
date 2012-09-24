/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.business;

import br.com.mackenzie.fci.si.pi2.cr.entity.Passagem;
import br.com.mackenzie.fci.si.pi2.cr.entity.Viagem;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author leonardo.rafaeli
 */
@Remote
public interface PassagemFacadeRemote {

    void create(Passagem passagem);

    void edit(Passagem passagem);

    void remove(Passagem passagem);

    Passagem find(Object id);

    List<Passagem> findAll();

    List<Passagem> findRange(int[] range);
    
    List<Passagem> listarPassagensCompradasPorViagem(Viagem viagem);

    int count();
    
    public java.util.List<br.com.mackenzie.fci.si.pi2.cr.entity.Passagem> listarPassagensPorCPF(java.lang.String cpf);
    
}
