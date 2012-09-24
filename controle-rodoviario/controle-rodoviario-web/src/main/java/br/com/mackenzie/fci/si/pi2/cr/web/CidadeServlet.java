

package br.com.mackenzie.fci.si.pi2.cr.web;

import br.com.mackenzie.fci.si.pi2.cr.business.CarroFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.business.CidadeFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.entity.Cidade;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author felipe.paula
 */

@WebServlet(name = "CidadeServlet", urlPatterns = {"/CidadeServlet"})
public class CidadeServlet extends HttpServlet {
    
    @EJB
    private CidadeFacadeRemote cidadeFacadeRemote;
    
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
            cadastrarCidade(request, response);
        }
        if(operacao.equals("listar")) {
            listarCidades(request,response);
        }
        if(operacao.equals("excluir")) {
            excluirCidade(request,response);
        }
        if(operacao.equals("listarIndex")) {
            listarIndex(request,response);
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

    private void cadastrarCidade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String estado = request.getParameter("estado");
        String nomeCidade = request.getParameter("cidade");
        
        Cidade cidade = new Cidade();

        cidade.setNome(nomeCidade);
        cidade.setEstado(estado);
        cidadeFacadeRemote.create(cidade);
             
        MessageUtils.addMessage(request, "Cidade cadastrada com sucesso");
        listarCidades(request, response);
    }

    private void listarCidades(HttpServletRequest request, HttpServletResponse response) {
        List<Cidade> cidades = cidadeFacadeRemote.findAll();
        
        request.setAttribute("cidades", cidades);
        
        ServletUtils.forward("listaCidade.jsp", request, response);
    }

    private void excluirCidade(HttpServletRequest request, HttpServletResponse response) {
        String idCidade = request.getParameter("idCidade");
        Cidade cidade = cidadeFacadeRemote.find(Long.parseLong(idCidade));
        cidadeFacadeRemote.remove(cidade);
        MessageUtils.addMessage(request, "Cidade excluída com sucesso");
        listarCidades(request, response);
    }

    private void listarIndex(HttpServletRequest request, HttpServletResponse response) {
         List<Cidade> cidades = cidadeFacadeRemote.findAll();
        
        request.setAttribute("cidades", cidades);
        
        ServletUtils.forward("index.jsp", request, response);
    }
}