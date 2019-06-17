<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
       <meta charset="UTF-8">
       <title>Product List</title>
    </head>
    <body style="display:flex; flex-direction: column;">
        <jsp:include page="_header.jsp"></jsp:include>
        <jsp:include page="_feature.jsp"></jsp:include>
        <div style="background-image: url(images/paper760.png); padding-top: 20px; padding-left: 5%; padding-right: 5%">
            <jsp:include page="_sidebar.jsp"></jsp:include>
            <div class="column_right text-center" style="padding: 10px;">
                <h3>Order details</h3>
                <c:forEach items="${cart_order.product_list}" var="product">
                    <div>You just bought ${product.name} (${product.category})</div>
                </c:forEach>
            </div>
        </div>
        <jsp:include page="_footer.jsp"></jsp:include>
    </body>
    <script>
    </script>
</html>
