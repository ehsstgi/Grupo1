<%-- 
    Document   : cadastroUsuario
    Created on : Abr 18, 2012, 04:47:23 PM
    Author     : felipe.paula
--%>

<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Cidade"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include file="includes/header.jsp" />
        <title>Cadastro de Linha</title>
    </head>
    <body>
        <jsp:include page="includes/topo.jsp" />
        <jsp:directive.include file="includes/mensagens.jsp" />
        <h1>Cadastrar nova linha</h1>
        <form action="LinhaServlet" method="POST">
            <input type="hidden" name="operacao" value="cadastrar" />
            <p>Nome Linha <input type="text" name="nome" maxlength="30"/></p>
            <p>Cidade Origem <select name="origem">
                    <option value="0">Selecione</option>
                    <% List<Cidade> cidades = (List<Cidade>) request.getAttribute("cidades");
                    
                    for (Cidade c : cidades){ %>
                    <option value="<% out.print(c.getId());%>"><%out.print(c.getNome());%></option>  
                    <% } %>  
                </select></p>
            <p>Cidade Destino <select name="destino">
                    <option value="0">Selecione</option>
                    <%                    
                    for (Cidade c : cidades){ %>
                    <option value="<% out.print(c.getId());%>"><%out.print(c.getNome());%></option>  
                    <% } %>  
                </select></p>
            <p><input type="submit" value="Salvar" />
        </form>
        <jsp:include page="includes/rodape.jsp" />
    </body>
</html>
