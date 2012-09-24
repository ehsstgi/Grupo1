<%-- 
    Document   : cadastroCidade
    Created on : 30/03/2012, 21:10:05
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include file="includes/header.jsp" />
        <title>Cadastro de cidades</title>
    </head>
    <body>
        <jsp:include page="includes/topo.jsp" />
        <jsp:directive.include file="includes/mensagens.jsp" />
        <h1>Cadastrar Cidades</h1>
        <form action="CidadeServlet" method="POST">
            <input type="hidden" name="operacao" value="cadastrar" />
            <p>Nome: <input type="text" name="cidade" maxlength="30"/></p>
            <p>Estado: <select name="estado">
                <option value="AC">Acre</option>
                <option value="AL">Alagoas</option>
                <option value="AP">Amap�</option>
                <option value="AM">Amazonas</option>
                <option value="BA">Bahia</option>
                <option value="CE">Cear�</option>
                <option value="DF">Distrito Federal</option>
                <option value="ES">Esp�rito Santo</option>
                <option value="GO">Goi�s</option>
                <option value="MA">Maranh�o</option>
                <option value="MT">Mato Grosso</option>
                <option value="MS">Mato Grosso do Sul</option>
                <option value="MG">Minas Gerais</option>
                <option value="PA">Par�</option>
                <option value="PB">Para�ba</option>
                <option value="PR">Paran�</option>
                <option value="PE">Pernambuco</option>
                <option value="PI">Piau�</option>
                <option value="RJ">Rio de Janeiro</option>
                <option value="RN">Rio Grande do Norte</option>
                <option value="RS">Rio Grande do Sul</option>
                <option value="RR">Roraima</option>
                <option value="SC">Santa Catarina</option>
                <option value="SP">S�o Paulo</option>
                <option value="SE">Sergipe</option>
                <option value="TO">Tocantins</option>
                </select></p>
            <p><input type="submit" value="Cadastrar" />
        </form>
        <jsp:include page="includes/rodape.jsp" />
    </body>
</html>
