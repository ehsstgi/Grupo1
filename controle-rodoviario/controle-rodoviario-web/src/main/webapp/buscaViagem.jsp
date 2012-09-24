<%-- 
    Document   : buscaViagem
    Created on : May 9, 2012, 10:01:58 PM
    Author     : Jessica Braga
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Viagem"%>
<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Cidade"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include file="includes/header.jsp" />
        <title>Buscar viagem</title>
    </head>
    <body>
        <jsp:include page="includes/topo.jsp" />
        <form action="ViagemServlet" method="POST">
            <input type="hidden" name="operacao" value="mostrar" />
            <p>Cidade Origem <select id="origem" name="origem">
                    <option value="0">Selecione</option>
                    <% List<Cidade> cidades = (List<Cidade>) request.getAttribute("cidades");
                        List<Viagem> viagens = (List<Viagem>) (request.getAttribute("viagens"));

                        for (Cidade c : cidades) {%>
                    <option value="<% out.print(c.getId());%>"><%out.print(c.getNome());%></option>  
                    <% }%>  
                </select></p>
            <p>Cidade Destino <select id="destino" name="destino">
                    <option value="0">Selecione</option>
                    <%
                        for (Cidade c : cidades) {%>
                    <option value="<% out.print(c.getId());%>"><%out.print(c.getNome());%></option>  
                    <% }%>  
                </select></p>
            <p>Data <input name="data" id="data" value="${param.data}" /></p>
            <p><input type="submit" value="Buscar" /></p>
        </form>
        <br><br>
        <%
            if (viagens != null && !viagens.isEmpty()) {
                String id, nome;
                Map<Long, Integer> assentosLivres = (HashMap<Long, Integer>) request.getAttribute("assentosLivres");
        %>
        <table style="width: 100%">
            <tr>
                <td>
                    Rota
                </td>
                <td>
                    Linha
                </td>
                <td>
                    Horário
                </td>
                <td>
                    Assentos disponíveis
                </td>
                <td>
                    Valor
                </td>
            </tr>
            <%
                int count = 0;
                for (Viagem viagem : viagens) {%>
            <TR <%= count % 2 != 0 ? "class=\"zebra\"" : ""%>>
                <%
                   id = String.valueOf(viagem.getId());
                   nome = viagem.getDescricao();%>
                <td><a href="PassagemServlet?operacao=escolherPassagem&idViagem=<%=id%>"><%=nome%></a> </td>
                <td> <%= viagem.getLinha().getNome()%></td>
                <td> <%= viagem.getDataHoraFormatada() %></td>
                <td> <%= assentosLivres.get(viagem.getId())%></td>
                <td> R$ <%= viagem.getValor()%></td>
            </tr>

            <%}%>
        </table><br><br>
        <%}
            if (viagens != null && viagens.isEmpty()) {%>
        Não há viagens disponíveis para as cidades selecionadas<br>
        <%}

            String idOrigem = request.getParameter("origem");
            if (idOrigem != null) {
        %>
        <script type="text/javascript">
            $("#origem").val(<%= idOrigem%>);
        </script>
        <%
            }

            String idDestino = request.getParameter("destino");
            if (idDestino != null) {
        %>
        <script type="text/javascript">
            $("#destino").val(<%= idDestino%>);
        </script>
        <%
            }

        %>
        <jsp:include page="includes/rodape.jsp" />
        <script type="text/javascript">
            $(function() {
                jQuery(function($){
                    $.datepicker.regional['pt-BR'] = {
                        closeText: 'Fechar',
                        prevText: '&#x3c;Anterior',
                        nextText: 'Pr&oacute;ximo&#x3e;',
                        currentText: 'Hoje',
                        monthNames: ['Janeiro','Fevereiro','Mar&ccedil;o','Abril','Maio','Junho',
                            'Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
                        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun',
                            'Jul','Ago','Set','Out','Nov','Dez'],
                        dayNames: ['Domingo','Segunda-feira','Ter&ccedil;a-feira','Quarta-feira','Quinta-feira','Sexta-feira','Sabado'],
                        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sab'],
                        dayNamesMin: ['Dom','Seg','Ter','Qua','Qui','Sex','Sab'],
                        weekHeader: 'Sm',
                        dateFormat: 'dd/mm/yy',
                        firstDay: 0,
                        isRTL: false,
                        showMonthAfterYear: false,
                        yearSuffix: ''};
                    $.datepicker.setDefaults($.datepicker.regional['pt-BR']);
                });
          
                $( "#data" ).datepicker($.datepicker.regional[ "pt-BR" ]);
            });
        </script>
    </body>
</html>
