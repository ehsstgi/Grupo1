<%-- 
    Document   : listaCarro
    Author     : Lelio e Luthero
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Carro"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include file="includes/header.jsp" />
        <title>Lista de Carros</title>
    </head>
    <body>
        <jsp:include page="includes/topo.jsp" />
        <jsp:directive.include file="includes/mensagens.jsp" />
        
        <table>
            <thead>
            <td>ID</td>
            <td>Descrição</td>
            <td>Assento</td>
            <td>Ação</td>
            </thead>
            <%
            int count = 0;
            for (Carro carro : (List<Carro>) request.getAttribute("carros")) { %>
            <tr <%= count % 2 != 0 ? "class=\"zebra\"" : ""%>>
                <td><%= carro.getId() %></td>
                <td><%= carro.getDescricao() %></td>
                <td><%= carro.getAssentos() %></td>
                <td><a href="CarroServlet?operacao=excluir&idCarro=<%= carro.getId() %>" onclick="return confirm('Tem certeza?');">Excluir</a></td>
            </tr>
            <% } %>
        </table>
        
        <a href="cadastroCarro.jsp">Cadastrar novo Carro</a>
        
        <jsp:include page="includes/rodape.jsp" />
    </body>
</html>
