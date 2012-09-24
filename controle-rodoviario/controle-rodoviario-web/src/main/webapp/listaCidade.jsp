<%-- 
    Document   : listaCidade
    Created on : Apr 4, 2012, 9:33:09 PM
    Author     : leonardo.rafaeli
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Cidade"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include file="includes/header.jsp" />
        <title>Lista de Cidades</title>
    </head>
    <body>
        <jsp:include page="includes/topo.jsp" />
        <jsp:directive.include file="includes/mensagens.jsp" />

        <table>
            <thead>
            <td>ID</td>
            <td>Nome</td>
            <td>Estado</td>
            <td>Ação</td>
        </thead>
        <%
        int count = 0;
        for (Cidade cidade : (List<Cidade>) request.getAttribute("cidades")) {%>
        <tr <%= count % 2 != 0 ? "class=\"zebra\"" : ""%>>
            <td><%= cidade.getId()%></td>
            <td><%= cidade.getNome()%></td>
            <td><%= cidade.getEstado()%></td>
            <td><a href="CidadeServlet?operacao=excluir&idCidade=<%= cidade.getId()%>" onclick="return confirm('Tem certeza?');">Excluir</a></td>
        </tr>
        <% }%>
    </table>

    <p><a href="cadastroCidade.jsp">Cadastrar nova cidade</a></p>
    <jsp:include page="includes/rodape.jsp" />
</body>
</html>
