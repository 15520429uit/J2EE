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
                <h3>Edit User</h3>
                <p style="color: red;">${message}</p>
                <form method="POST" action="UserUpdate">
                    <input type="hidden" name="name" value="${user_edit.name}" />
                    <table class="table table-bordered">
                        <tr>
                            <td>Name</td>
                            <td style="color:red;">${user_edit.name}</td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td>
                                <input type="text" name="password" value="${user_edit.password}" />
                            </td>
                        </tr>
                        <tr>
                            <td>Is Administrator: </td>
                            <td>
                                <input type="checkbox" name="is_admin" ${user_edit.isAdmin ? 'checked' :''} />
                            </td>
                        </tr>
                        <tr>
                            <td>Is Active: </td>
                            <td>
                                <input type="checkbox" name="is_active" ${user_edit.isActive ? 'checked' :''} />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <div class="d-flex align-items-center justify-content-around">
                                    <input type="submit" value="Submit" />
                                    <a href="UserList">Cancel</a>
                                </div>
                            </td>
                        </tr>
                    </table>
                </form>
            <div>
        </div>
        <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>
