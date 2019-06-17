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
            <div class="column_right" style="padding: 10px;">
                <div style="width: 100%">
                    <h3 style="float: left">Cart Items</h3>
                    <c:choose>
                        <c:when test="${sessionScope.user != null}">
                            <a href="Checkout" class="btn btn-outline-success" style="float: right">
                                <i class="fas fa-check"></i><i class="fas fa-shopping-cart"></i> Checkout
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a href="" class="btn btn-secondary text-light disabled" style="float: right">Login to checkout</a>
                        </c:otherwise>
                    </c:choose>
                </div>
                <p style="color: red;">${message}</p>
                <table class="cart_list w-100">
                    <tr>
                        <th>Index</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Remove</th>
                    </tr>
                    <c:forEach items="${cart.product_list}" var="product" varStatus="loop">
                        <tr style="padding-top: 10em">
                            <td style="text-align: center; vertical-align: middle;">${loop.count}</td>
                            <td style="display: flex; flex-direction: row; align-items:center; ">
                                <img style="max-height:125px; max-width:125px; height:auto; width:auto;" src="ProductImage?id=${product.id}">
                                <div style="margin-left: 25px">
                                    <div>${product.name}</div>
                                    <div style="font-size: 16px; font-style: italic"> - ${product.category}</div>
                                </div>
                            </td>
                            <td style="text-align: center; vertical-align: middle;">${product.price}</td>
                            <td style="text-align: center; vertical-align: middle;">
                                <a href="CartServlet?action=remove&index=${loop.count}">
                                    <i class="fas fa-times" style="padding: 10px; padding-top: 8px; padding-bottom: 8px; background-color: red; color: white;"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <jsp:include page="_footer.jsp"></jsp:include>
    </body>
    <script>
    </script>
</html>
