<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>

<div style="width: 100%; display: flex; flex-direction: row; flex-wrap: wrap; justify-content:center;">
    <c:forEach items="${list}" var="product" >
        <div class="product" style="background-color: white; padding: 10px; border-radius: 5px; box-shadow: 0px 0px 5px 0px blue; display: flex; flex-direction: column; align-items: center; justify-content:center;">
            <a class="text-center" href="ProductDetails?id=${product.id}">
                <img class="product_view" style="width: 80%; object-fit: contain" src="ProductImage?id=${product.id}" onresize="change_height()"/>
            </a>
            <a href="ProductDetails?id=${product.id}"><span style="font-weight: bold">${product.name}</span></a>
            <span style="color: red">${product.price}</span>
            <a href="CartServlet?action=add&id=${product.id}" class="btn btn-outline-info" role="button">
                <i class="fas fa-shopping-cart"></i> Add To Cart
            </a>
        </div>
    </c:forEach>
</div>
<script>
    function change_height()
    {
        var cw = $('.product_view').width();
        $('.product_view').css({'height':cw+'px'});
    }
    change_height();
</script>