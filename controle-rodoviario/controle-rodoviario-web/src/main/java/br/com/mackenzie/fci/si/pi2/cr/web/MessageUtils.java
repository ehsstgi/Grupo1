/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.web;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author leonardo.rafaeli
 */
public final class MessageUtils {
    public static final String SYSTEM_MESSAGES = "system_messages";
    
    public static boolean hasMessages(HttpServletRequest request) {
        return request.getAttribute(SYSTEM_MESSAGES) != null;
    }
    
    public static String convertMessages(HttpServletRequest request) {
        if(hasMessages(request)) {
            return (String) request.getAttribute(SYSTEM_MESSAGES);
        }
        
        return "";
    }

    static void addMessage(HttpServletRequest request, String mensagem) {
        request.setAttribute(SYSTEM_MESSAGES, mensagem);
    }
    
}
