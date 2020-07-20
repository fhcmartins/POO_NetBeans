<%-- 
    Document   : aluno
    Created on : Jul 4, 2020, 10:48:09 AM
    Author     : flavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,pessoa.Aluno"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JPS Aluno</title>
    </head>
    <body>
        <h2 align="center">Aluno</h2>
        
        <form method="POST" action="AlunoServlet">
            <br> RA: <input type="text" name="RA" /><br>
            <br> RG: <input type="text" name="RG" /><br>
            <br> Nome: <input type="text" name="nome" /><br>
            <br> Email: <input type="text" name="email" /><br>
            <br> Curso: <input type="text" name="curso" /><br>
            <br>
            <!Create, Read, Read All, Update e Delete>
            <div align="center">
                <input type="submit" name="buttonCreate" value="Adicionar" />            
                <input type="submit" name="buttonRead" value="Encontrar" />                         
                <input type="submit" name="buttonReadAll" value="Todos" />
                <input type="submit" name="buttonUpdate" value="Alterar" />
                <input type="submit" name="buttonDel" value="Apagar" />               
                <input type="submit" name="buttonVoltar" value="Voltar" />
            </div>
            <br>
        </form>

        <hr><ol> <%
            @SuppressWarnings("unchecked")
            List<Aluno> alunos = (List<Aluno>)request.getAttribute("alunos");
            if (alunos != null) {
                for (Aluno aluno : alunos) { %>
                    <li> <%= aluno %> </li> <%
                }
            } %>
        </ol><hr>

        <iframe src="http://www.objectdb.com/pw.html?jee-netbeans"
            frameborder="0" scrolling="no" width="100%" height="30"> </iframe>
    </body>
</html>
