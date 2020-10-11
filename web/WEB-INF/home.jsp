<%-- 
    Document   : home
    Created on : Oct 8, 2020, 8:27:57 PM
    Author     : 829942
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <div style="font-weight: bold;">
            Hello <%=request.getSession(false).getAttribute("sessionUserName")%>.
        </div>
        <div><a href="login?logout=1">Log out</a></div>
    </body>
</html>
