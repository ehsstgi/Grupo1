

package br.com.mackenzie.fci.si.pi2.cr.web;

import br.com.mackenzie.fci.si.pi2.cr.business.CarroFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.business.CidadeFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.business.LinhaFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.business.PassagemFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.business.ViagemFacadeRemote;
import br.com.mackenzie.fci.si.pi2.cr.entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * @author felipe.paula
 */

@WebServlet(name = "ViagemServlet", urlPatterns = {"/ViagemServlet"})
public class ViagemServlet extends HttpServlet {
    
    @EJB
    private LinhaFacadeRemote linhaFacadeRemote;
    
    @EJB
    private CidadeFacadeRemote cidadeFacadeRemote;

    @EJB
    private ViagemFacadeRemote viagemFacadeRemote;
    
    @EJB
    private CarroFacadeRemote carroFacadeRemote;
    
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
        
        if(operacao.equals("cadastrar")) {
            cadastrarViagem(request, response);

        }
        if(operacao.equals("buscar")) {
            buscarViagem(request, response);
        }
        if(operacao.equals("mostrar")) {
            mostrarViagem(request, response);
        }
        if(operacao.equals("inicializarCadastroViagem")) {
            inicializarCadastroViagem(request,response);
        }
        if(operacao.equals("listar")) {
            listarViagem(request,response);
        }
        if(operacao.equals("excluir")) {
            excluirLinha(request,response);
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

    private void inicializarCadastroViagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      List<Cidade> cidades = cidadeFacadeRemote.findAll();
      request.setAttribute("cidades", cidades);
      
      List<Linha> linhas  = linhaFacadeRemote.findAll();
      request.setAttribute("linhas", linhas);
      
      List<Carro> carros  = carroFacadeRemote.findAll();
      request.setAttribute("carros", carros);
      
      ServletUtils.forward("cadastroViagem.jsp", request, response);
              
    }
    private void cadastrarViagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
        String idlinha = request.getParameter("linha");
        String descricao = request.getParameter("descricao");
        String idOrigem = request.getParameter("origem");
        String idDestino = request.getParameter("destino");
        String distancia = request.getParameter("distancia");
        String data = request.getParameter("data");
        String duracao = request.getParameter("duracao");
        String idcarro = request.getParameter("carro");
        Date dataConvertida = null;
        try {
            dataConvertida = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(ViagemServlet.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }   
        BigDecimal distConvertida = new BigDecimal(distancia);
        BigDecimal duracaoConvertida = new BigDecimal(duracao);
        Viagem viagem = new Viagem();
        Linha linhas = new Linha();
        Cidade origem = new Cidade();
        Cidade destino = new Cidade();
        Carro carro = new Carro();
        
        carro.setId(Long.parseLong(idcarro));
        origem.setId(Long.parseLong(idOrigem));
        destino.setId(Long.parseLong(idDestino));
        linhas.setId(Long.parseLong(idlinha));
        origem.setId(Long.parseLong(idOrigem));
        destino.setId(Long.parseLong(idDestino));
        
        viagem.setOrigem(origem);
        viagem.setDestino(destino);
        viagem.setLinha(linhas);
        viagem.setDescricao(descricao);
        viagem.setDistancia(distConvertida);
        viagem.setData(dataConvertida);
        viagem.setDuracao(duracaoConvertida);
        viagem.setCarro(carro);

        
        viagemFacadeRemote.create(viagem);
         
        MessageUtils.addMessage(request, "Viagem cadastrada com sucesso");
        listarViagem(request, response);
        
    }

    private void buscarViagem(HttpServletRequest request, HttpServletResponse response) {
      List<Cidade> cidades = cidadeFacadeRemote.findAll();
      request.setAttribute("cidades", cidades);
      
      ServletUtils.forward("buscaViagem.jsp", request, response);
    }

    private void mostrarViagem(HttpServletRequest request, HttpServletResponse response) {
      Long idOrigem = "0".equals(request.getParameter("origem")) ? null : Long.parseLong(request.getParameter("origem"));
      Long idDestino = "0".equals(request.getParameter("destino")) ? null : Long.parseLong(request.getParameter("destino"));
      String data = request.getParameter("data");
      
      List<Viagem> viagens  = viagemFacadeRemote.listarViagens(idOrigem, idDestino, data);
      request.setAttribute("viagens", viagens);
      
      // Verifica quantos assentos disponíveis existem para cada viagem
      Map<Long,Integer> viagemAssentos = new HashMap<Long, Integer>();
      for(Viagem viagem : viagens) {
          int cadeirasLivres = viagem.getCarro().getAssentos() - passagemFacadeRemote.listarPassagensCompradasPorViagem(viagem).size();
          viagemAssentos.put(viagem.getId(), cadeirasLivres);
      }
      request.setAttribute("assentosLivres", viagemAssentos);
      
      List<Cidade> cidades = cidadeFacadeRemote.findAll();
      request.setAttribute("cidades", cidades);
      
      ServletUtils.forward("buscaViagem.jsp", request, response);
    }
    
    private void listarViagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Viagem> viagens = viagemFacadeRemote.findAll();
        request.setAttribute("viagens", viagens);
        ServletUtils.forward("listarViagem.jsp", request, response);
        
    }
    
    private void excluirLinha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idViagem = request.getParameter("idViagem");
        Viagem viagem = viagemFacadeRemote.find(Long.parseLong(idViagem));
        viagemFacadeRemote.remove(viagem);
        MessageUtils.addMessage(request, "Cidade excluída com sucesso");
        listarViagem(request, response);
    }

}
