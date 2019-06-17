<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>
        <jsp:include page="_feature.jsp"></jsp:include>
        <div style="background-image: url(images/paper760.png); padding-top: 20px; padding-left: 5%; padding-right: 5%">
            <jsp:include page="_sidebar.jsp"></jsp:include>
                <div class="column_right">
                    <h3>Edit Product</h3>
                    <p style="color: red;">${message}</p>
                <c:if test="${not empty product}">
                    <form method="POST" action="ProductEdit" enctype="multipart/form-data">
                        <input type="hidden" name="id" value="${product.id}" />
                        <table class="table table-bordered">
                            <tr>
                                <td>Code</td>
                                <td style="color:red;">${product.id}</td>
                            </tr>
                            <tr>
                                <td>Name</td>
                                <td><input type="text" name="name" value="${product.name}" /></td>
                            </tr>
                            <tr>
                                <td>Price</td>
                                <td><input type="number" name="price" value="${product.price}" /></td>
                            </tr>
                            <tr>
                                <td>Quantity</td>
                                <td><input type="number" name="quantity" value="${product.quantity}" /></td>
                            </tr>
                            <tr>
                                <td>Category</td>
                                <td>
                                    <input type="radio" name="category" value="Book" ${product.category == 'Book' ? 'checked' :''}>Book
                                    <br>
                                    <input type="radio" name="category" value="Electronic" ${product.category == 'Electronic' ? 'checked' :''}>Electronic
                                    <br>
                                    <input type="radio" name="category" value="Toys" ${product.category == 'Toys' ? 'checked' :''}>Toys
                                    <br>
                                    <input type="radio" name="category" value="Hardware" ${product.category == 'Hardware' ? 'checked' :''}>Hardware
                                    <br>
                                    <input type="radio" name="category" value="Music" ${product.category == 'Music' ? 'checked' :''}>Music
                                </td>
                            </tr>
                            <tr>
                                <td>Description: </td>
                                <td>
                                    <textarea name="description" placeholder="Describe product here...">${product.description}</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>Preview Photo: </td>
                                <td><input type="file" name="photo" size="50" accept='image/*'/></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <div class="d-flex align-items-center justify-content-around">
                                        <input type="submit" value="Submit" />
                                        <a href="ProductList">Cancel</a>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </form>
                </c:if>
            </div>
        </div>
        <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>
