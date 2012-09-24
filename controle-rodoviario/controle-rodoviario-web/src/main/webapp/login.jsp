<%-- 
    Document   : login
    Created on : May 10, 2012, 1:36:28 AM
    Author     : Jessica Braga
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include file="includes/header.jsp" />
        <title>Login</title>
    </head>
    <body>
        <jsp:include page="includes/topo.jsp" />
        <jsp:directive.include file="includes/mensagens.jsp" />
        <form action="LoginServlet" method="POST">
            <input type="hidden" name="operacao" value="login" />
            <%Object pagina = session.getAttribute("pagina");%>
            <input type="hidden" name="pagina" value=<%=pagina%> />
            <p>E-mail <input type="text" name="user" value="${param.user}"/></p>
            <p>Senha <input type="password" name="password" value="${param.password}"/></p>
            <p><input type="submit" value="Login" /></p>
        </form>
        <a href="cadastroUsuario.jsp">Cadastrar</a>
        <jsp:include page="includes/rodape.jsp" />
    </body>
</html>
