

package br.com.mackenzie.fci.si.pi2.cr.web;

import br.com.mackenzie.fci.si.pi2.cr.business.UsuarioFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.entity.Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leonardo.rafaeli
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {
    
    @EJB
    private UsuarioFacadeRemote usuarioFacadeRemote;
    
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
        
        if(operacao.equals("cadastrar")) {
            cadastrarUsuario(request, response);
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

    private void cadastrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String cpf= request.getParameter("cpf");
        String perfil = request.getParameter("perfil");
        
        Date nascimento = null;
        String nascimentoParametro = request.getParameter("nascimento");
        try {
            nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(nascimentoParametro);
            
        } catch (ParseException ex) {
            MessageUtils.addMessage(request, "Data inválida (" + nascimentoParametro + "). Utilize o padrão DD/MM/AAAA");
            ServletUtils.forward("cadastroUsuario.jsp", request, response);
            return;
        }
        Usuario usuario = new Usuario();
        
        usuario.setEmail(email);
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setNascimento(nascimento);
        usuario.setCpf(cpf);
        usuario.setPerfil(perfil);
        
        usuarioFacadeRemote.create(usuario);
        
        MessageUtils.addMessage(request, "Usuário cadastrado com sucesso");
        
        if(ServletUtils.checarLogin(request)) {
            ServletUtils.forward("cadastroUsuario.jsp", request, response);
        } else {
            ServletUtils.forward("login.jsp", request, response);
        }
    }
}
