<%-- 
    Document   : index
    Created on : Jul 4, 2020, 10:17:36 AM
    Author     : flavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2 align="center">INDEX</h2>
        <form align="center" method="POST" action="indexServlet">
            <br>
            <!Create, Read, Read All, Update e Delete>
                <input type="submit" name="buttonPessoa" value="Pessoa" />    
                <input type="submit" name="buttonAluno" value="Aluno" />
                <input type="submit" name="buttonProfessor" value="Prefessor" />
                <input type="submit" name="buttonDisciplina" value="Disciplina" />
            <br>
        </form> 
    </body>
</html>
