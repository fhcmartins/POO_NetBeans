<%-- 
    Document   : result
    Created on : 19/06/2020, 21:43:22
    Author     : fhcmartins
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8" import="java.util.List, beer.BeerExpert" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Beer Select Result</title>
    </head>
    <body>
        <h1>Beer Recommendations</h1>
            
        <form action="beerSelect" method="post">
            Select beer color:
            <select name="estilo" size="1">
                <option>American Brown Ale</option>
                <option>Belgian Blond Ale</option>
                <option>Lambic Fruit</option>
                <option>Witbier</option>
            </select>
            <input type="submit"/>
            
            <br>
            
            <%
                List<String> brands = (List<String>)request.getAttribute("brands");

                if(brands != null){
                    if(!brands.isEmpty()){
                        for(int i = 0; i < brands.size(); i++){
                            out.println(brands.get(i));
                        }
                    }
                }
            %>
            
        </form>
        
    </body>
</html>