/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.web;

import br.com.mackenzie.fci.si.pi2.cr.entity.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author leonardo.rafaeli
 */
public class ServletUtils {

    public static void forward(String endereco, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher(endereco).forward(request, response);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } 
    }
    
    public static boolean checarLogin(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session == null) {
            return false;
        }
        return session.getAttribute("user") != null;
    }
    public static boolean isAdmin(HttpServletRequest request) {
        if(checarLogin(request)) {
            Usuario usuario = (Usuario) request.getSession().getAttribute("user");
            return "admin".equalsIgnoreCase(usuario.getPerfil());
        }
        return false;
    }
    
}
