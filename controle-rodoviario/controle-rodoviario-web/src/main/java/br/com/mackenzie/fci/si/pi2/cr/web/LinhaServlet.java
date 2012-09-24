

package br.com.mackenzie.fci.si.pi2.cr.web;

import br.com.mackenzie.fci.si.pi2.cr.business.LinhaFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.business.CidadeFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.entity.Linha;
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

@WebServlet(name = "LinhaServlet", urlPatterns = {"/LinhaServlet"})
public class LinhaServlet extends HttpServlet {
    
    @EJB
    private LinhaFacadeRemote linhaFacadeRemote;
    
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
            cadastroLinha(request, response);
        }
        if(operacao.equals("inicializarCadastroLinha")) {
            inicializarCadastroLinha(request,response);
        }
        if(operacao.equals("excluir")) {
            excluirLinha(request, response);
        }
        if(operacao.equals("listar")) {
            listarLinha(request, response);
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

    private void inicializarCadastroLinha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      List<Cidade> cidades = cidadeFacadeRemote.findAll();
      request.setAttribute("cidades", cidades);
      ServletUtils.forward("cadastroLinha.jsp", request, response);
              
    }
    private void cadastroLinha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String idOrigem = request.getParameter("origem");
        String idDestino = request.getParameter("destino");      
        
        Cidade origem = new Cidade();
        Cidade destino = new Cidade();
        origem.setId(Long.parseLong(idOrigem));
        destino.setId(Long.parseLong(idDestino));
        
        Linha linha = new Linha();
        linha.setNome(nome);
        linha.setOrigem(origem);
        linha.setDestino(destino);
        
        linhaFacadeRemote.create(linha);
        MessageUtils.addMessage(request, "Linha cadastrada com sucesso");
        ServletUtils.forward("indexAdmin.jsp", request, response);
    }

    private void listarLinha(HttpServletRequest request, HttpServletResponse response) {
        List<Linha> findAll = linhaFacadeRemote.findAll();
        request.setAttribute("linhas", findAll);
        
        ServletUtils.forward("listaLinha.jsp", request, response);
    }

    private void excluirLinha(HttpServletRequest request, HttpServletResponse response) {
        String idLinha = request.getParameter("idLinha");
        Linha linha = linhaFacadeRemote.find(Long.valueOf(idLinha));
        linhaFacadeRemote.remove(linha);
        MessageUtils.addMessage(request, "Linha excluída com sucesso");
        listarLinha(request, response);
    }

}
