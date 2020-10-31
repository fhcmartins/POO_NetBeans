<%-- 
    Document   : Exemplo02
    Created on : 19/06/2020, 21:15:12
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
            <%! long count = 1; %>
            
            <%! 
                long doubleCount(long num){
                    return num *= 2;
                }
            %>
            
            Dobra!
            <br>
            
            <%=
                count = doubleCount(count)
            %>
            
        </h1>
    </body>
</html>
