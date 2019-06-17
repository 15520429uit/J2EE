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
                <h3>Create Product</h3>
                <p style="color: red;">${message}</p>
                <form method="POST" action="ProductAdd" enctype="multipart/form-data">
                    <table class="product_manage" style="border-collapse: collapse">
                        <tr>
                            <td>Name</td>
                            <td><input type="text" name="name"/></td>
                        </tr>
                        <tr>
                            <td>Price</td>
                            <td><input type="number" name="price"/></td>
                        </tr>
                        <tr>
                            <td>Quantity</td>
                            <td><input type="number" name="quantity"/></td>
                        </tr>
                        <tr>
                            <td>Category</td>
                            <td>
                                <input type="radio" name="category" value="Book">Book<br>
                                <input type="radio" name="category" value="Electronic">Electronic<br>
                                <input type="radio" name="category" value="Toys">Toys<br>
                                <input type="radio" name="category" value="Hardware">Hardware<br>
                                <input type="radio" name="category" value="Music">Music
                            </td>
                        </tr>
                        <tr>
                            <td>Description: </td>
                            <td>
                                <textarea name="description" placeholder="Describe product here..."></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>Preview Photo: </td>
                            <td><input type="file" name="photo" size="50" accept='image/*'/></td>
                        </tr>
                        <tr>
                            <td colspan = "2">
                                <input type="submit" value="Submit" />
                                <a href="ProductList">Cancel</a>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
