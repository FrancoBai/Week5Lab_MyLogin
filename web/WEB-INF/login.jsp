<%-- 
    Document   : login
    Created on : Oct 8, 2020, 8:27:20 PM
    Author     : 829942
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        
        <%
        String errorInfo = (String)request.getAttribute("loginError");
        if(errorInfo != null){
        %>
        <script type="text/javascript" language="javascript">
            alert("<%=errorInfo%>");
        </script>
        <%}%>
        
        <%
        String username = (String)request.getAttribute("username");  
        String password = (String)request.getAttribute("password");
        if(username == null){
            username = "";
        }
        if(password == null){
            password = "";
        }
        %>
        
        
        
        <h1>Login</h1>
        <form method="post" action="">
        <div>
            User Name:<input type="text" name="username" value="<%=username%>"/>
        </div>
        <div>
            Password:<input type="text" name="password" value="<%=password%>"/>
        </div>
        <div>
            <input type="submit" value="Log in"/>
        </div>
        </form>
    </body>
</html>
