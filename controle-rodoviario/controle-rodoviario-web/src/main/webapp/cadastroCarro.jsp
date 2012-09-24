<%-- 
    Document   : cadastroCarro
    Author     : Lelio e Luthero
    Revisado     : Felipe Sousa
--%>

<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Carro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include file="includes/header.jsp" />
        <title>Cadastro de Carro</title>
    </head>
    <body>
        <jsp:include page="includes/topo.jsp" />
        <jsp:directive.include file="includes/mensagens.jsp" />
        <h1>Cadastrar novo carro</h1>
        <form action="CarroServlet" method="POST">
            <input type="hidden" name="operacao" value="cadastrar" />
            <p>Descrição: <input type="text" name="descricao" maxlength="20"/></p>
            <p>Número de Assentos: <input type="text" name="assentos" maxlength="02"/></p>
            <p><input type="submit" value="Salvar" />
        </form>
        <jsp:include page="includes/rodape.jsp" />
    </body>
</html>
