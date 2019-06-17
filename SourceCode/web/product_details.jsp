<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
       <meta charset="UTF-8">
    </head>
    <body style="display:flex; flex-direction: column;">
        <jsp:include page="_header.jsp"></jsp:include>
        <jsp:include page="_feature.jsp"></jsp:include>
        <div style="background-image: url(images/paper760.png); padding-top: 20px; padding-left: 5%; padding-right: 5%">
            <jsp:include page="_sidebar.jsp"></jsp:include>
            <div class="column_right" style="padding: 10px;">
                <p style="color: red;">${message}</p>
                <h3 style="margin-left: 10px">Product Details</h3>
                <hr>
                <div style="display: flex; flex-direction: row">
                    <div style="flex: 2; margin-left: 10px">
                        <div class="d-flex align-items-center">
                            <div style="flex: 1">
                                <div style="font-size: 20px; font-weight: bold">${product.name}</div>
                                <div>- ${product.category}</div>
                            </div>
                            <div>
                                <div>Quantity: ${product.quantity}</div>
                                <div>Price: ${product.price}</div>
                            </div>
                        </div>
                        <hr>
                        <div>${product.description} Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
                    </div>
                    <div style="flex: 1; display: flex; align-items:center; flex-direction: column">
                        <img src="ProductImage?id=${product.id}" style="max-width: 200px; margin-top: 10px; box-shadow: 0px 0px 5px 0px aquamarine;">
                        <div style="max-width: 200px">
                            <c:choose>
                                <c:when test="${sessionScope.user != null}">
                                    <a href="" class="btn btn-info text-light w-100 mt-2">
                                        <i class="fas fa-shopping-bag"></i> BUY NOW
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="" class="btn btn-secondary text-light disabled w-100 mt-2">Login to buy</a>
                                </c:otherwise>
                            </c:choose>
                            <a href="CartAddItem?action=add&id=${product.id}" class="btn btn-outline-info w-100 my-2" role="button">
                                <i class="fas fa-shopping-cart"></i> Add To Cart
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>
