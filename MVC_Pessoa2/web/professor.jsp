<%-- 
    Document   : professor
    Created on : Jul 4, 2020, 2:32:28 PM
    Author     : flavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,pessoa.Professor"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2 align="center">Professor</h2>
        
        <form method="POST" action="ProfessorServlet">
            <br> RG: <input type="text" name="RG" /><br>
            <br> Matricula: <input type="text" name="matricula" /><br>
            <br> Nome: <input type="text" name="nome" /><br>
            <br> Email: <input type="text" name="email" /><br>
            <br> Titulo <input type="text" name="titulo" /><br>
            <br> Area <input type="text" name="area" /><br>
            <br> Regime: <input type="text" name="regime" /><br>
            
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
            List<Professor> professores = (List<Professor>)request.getAttribute("professores");
            if (professores != null) {
                for (Professor professor : professores) { %>
                    <li> <%= professor %> </li> <%
                }
            } %>
        </ol><hr>

        <iframe src="http://www.objectdb.com/pw.html?jee-netbeans"
            frameborder="0" scrolling="no" width="100%" height="30"> </iframe>
        
    </body>
</html>
