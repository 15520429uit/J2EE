<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="column_left sidebar" style="min-height: 100px; padding: 10px; display: flex; flex-direction: column">
    <div class="main">Category</div>
    <a href="index.jsp?category=Electronic" class="${param.category == 'Electronic' ? "active" :''}">Electronic</a>
    <a href="index.jsp?category=Music" class="${param.category == 'Music' ? "active" :''}">Music</a>
    <a href="index.jsp?category=Toys" class="${param.category == 'Toys' ? "active" :''}">Toys</a>
    <a href="index.jsp?category=Book" class="${param.category == 'Book' ? "active" :''}">Book</a>
    <a href="index.jsp?category=Hardware" class="${param.category == 'Hardware' ? "active" :''}">Hardware</a>
    <c:if test="${sessionScope.admin != null}">
        <div class="main">Management</div>
        <a href="Restocking">Re-stocking</a>
        <a href="ProductList">Manage Product</a>
        <a href="UserList">Manage User</a>
        <a href="OrderList">Orders List</a>
    </c:if>
</div>