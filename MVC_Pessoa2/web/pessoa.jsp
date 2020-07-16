<%-- 
    Document   : pessoa
    Created on : Jul 3, 2020, 11:49:08 PM
    Author     : flavi
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*,pessoa.Pessoa"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2 align="center">Pessoa</h2>
        <form method="POST" action="PessoaServlet">
            <br> RG: <input type="text" name="RG" /><br>
            <br> Nome: <input type="text" name="nome" /><br>
            <br> Email: <input type="text" name="email" /><br>
            <br>
            <!Create, Read, Read All, Update e Delete>
                <input type="submit" name="buttonCreate" value="Adicionar" />            
                <input type="submit" name="buttonRead" value="Encontrar" />                         
                <input type="submit" name="buttonReadAll" value="Todos" />
                <input type="submit" name="buttonUpdate" value="Altearar" />
                <input type="submit" name="buttonDel" value="Apagar" />               
                <input type="submit" name="buttonVoltar" value="Voltar" />
            <br>
        </form>

        <hr><ol> <%
            @SuppressWarnings("unchecked")
            List<Pessoa> pessoas = (List<Pessoa>)request.getAttribute("pessoas");
            if (pessoas != null) {
                for (Pessoa pessoa : pessoas) { %>
                    <li> <%= pessoa %> </li> <%
                }
            } %>
        </ol><hr>

        <iframe src="http://www.objectdb.com/pw.html?jee-netbeans"
            frameborder="0" scrolling="no" width="100%" height="30"> </iframe>
    </body>
</html>
