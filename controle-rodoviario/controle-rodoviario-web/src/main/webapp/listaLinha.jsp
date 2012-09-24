<%-- 
    Document   : listaCidade
    Created on : Apr 4, 2012, 9:33:09 PM
    Author     : leonardo.rafaeli
--%>

<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Linha"%>
<%@page import="java.util.List"%>
<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Cidade"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include file="includes/header.jsp" />
        <title>Lista de Linhas</title>
    </head>
    <body>
        <jsp:include page="includes/topo.jsp" />
        <jsp:directive.include file="includes/mensagens.jsp" />

        <table>
            <thead>
            <td>ID</td>
            <td>Descrição</td>
            <td>Origem</td>
            <td>Destino</td>
            <td>Ação</td>
        </thead>
        <% for (Linha linha: (List<Linha>) request.getAttribute("linhas")) {%>
        <tr>
            <td><%= linha.getId()%></td>
            <td><%= linha.getNome()%></td>
            <td><%= linha.getOrigem().getNome() %>/<%=linha.getOrigem().getEstado()%></td>
            <td><%= linha.getDestino().getNome() %>/<%=linha.getDestino().getEstado()%></td>
            <td><a href="LinhaServlet?operacao=excluir&idLinha=<%= linha.getId()%>" onclick="return confirm('Tem certeza?');">Excluir</a></td>
        </tr>
        <% }%>
    </table>

    <p><a href="LinhaServlet?operacao=inicializarCadastroLinha">Cadastrar nova linha</a></p>
    <jsp:include page="includes/rodape.jsp" />
</body>
</html>
