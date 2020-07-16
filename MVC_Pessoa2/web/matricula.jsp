<%-- 
    Document   : matricula
    Created on : 15 de jul de 2020, 13:07:05
    Author     : flavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,pessoa.Matricula"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2 align="center">Matricula</h2>
        
        <form method="POST" action="MatriculaServlet">
            <br> Código: <input type="text" name="codigo" /><br>
            <br> Disciplina: <input type="text" name="disciplina" /><br>
            <br> Aluno: <input type="text" name="aluno" /><br>
            <br> Data: <input type="text" name="data" /><br>
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
            List<Matricula> matriculas = (List<Matricula>)request.getAttribute("matriculas");
            if (matriculas != null) {
                for (Matricula matricula : matriculas) { %>
                    <li> <%= matricula %> </li> <%
                }
            } %>
        </ol><hr>

        <iframe src="http://www.objectdb.com/pw.html?jee-netbeans"
            frameborder="0" scrolling="no" width="100%" height="30"> </iframe>
    </body>
</html>
