/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.fci.si.pi2.cr.web;

import br.com.mackenzie.fci.si.pi2.cr.business.PassagemFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.business.ViagemFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.entity.Passagem;
import br.com.mackenzie.fci.si.pi2.cr.entity.Usuario;
import br.com.mackenzie.fci.si.pi2.cr.entity.Viagem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "PassagemServlet", urlPatterns = {"/PassagemServlet"})
public class PassagemServlet extends HttpServlet {

    @EJB
    private ViagemFacadeRemote viagemFacadeRemote;
    @EJB
    private PassagemFacadeRemote passagemFacadeRemote;

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

        if (operacao.equals("pagarPassagem")) {
            pagarPassagem(request, response);
        }
        if (operacao.equals("escolherPassagem")) {
            escolherPassagem(request, response);
        }
        if (operacao.equals("efetuarPgto")) {
            efetuarPgto(request, response);
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

    private void pagarPassagem(HttpServletRequest request, HttpServletResponse response) {

        Long idViagem = Long.parseLong(request.getParameter("idViagem"));
        request.setAttribute("idViagem", idViagem);

        String[] assentos = request.getParameterValues("assentos");
        HttpSession session = request.getSession();
        session.setAttribute("assentos", assentos);

        if(ServletUtils.checarLogin(request)) {
            ServletUtils.forward("pagarPassagem.jsp", request, response);
        } else {
            session.setAttribute("pagina","pagarPassagem.jsp");
            ServletUtils.forward("login.jsp", request, response);
        }
    }

    private void escolherPassagem(HttpServletRequest request, HttpServletResponse response) {

        Viagem viagem = viagemFacadeRemote.find(Long.parseLong(request.getParameter("idViagem")));
        HttpSession session = request.getSession();
        session.setAttribute("viagem", viagem);

        List<Passagem> passagensCompradas = passagemFacadeRemote.listarPassagensCompradasPorViagem(viagem);
        List<Integer> assentosOcupados = new ArrayList<Integer>();
        for (Passagem p : passagensCompradas) {
            assentosOcupados.add(p.getNumeroAssento());
        }
        request.setAttribute("ocupados", assentosOcupados);

        ServletUtils.forward("escolherPassagem.jsp", request, response);

    }

    private void efetuarPgto(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("user");
        Viagem viagem = (Viagem) session.getAttribute("viagem");

        String[] assentos = (String[]) session.getAttribute("assentos");

        for (int i = 0; i < assentos.length; i++) {

            Passagem passagem = new Passagem();
            passagem.setDocumentoPassageiro(usu.getCpf());
            passagem.setFormaPgto("CARTÃO CRÉDITO");
            passagem.setNomePassageiro(usu.getNome());
            passagem.setNumeroAssento(Integer.parseInt(assentos[i]));//gambis bo momento
            passagem.setUsuario(usu);
            passagem.setViagem(viagem);

            passagemFacadeRemote.create(passagem);

            ServletUtils.forward("emitirCodigoPassagem.jsp", request, response);
        }


    }
}
