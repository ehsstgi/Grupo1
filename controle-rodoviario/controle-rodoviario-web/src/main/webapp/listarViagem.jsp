<%-- 
    Document   : listarViagem
    Created on : 25/05/2012, 19:40:15
    Author     : Felipe
--%>
<%@page import="java.util.List"%>
<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Linha"%>
<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Viagem"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include file="includes/header.jsp" />
        <title>Lista de Viagens</title>
    </head>
    <body>
        <jsp:include page="includes/topo.jsp" />
        <jsp:directive.include file="includes/mensagens.jsp" />

        <table style="width: 100%">
            <thead>
            <td>Linha</td>
            <td>Descrição</td>
            <td>Cidade Origem</td>
            <td>Cidade Destino</td>
            <td>Distância</td>
            <td>Data e Hora</td>
            <td>Duração</td>
            <td>Valor</td>
            <td>Ação</td>
        </thead>
        <%
        int count = 0;
        for (Viagem viagem : (List<Viagem>) request.getAttribute("viagens")) {%>
        <tr <%= count % 2 != 0 ? "class=\"zebra\"" : ""%>>
                <td><%= viagem.getLinha().getNome()%></td>
                <td><%= viagem.getDescricao()%></td>
                <td><%= viagem.getOrigem().getNome()%></td>
                <td><%= viagem.getDestino().getNome()%></td>
                <td><%= viagem.getDistancia()%> KM</td>
                <td><%= viagem.getDataHoraFormatada()%></td>
                <td><%= viagem.getDuracao()%> horas</td>
                <td><%= viagem.getValor()%></td>
                <td><a href="ViagemServlet?operacao=excluir&idViagem=<%= viagem.getId()%>" onclick="return confirm('Tem certeza?');">Excluir</a></td>
            </tr>
        <% 
        count++;
        }%>
    </table>

    <p><a href="ViagemServlet?operacao=inicializarCadastroViagem">Cadastrar nova viagem</a></p>        
    <jsp:include page="includes/rodape.jsp" />
</body>
</html>
