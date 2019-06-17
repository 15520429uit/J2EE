<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:h="http://java.sun.com/jsf/html" style="height: 100%">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body style="display:flex; flex-direction: column;">
        <jsp:include page="_header.jsp"></jsp:include>
        <jsp:include page="_feature.jsp"></jsp:include>
        <div style="background-image: url(images/paper760.png); padding-top: 20px; padding-left: 5%; padding-right: 5%">
            <jsp:include page="_sidebar.jsp?category=${param.category}"></jsp:include>
            <div class="column_right" style="padding: 10px;">
                <jsp:include page="ProductShow?category=${param.category}"></jsp:include>
            </div>
        </div>
        <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>