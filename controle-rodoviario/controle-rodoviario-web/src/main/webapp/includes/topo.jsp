<%@page import="br.com.mackenzie.fci.si.pi2.cr.entity.Usuario"%>
<div class="limite">
    <!-- Topo da página -->
    <div id="top">
        <div class="margem">
            Auto Via&ccedil;&atilde;o Mackenzie
        </div>
    </div>
    <!-- Fim -->

    <div id="restrito">
        <div class="areaRestrita">
            <table border="0">
                <tr>

                    <% if (session.getAttribute("user") == null) {%>
                    <td>
                        <a href="login.jsp">
                            Efetuar Login
                        </a>
                    </td>
                    <% } else {
                        Usuario usuario = (Usuario) session.getAttribute("user");
                    %>
                    <td>
                        <a href="#">
                            Bem vindo, <% out.println(usuario.getNome());%>
                        </a>
                    </td>
                    <td>
                        <% if (usuario.getPerfil().equalsIgnoreCase("admin")) {%>
                        <a href="indexAdmin.jsp">
                            <img title ="Painel de Controle" src="img/cp.png" height="35" width="35"/>
                        </a>
                        <% }%>
                    </td>
                    <td>
                        <a href="LoginServlet?operacao=logout">
                            <img title ="Logout" src="img/logout.png" height="35" width="35"/>
                        </a>
                    </td>
                    <% }%>
                </tr>
            </table>
        </div>
    </div>

    <div id="conteudo">