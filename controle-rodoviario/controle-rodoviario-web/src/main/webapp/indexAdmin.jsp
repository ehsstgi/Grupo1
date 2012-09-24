<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <jsp:directive.include file="includes/header.jsp" />
        <title>Panel de Controle</title>
    </head>
    <body>
        <jsp:include page="includes/topo.jsp" />
        <p align="center"><h2>Painel de Controle</h2></p>
        <table width="100%" style="font-weight: bold; font-size: 14px">
            <tr>
                <td align="center"><a href="CidadeServlet?operacao=listar"><img src="img/cidades.gif" title="Cidades"/></a><br/>Cidades</td>
                <td align="center"><a href="LinhaServlet?operacao=listar"><img src="img/linha.png" title="Linhas"/></a><br/>Linhas</td>
                <td align="center"><a href="CarroServlet?operacao=listar"><img src="img/carros.gif" title="Carros"/></a><br/>Carros</td>
                <td align="center"><a href="ViagemServlet?operacao=listar"><img src="img/viagem.png" title="Viagens"/></a><br/>Viagens</td>
                <td align="center"><a href="cadastroUsuario.jsp"><img src="img/users.png" title="Usuários"/></a><br/>Usuários</td>
            </tr>
        </table>
        <jsp:include page="includes/rodape.jsp" />
    </body>
</html>
