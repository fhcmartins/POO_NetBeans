<%-- 
    Document   : disciplina
    Created on : 14 de jul de 2020, 23:30:02
    Author     : flavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,pessoa.Disciplina"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Disciplina</title>
    </head>
    <body>
        <h1 align="center">Disciplina</h1>

        <form method="POST" action="DisciplinaServlet">
            <br> Codigo: <input type="text" name="codigo" /><br>
            <br> Matricula Professor: <input type="text" name="matricula" /><br>
            <br> Nome: <input type="text" name="nome" /><br>
            <br> Semestre: <input type="text" name="semestre" /><br>
            <br> Curso: <input type="text" name="curso" /><br>
            <br> HorasAula: <input type="text" name="horasAula" /><br>
            <br> Ementa: <input type="text" name="ementa" /><br>
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
            List<Disciplina> disciplinas = (List<Disciplina>)request.getAttribute("disciplinas");
            if (disciplinas != null) {
                for (Disciplina disciplina : disciplinas) { %>
                    <li> <%= disciplinas %> </li> <%
                }
            } %>
        </ol><hr>

        <iframe src="http://www.objectdb.com/pw.html?jee-netbeans"
            frameborder="0" scrolling="no" width="100%" height="30"> </iframe>

    </body>
</html>
