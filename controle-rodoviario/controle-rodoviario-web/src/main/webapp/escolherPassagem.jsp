<%-- 
    Document   : escolherPassagem
    Created on : May 20, 2012, 4:22:19 PM
    Author     : Jessica Braga
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Viagem"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include file="includes/header.jsp" />
        <title>Escolher assento</title>
    </head>
    <body>
        <jsp:include page="includes/topo.jsp" />
        <%Viagem viagem = (Viagem) (session.getAttribute("viagem"));
        List<Integer> ocupados = (List<Integer>)request.getAttribute("ocupados");
        %>
        <form action="PassagemServlet" method="POST">
            <input type="hidden" name="operacao" value="pagarPassagem" />
            <input type="hidden" name="idViagem" value=<%=viagem.getId()  %> />
            <p>Sua viagem: <%=viagem.getDescricao()%><br>
            Origem: <%= viagem.getOrigem().getNome()%><br>
            Destino: <%=viagem.getDestino().getNome()%></p>
            
            <p>Escolha seu(s) assento(s):    
        <table border="1px">
        <%
        int i = 1;
        while(i <= viagem.getCarro().getAssentos()){ %>
        <tr>
            <%for(int j = 4;j > 0;j--){ 
                if(i< viagem.getCarro().getAssentos()+1){
            %>
                    <td>
                        <%if(!ocupados.contains(i)){%>
                        <input type="checkbox" name="assentos" value="<%=i%>" /><%
                                               }else{%>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                               <%}%> <%=i++%>
                    </td>
            <%  }else{ %>
                   <td>
                        &nbsp;
                    </td>

            <%    }
                if(j==3){
            %>
                    <td>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
            <%} }%>
        </tr>  
        <%}%>
        </table>
            </p>
        <p><input type="submit" value="Continuar" /></p>
        </form>
        <jsp:include page="includes/rodape.jsp" />
    </body>
</html>
