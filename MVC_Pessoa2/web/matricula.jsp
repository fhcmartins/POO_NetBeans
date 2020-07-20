<%-- 
    Document   : matricula
    Created on : 18/07/2020, 01:40:59
    Author     : flavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,pessoa.Matricula"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Matricula</title>
    </head>
    
    <body>
        <h2 align="center">Matricula</h2>
        
        <form method="POST" action="MatriculaServlet">
            <br> Codigo Matricula: <input type="text" name="mcodigo" /><br>
            <br> RA Aluno: <input type="text" name="RA" /><br> 
            <br> Codigo Disciplina: <input type="text" name="codigoDisc" /><br> 
            <br> Semestre: <input type="text" name="semestre" /><br> 
            <br> ano: <input type="text" name="ano" /><br> 
            <br> 
            <!Create, Read, Read All, Update e Delete>
            <div align="center">
                <input type="submit" name="buttonCreate" value="Adicionar" />             
                <input type="submit" name="buttonRead" value="Encontrar" />                          
                <input type="submit" name="buttonReadAll" value="Todos" /> 
                <input type="submit" name="buttonUpdate" value="Altearar" />
                <input type="submit" name="buttonDel" value="Apagar" />                
                <input type="submit" name="buttonVoltar" value="Voltar" />
            </div>
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
