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
                <div class="w-100 my-3">
                    <h1 class="my-0">Manage User</h1>
                </div>
                <table class="table">
                    <thead class="thead-light">
                        <tr>
                            <th>Name</th>
                            <th>Password</th>
                            <th class="text-center">Administrator</th>
                            <th class="text-center">Active</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="user" >
                            <tr>
                                <td>${user.name}</td>
                                <td>${user.password}</td>
                                <td class="text-center">
                                    <input type="checkbox" ${user.isAdmin ? 'checked' :''} disabled/>
                                </td>
                                <td class="text-center">
                                    <input type="checkbox" ${user.isActive ? 'checked' :''} disabled/>
                                </td>
                                <td>
                                    <a href="UserUpdate?name=${user.name}" class="btn btn-outline-info">
                                        <i class="far fa-edit"></i> Edit
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>
