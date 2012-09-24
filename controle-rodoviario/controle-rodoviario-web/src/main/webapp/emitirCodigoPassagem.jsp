<%-- 
    Document   : emitirCodigoPassagem
    Created on : Jun 6, 2012, 12:23:18 AM
    Author     : Jessica Braga
--%>

<%@page import="java.math.BigDecimal"%>
<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Viagem"%>
<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include file="includes/header.jsp" />
        <title>Compra efetuada com sucesso!</title>
    </head>
    <body>
        <jsp:include page="includes/topo.jsp" />
        <jsp:directive.include file="includes/mensagens.jsp" />
        <%Usuario usu = (Usuario) session.getAttribute("user");
            Viagem viagem = (Viagem) session.getAttribute("viagem");
            String[] assentos = (String[]) session.getAttribute("assentos");
            BigDecimal valor = BigDecimal.ZERO;%>
        <p>Caro usuario <b><%= usu.getNome()%></b>,</p>
        <p>
            Você acabou de realizar a compra de <%=assentos.length%> passagens <br/>
            de <%=viagem.getOrigem().getNome()%> até <%=viagem.getDestino().getNome()%><br/><br/>

            Segue abaixo os detalhes da sua transação<br>
        </p>

        <table>
            <thead>
                <tr>
                    <td>Poltrona</td>
                    <td>Preço</td>
                </tr>
            </thead>
            <%for (int i = 0; i < assentos.length; i++) {
                    valor = valor.add(viagem.getValor());
            %>
            <tr <%= i % 2 != 0 ? "class=\"zebra\"" : ""%>>
                <td><%=assentos[i]%></td>
                <td>R$ <%=viagem.getValor()%></td>
            </tr>
            <%}%>
            <tr style="background-color: gray;">
                <td>Total</td>
                <td>R$ <%=valor%></td>
            </tr>
        </table>
        <p>Compareça até o balcão da compania com o seu CPF para retirar a passagem</p>
        <p><a href="index.jsp">Continuar comprando</a></p>
        <jsp:include page="includes/rodape.jsp" />
    </body>
</html>
