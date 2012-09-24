<%-- 
    Document   : pagarPassagem
    Created on : May 20, 2012, 6:31:51 PM
    Author     : Jessica Braga
--%>

<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Viagem"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include file="includes/header.jsp" />
        <title>Pagar passagem</title>
    </head>
    <body>
        <jsp:include page="includes/topo.jsp" />
        <% Viagem viagem = (Viagem) (session.getAttribute("viagem"));
           String[] assentos = (String[])session.getAttribute("assentos");
            double valor=0;%>
        <form action="PassagemServlet" method="POST">
            <p>Sua viagem: <b><%=viagem.getDescricao()%></b><br/>
            Origem: <b><%= viagem.getOrigem().getNome()%></b><br>
            Destino: <b><%=viagem.getDestino().getNome()%></b>
            Data: <b><%=viagem.getData()%></b>
            
            </p>
            
            <p>
                Sua(s) passagem(ns):<br><br>
                
            <table border="1" style="width: 200px">
            <tr>
                <td>Poltrona</td>
                <td>Preço</td>
            </tr>
            <%for(int i = 0;i < assentos.length; i++){
                valor += viagem.getDistancia().doubleValue()*0.2;
            %>
            <tr>
                <td><%=assentos[i]%></td>
                <td>R$ <%=viagem.getValor()%></td>
            </tr>
            <%}%>
            <tr>
                <td>Total</td>
                <td><%=valor%></td>
            </tr>
        </table>
            </p>
            <input type="hidden" name="operacao" value="efetuarPgto" />
            <p>Número do cartão <input type="text" name="numeroCartao" maxlength="16"/></p>
            <p>Código de segurança <input type="text" name="codSeg" maxlengt="3"/></p>
            <p>Nome impresso no cartão <input type="text" name="nomeCartao"/></p>
            <p>Data de vencimento <input type="text" name="dataVenc" maxlength="5"/></p>
            <p><input type="submit" value="Pagar" /></p>
        </form>
        <jsp:include page="includes/rodape.jsp" />
    </body>
</html>
