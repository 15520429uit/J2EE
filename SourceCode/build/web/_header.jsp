<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns:h="http://java.sun.com/jsf/html">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>15520429 - 15520353</title>
    </head>
    <jsp:useBean id="cart" scope="session" class="bean.Cart"/>
    <header>
        <div class="bg-dark" style="display:flex; align-items:center; height:100%; background:green; flex-direction: row; box-shadow: 0px 5px 5px 0px rgba(0,0,0,0.25);">
            <div style="flex: 1; display:flex; align-items:center; flex-direction: row">
                <nav class="navbar navbar-expand-sm bg-dark" style="margin-left: 20px">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">...</a>
                        </li>
                        <c:if test="${sessionScope.user == null}">
                            <li class="nav-item">
                                <a class="nav-link" href="Register">Sign Up</a>
                            </li>
                        </c:if>
                        <li class="nav-item">
                            <a class="nav-link" href="cart_list.jsp"><i class="fas fa-shopping-cart"></i> (${cart.size()})</a>
                        </li>
                    </ul>
                 </nav>
            </div>
            <%
                if(session.getAttribute("user") == null)
                { 
            %>
                    <form action="Login" method="post" style="padding:10px;">
                        <div class="text-danger" style="float:left; margin-top: 8px;">${header_message}</div>
                        <div class="input-group" style="float:left; width:200px; margin-left:10px; margin-right:5px">
                            <div class="input-group-append">
                                <span class="input-group-text"><i class="fas fa-user"></i></span>
                            </div>
                            <input class="form-control" type="text" name="username" placeholder="Username"/>
                        </div>
                        <div class="input-group" style="float:left; width:200px; margin-left:5px; margin-right:5px">
                            <div class="input-group-append">
                                <span class="input-group-text"><i class="fas fa-key"></i></span>
                            </div>
                            <input class="form-control" type="password" name="password" placeholder="Password"/>
                        </div>
                        <input type="submit" class="btn" value="Login" style="margin-left:10px; margin-right:10px"/>
                    </form>
            <%  
                }
                else 
                {
            %>
                    <div class="text-danger mx-3" style="float:left;">${header_message}</div>
                    <div style="float: right; display:flex; align-items:center;  flex-direction: row-reverse">
                        <a class="nav-link" href="Logout" style="float: right">Logout</a>
                        <p class="text-light" style="margin-bottom:0px; float:right">Hello World! ${user}</p>
                    </div>
            <%
                }
                if(session.getAttribute("header_message") != null)
                    session.removeAttribute("header_message");
            %>
        </div>
    </header>
</html>
