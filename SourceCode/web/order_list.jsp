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
            <div class="column_right p-2">
                <div class="w-100 text-center my-1">
                    <h3>List Of Order</h3>
                </div>
                <div class="my-4 container-fluid py-0 align-middle text-center">
                    <span class="px-3">Filter: </span>
                    <input type="text" id="filter_user" class="my-1 mx-3 px-2 w-25" onkeyup="order_filter()" placeholder="Username..">
                    <input type="text" id="filter_product" class="my-1 mx-3 px-2 w-25" onkeyup="order_filter()" placeholder="Product Id..">
                    <button  class="my-1 mx-3 px-2 w-25" onclick="window.print()">Print this page</button>
                </div>
                <table class="table">
                    <thead class="thead-light">
                        <tr>
                            <th class="text-center">Id</th>
                            <th class="text-center">Product</th>
                            <th class="text-center">User</th>
                            <th class="text-center">Value</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    <tbody id="order_table">
                        <c:forEach items="${order_list}" var="order" >
                            <tr>
                                <td class="text-center">${order.id}</td>
                                <td class="text-center">${order.productId}</td>
                                <td class="text-center">${order.username}</td>
                                <td class="text-center">${order.orderValue}</td>
                                <td>${order.orderDate}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page="_footer.jsp"></jsp:include>
        
        <script>
            
            var filter_product = document.getElementById("filter_product");
            var filter_user = document.getElementById("filter_user");
            var order_table = document.getElementById("order_table");
            
            var table_row = order_table.getElementsByTagName("tr");
            
            function order_filter()
            {
                var username = filter_user.value.toUpperCase();
                var productId = filter_product.value.toUpperCase();
                for (var i = 0; i < table_row.length; i++)
                {
                    var td_user = table_row[i].getElementsByTagName("td")[2];
                    var td_product = table_row[i].getElementsByTagName("td")[1];
                    
                    var user_ok = ((td_user.textContent || td_user.innerText).toUpperCase().indexOf(username) > -1);
                    var product_ok = ((td_product.textContent || td_product.innerText).toUpperCase().indexOf(productId) > -1);
                    
                    if (user_ok && product_ok)
                        table_row[i].style.display = "";
                    else
                        table_row[i].style.display = "none";
                }
            }     
        </script>
    </body>
</html>
