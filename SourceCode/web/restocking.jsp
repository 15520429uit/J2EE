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
                <h3 style="margin-left: 10px">Products Re-stocking</h3>
                <hr>
                <form method="POST" action="Restocking">
                <div style="display: flex; flex-direction: row">
                    <div class="d-flex flex-column" style="flex: 2; margin-left: 10px">
                        <div>Mã sản phẩm nhập:</div>
                        <div>
                            <select id="select" onchange="select_product()" name="product_id" required>
                                <option value=""></option>
                                <c:forEach items="${list}" var="product" >
                                    <option value="${product.id}">${product.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>Số lượng nhập:</div>
                        <div>
                            <input type="number" name="so_luong_nhap" min="0" onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57" required/>
                        </div>
                        <div>
                            <input type="submit" class="my-2">
                        </div>
                    </div>
                    <div style="flex: 1" class="d-flex align-items-center flex-column">
                        <img id="image" style="max-width: 200px; margin-top: 10px; box-shadow: 0px 0px 5px 0px aquamarine;">
                        <div id="so_luong_ton" class="my-1">
                        </div>
                    </div>
                </div>
                </form>
            </div>
        </div>
        <jsp:include page="_footer.jsp"></jsp:include>
    </body>
    
    <script>
        var image = document.getElementById('image');
        var select = document.getElementById('select');
        var so_luong_ton = document.getElementById('so_luong_ton');
        var list = [];
        <c:forEach items="${list}" var="product" >
            var product = 
            {
                id: ${product.id},
                quantity: ${product.quantity}
            };
            list.push(product);
        </c:forEach>
        console.log(list);
                
        function select_product()
        {
            image.src = "ProductImage?id=" + select.value;
            so_luong_ton.innerHTML = "Số lượng tồn: " + list.find(x => x.id == select.value).quantity;
        }
    </script>
</html>
