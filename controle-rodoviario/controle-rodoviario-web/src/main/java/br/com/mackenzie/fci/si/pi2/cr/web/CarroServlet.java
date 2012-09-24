
package br.com.mackenzie.fci.si.pi2.cr.web;

import br.com.mackenzie.fci.si.pi2.cr.business.CarroFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.entity.Carro;
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
 * @author Lelio e Luthero Filho
 */
@WebServlet(name = "CarroServlet", urlPatterns = {"/CarroServlet"})
public class CarroServlet extends HttpServlet {

    @EJB
    private CarroFacadeRemote carroFacadeRemote;
    
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
            cadastrarCarro(request, response);
        }
        if(operacao.equals("listar")) {
            listarCarro(request,response);
        }
        if(operacao.equals("excluir")) {
            excluirCarro(request,response);
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
    

    
    private void cadastrarCarro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descricao = request.getParameter("descricao");
        String assentos = request.getParameter("assentos");
        
        Carro carro = new Carro();
             
        carro.setDescricao(descricao);
        carro.setAssentos(Integer.parseInt(assentos));
        carroFacadeRemote.create(carro);
        
        
        MessageUtils.addMessage(request, "Carro cadastrado com sucesso");
        listarCarro(request, response);
    }

    private void listarCarro(HttpServletRequest request, HttpServletResponse response) {
        List<Carro> carros = carroFacadeRemote.findAll();
        
        request.setAttribute("carros", carros);
        
        ServletUtils.forward("listaCarro.jsp", request, response);
    }

    private void excluirCarro(HttpServletRequest request, HttpServletResponse response) {
        String idCarro = request.getParameter("idCarro");
        Carro carro = carroFacadeRemote.find(Long.parseLong(idCarro));
        carroFacadeRemote.remove(carro);
        MessageUtils.addMessage(request, "Carro excluído com sucesso");
        listarCarro(request, response);
        
        
        
    }
}
