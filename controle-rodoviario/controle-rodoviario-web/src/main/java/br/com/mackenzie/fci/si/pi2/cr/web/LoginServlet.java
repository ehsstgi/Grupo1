/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.web;

import br.com.mackenzie.fci.si.pi2.cr.business.UsuarioFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.business.ViagemFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.entity.Usuario;
import br.com.mackenzie.fci.si.pi2.cr.entity.Viagem;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jessica Braga
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    
    @EJB
    private ViagemFacadeRemote viagemFacadeRemote;
     
    @EJB
    private UsuarioFacadeRemote userFacadeRemote;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String operacao = request.getParameter("operacao");
     
      if(operacao.equals("login")){
          login(request,response);
      }
      if(operacao.equals("logout")){
          logout(request,response);
      } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void login(HttpServletRequest request, HttpServletResponse response) {
        Usuario user = userFacadeRemote.findByLogin(request.getParameter("user"), request.getParameter("password"));
        if(user == null) {
            MessageUtils.addMessage(request, "E-mail ou senha inválidos");
            ServletUtils.forward("login.jsp", request, response);
            return;
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        
        String pagina = request.getParameter("pagina");
        if("null".equals(pagina)) {
            ServletUtils.forward("index.jsp", request, response);
            return;
        }
        ServletUtils.forward(pagina, request, response); 
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        ServletUtils.forward("index.jsp", request, response); 
    }
}
