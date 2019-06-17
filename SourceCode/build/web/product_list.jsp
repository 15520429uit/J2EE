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
                <h3>Product List</h3>
                <a href="ProductAdd" class="btn btn-outline-primary">
                    <i class="fas fa-plus-square"></i> Create Product
                </a>
                <p style="color: red;">${message}</p>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th class="text-center align-middle">#</th>
                            <th class="align-middle">Name</th>
                            <th class="text-center align-middle">Price</th>
                            <th class="text-center align-middle">Quantity</th>
                            <th></th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="product" >
                            <tr>
                                <td class="text-center align-middle">${product.id}</td>
                                <td>${product.name}</td>
                                <td class="text-center align-middle">${product.price}</td>
                                <td class="text-center align-middle">${product.quantity}</td>
                                <td class="text-center align-middle">
                                    <a href="ProductEdit?id=${product.id}" class="btn btn-outline-success">
                                        <i class="far fa-edit"></i> Edit
                                    </a>
                                </td>
                                <td class="text-center align-middle">
                                    <button type="button" class="btn btn-outline-danger" onclick="show_modal(${product.id})">
                                        <i class="fas fa-times"></i> Delete
                                    </button>
                                </td>
                                <td class="text-center py-1">
                                    <img class="product_image" style="max-width:50px; max-height:50px;" src="ProductImage?id=${product.id}">
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page="_footer.jsp"></jsp:include>
        
        <div id="modal" class="modal-background">
            <div class="p-3 pt-1 d-flex flex-column bg-light w-25">
                <div class="close text-right" onclick="close_modal()">&times;</div>
                <div class="my-4" id="modal-text"></div>
                <div class="d-flex justify-content-around align-items-center">
                    <button type="button" class="btn btn-outline-danger" onclick="delete_product()">
                        <i class="far fa-save"></i> Submit
                    </button>
                    <button type="button" class="btn btn-outline-secondary" onclick="close_modal()">Cancel</button>
                </div>
            </div>
        </div>
    </body>
    <script>
        
        var modal = document.getElementById("modal");
        var span = document.getElementsByClassName("close")[0];
        var text = document.getElementById("modal-text");
        var product_id = "";
        
        function show_modal(id) 
        {
            product_id = id;
            modal.style.display = "flex";
            text.innerHTML = "Delete Product Id " + product_id;
        }

        function delete_product()
        {
            window.location.href = "ProductDelete?id=" + product_id;
        }

        function close_modal() 
        {
            modal.style.display = "none";
        }
        
        window.onclick = function(event) 
        {
            if (event.target == modal)
                close_modal();
        }
    </script>
</html>
