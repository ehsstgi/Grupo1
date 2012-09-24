<%-- 
    Document   : mensagens
    Created on : Apr 4, 2012, 9:10:49 PM
    Author     : leonardo.rafaeli
--%>

<%@page import="br.com.mackenzie.fci.si.pi2.cr.web.MessageUtils"%>
<p>
    <%
       out.println(MessageUtils.convertMessages(request));
    %>
</p>
