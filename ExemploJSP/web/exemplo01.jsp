<%-- 
    Document   : exemplo01
    Created on : 19/06/2020, 21:02:47
    Author     : fhcmartins
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%
                float A = 2;
                float B = 3;
                out.print("A * B = " + (A * B));
            %>
        </h1>
    </body>
</html>
