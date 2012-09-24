<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Carro"%>
<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Linha"%>
<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Cidade"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:directive.include file="includes/header.jsp" />
        <title>Cadastro de Viagem</title>
        <script type="text/javascript" src="https://maps.google.com/maps/api/js?sensor=false"></script>
        <script type="text/javascript">
         var distanceService = new google.maps.DistanceMatrixService();

         function calcularDistancia() {
            var origem = $('#origem option:selected').text();
            var destino = $('#destino option:selected').text();
            
            if(origem == "Selecione") {
                alert('Selecione uma origem');
                return;
            }
            if(destino == "Selecione") {
                alert('Selecione um destino');
                return;
            }
            var request = {
                origins:[origem + ", Brasil"],
                destinations:[destino + ", Brasil"],
                travelMode: google.maps.TravelMode.DRIVING
            };
            distanceService.getDistanceMatrix(request, function(result, status) {
                if (status == google.maps.DirectionsStatus.OK) {
                    var distancia = result.rows[0].elements[0].distance.value;
                    $("#distancia").val((distancia/1000).toFixed(0));
                    var duracao = result.rows[0].elements[0].duration.value;
                    $("#duracao").val((duracao/60/60).toFixed(0));
                    calcularPreco();
                } else {
                    alert('Erro ao acessar seriço de cálculo: ' + status);
                }
            });
         }
         function calcularPreco() {
             var distancia = $('#distancia').val();
             if(distancia == null || distancia == "") {
                 alert("A distância deve ser calculada!");
                 return;
             }
             $('#valor').val((distancia * 0.2 + 15).toFixed(2));
         }
         </script>
    </head>
    <body>
        <jsp:include page="includes/topo.jsp" />
        <jsp:directive.include file="includes/mensagens.jsp" />
        <h1>Cadastrar nova viagem</h1>
        <form action="ViagemServlet" method="POST">
            <input type="hidden" name="operacao" value="cadastrar" />
            <p>Linha
                 <select name="linha">
                    <option value="0">Selecione</option>
                    <% List<Linha> linhas = (List<Linha>) request.getAttribute("linhas");
                    
                    for (Linha l : linhas){ %>
                    <option value="<% out.print(l.getId());%>"><%out.print(l.getNome());%></option>  
                    <% } %>  
                </select>
            </p>
            <p>Descrição<input type="text" name="descricao"/></p>
            <p>Cidade Origem <select id="origem" name="origem">
                    <option value="0">Selecione</option>
                    <% List<Cidade> cidades = (List<Cidade>) request.getAttribute("cidades");
                    
                    for (Cidade c : cidades){ %>
                    <option value="<% out.print(c.getId());%>"><%out.print(c.getNome());out.print(", " + c.getEstado());%></option>  
                    <% } %>
                </select></p>
            <p>Cidade Destino <select id="destino" name="destino">
                    <option value="0">Selecione</option>
                    <%                    
                    for (Cidade c : cidades){ %>
                    <option value="<% out.print(c.getId());%>"><%out.print(c.getNome());out.print(", " + c.getEstado());%></option>  
                    <% } %>  
                </select></p>
                
                <p>Distância <input type="text" disabled="disabled" id="distancia" size="6" name="distancia" />&nbsp;KM&nbsp;-&nbsp;<a href="javascript:calcularDistancia();">[Efetuar Cálculos]</a></p>
                <p>Data e hora <input type="text" id="data" name="data" /></p>
                <p>Duração <input type="text" disabled="disabled" id="duracao" size="4" name="duracao"/>&nbsp;horas</p>
                <p>Preço <input type="text" id="valor" name="valor"/></p>
                <p>Carro <select name="carro">
                    <option value="0">Selecione</option>
                    <%                    
                    List<Carro> carros = (List<Carro>) request.getAttribute("carros");
                    
                    for (Carro c : carros){ %>
                    <option value="<% out.print(c.getId());%>"><%out.print(c.getDescricao());%></option>  
                    <% } %>  
                </select></p>
            <p><input type="submit" value="Salvar" /></p>
        </form>
        <jsp:include page="includes/rodape.jsp" />
    </body>
    <script>
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
            $.timepicker.regional['pt-BR'] = {
                timeOnlyTitle: "Escolha o Horário",
                timeText:"Horário",
                hourText:"Hora",
                minuteText:"Minuto",
                secondText:"Segundo",
                millisecText:"Millisegundo",
                currentText:"Agora",
                closeText:"OK"
            };
            $.timepicker.setDefaults($.timepicker.regional['pt-BR']);

           $( "#data" ).datetimepicker($.datepicker.regional[ "pt-BR" ]);
        });
    </script>
</html>
