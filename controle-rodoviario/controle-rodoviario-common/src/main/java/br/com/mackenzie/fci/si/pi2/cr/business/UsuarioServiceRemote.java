/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.business;

import javax.ejb.Remote;

/**
 *
 * @author leonardo.rafaeli
 */
@Remote
public interface UsuarioServiceRemote {

    String testeNome(String nome);
    
}
