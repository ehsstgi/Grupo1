<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Cidade"%>
<%@page import="java.util.List"%>
<%@page import="br.com.mackenzie.fci.si.pi2.cr.web.ServletUtils"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Auto Via&ccedil;&atilde;o Mackenzie</title>
        <jsp:include page="includes/header.jsp" />

        <script type="text/javascript">
            $(document).ready(function(){
                $("#featured ul").tabs({fx:{opacity: "toggle"}}).tabs("rotate", 5000, true); 
                $("#conteudo").remove();
            });
        </script>
        <%
            if (request.getAttribute("cidades") == null) {
                ServletUtils.forward("CidadeServlet?operacao=listarIndex", request, response);
            }
        %>
    </head>
    <body>

        <jsp:include page="includes/topo.jsp" />            
        </div>
        <div id="conteudoSemPadding">

            <div id="passagem">
                <div class="interno">
                    <table border="0">
                        <tr>
                            <td>
                                <img src="img/bus.png" />
                            </td>
                            <td style="color:#B71111;font-size: 13px;">
                                Compre aqui sua passagem
                            </td>
                        </tr>
                    </table>

                    <!-- Formulário -->
                    <div id="formularioPassagem">
                        <form action="ViagemServlet">
                            <input type="hidden" name="operacao" value="mostrar" />
                            <table style="width: 100%">
                                <tr>
                                    <td colspan="2">
                                        Origem
                                    </td>
                                </tr>   
                                <tr>
                                    <td colspan="2">
                                        <select name="origem" style="width: 100%">
                                            <option value="0">Selecione</option>
                                            <% List<Cidade> cidades = (List<Cidade>) request.getAttribute("cidades");

                                                for (Cidade c : cidades) {%>
                                            <option value="<% out.print(c.getId());%>"><%out.print(c.getNome());
                                            out.print("/" + c.getEstado());%></option>  
                                            <% }%>  
                                        </select>
                                    </td>
                                </tr>   
                                <tr>
                                    <td colspan="2">
                                        Destino
                                    </td>
                                </tr>   
                                <tr>
                                    <td colspan="2">
                                        <select name="destino" style="width: 100%">
                                            <option value="0">Selecione</option>
                                            <%
                                            for (Cidade c : cidades) {%>
                                            <option value="<% out.print(c.getId());%>"><%out.print(c.getNome());
                                            out.print("/" + c.getEstado());%></option>  
                                            <% }%>  
                                        </select>
                                    </td>
                                </tr> 
                                <tr>
                                    <td>
                                        Data:
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="text" name="data" id="data" size="10" />
                                    </td>
                                    <td />
                                </tr>
                                <tr>
                                    <td>&nbsp;</td>
                                    <td rowspan="2"><input type="image" src="img/find.png" /></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
            <!-- FIM - Formulário Passagem -->



            <!-- Noticias do site -->
            <div id="news">
                <div id="featured" >
                    <ul class="ui-tabs-nav">
                        <li class="ui-tabs-nav-item ui-tabs-selected" id="nav-fragment-1"><a href="#fragment-1"><img src="img/image1-small.jpg" alt="" /><span>Goiânia é uma das melhores cidades brasileiras</span></a></li>
                        <li class="ui-tabs-nav-item" id="nav-fragment-2"><a href="#fragment-2"><img src="img/image2-small.jpg" alt="" /><span>Laser nas rodovias catarinenses</span></a></li>
                        <li class="ui-tabs-nav-item" id="nav-fragment-3"><a href="#fragment-3"><img src="img/image3-small.jpg" alt="" /><span>Em 2020, SP terá frota de 8 milhões</span></a></li>
                        <li class="ui-tabs-nav-item" id="nav-fragment-4"><a href="#fragment-4"><img src="img/image4-small.jpg" alt="" /><span>Frota de ônibus de SP </span></a></li>
                    </ul>
                    <!-- First Content -->
                    <div id="fragment-1" class="ui-tabs-panel" style="">
                        <img src="img/image1.jpg" alt="" />
                        <div class="info" >
                            <h2><a href="#" >Goiânia é uma das melhores cidades brasileiras</a></h2>
                            <p>Goiânia é considerada a 2ª melhor capital brasileira... <a href="#" >read more</a></p>
                        </div>
                    </div>

                    <!-- Second Content -->
                    <div id="fragment-2" class="ui-tabs-panel ui-tabs-hide" style="">
                        <img src="img/image2.jpg" alt="" />
                        <div class="info" >
                            <h2><a href="#" >Laser nas rodovias catarinenses</a></h2>
                            <p>Nova técnica de aplicações de laser para projetos rodoviários (para definir a topografia do solo)...<a href="#" >read more</a></p>
                        </div>
                    </div>

                    <!-- Third Content -->
                    <div id="fragment-3" class="ui-tabs-panel ui-tabs-hide" style="">
                        <img src="img/image3.jpg" alt="" />
                        <div class="info" >
                            <h2><a href="#" >Em 2020, SP terá frota de 8 milhões</a></h2>
                            <p>Previsão de especialista só será mudada com investimento urgente em transporte público...<a href="#" >read more</a></p>
                        </div>
                    </div>

                    <!-- Fourth Content -->
                    <div id="fragment-4" class="ui-tabs-panel ui-tabs-hide" style="">
                        <img src="img/image4.jpg" alt="" />
                        <div class="info" >
                            <h2><a href="#" >Frota de ônibus de SP </a></h2>
                            <p>Frota de ônibus de SP ganha mais 10 veículos movidos a etanol...<a href="#" >read more</a></p>
                        </div>
                    </div>
                </div>                
            </div>

            <!-- Fim das notícias -->

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
