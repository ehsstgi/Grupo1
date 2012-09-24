<%-- 
    Document   : cadastroUsuario
    Created on : Mar 28, 2012, 10:52:23 PM
    Author     : leonardo.rafaeli
--%>

<%@page import="br.com.mackenzie.fci.si.pi2.cr.web.ServletUtils"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include file="includes/header.jsp" />
        <title>Cadastro de Usuários</title>
    </head>
    <body>
        <jsp:include page="includes/topo.jsp" />
        <jsp:directive.include file="includes/mensagens.jsp" />
        <h1>Cadastrar novo usuário</h1>
        <form action="UsuarioServlet" method="POST">
            <input type="hidden" name="operacao" value="cadastrar" />
            <p>E-mail <input type="text" name="email" maxlength="30" value="${param.email}"/></p>
            <p>Senha <input type="password" name="senha" maxlength="8" /></p>
            <p>Nome <input type="text" name="nome" maxlength="30" value="${param.nome}"/></p>
            <p>Data de Nascimento <input type="text" name="nascimento" maxlength="10" size="12" value="${param.nascimento}"/></p>
            <p>CPF <input type="text" name="cpf" maxlength="14" value="${param.cpf}"/></p>
            <%
            if(ServletUtils.isAdmin(request)) {
            %>
            <p>Perfil <select name="perfil">
                    <option label="user">Usuário</option>
                    <option label="admin">Administrador</option>
                </select>
            </p>
            <% } else { %>
                <input type="hidden" name="perfil" value="user" />
            <% } %>
            <p>
                <input type="submit" value="Salvar" />
            </p>
        </form>
        <jsp:include page="includes/rodape.jsp" />
    </body>
</html>
