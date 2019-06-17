<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="display:flex; flex-direction: column;">
        <jsp:include page="_header.jsp"></jsp:include>
        <div style="display:flex; align-items:center; justify-content:center; flex-direction:row; height:60px">
            <div>${message}</div>
        </div>
        <form action="Register" method="post">
            <div style="display:flex; align-items:center; justify-content:center; flex-direction:column; width:400px; margin-left:auto; margin-right:auto;">
                <h2 style="margin: 20px">Register</h2>
                <table cellpadding="5">
                    <tr>
                        <td>Username:</td>
                        <td><input class="form-control input_user" type="text" name="username"/></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input class="form-control input_user" type="password" name="password"/></td>
                    </tr>
                    <tr>
                        <td>Repeat Password:</td>
                        <td><input class="form-control input_user" type="password" name="re_password"/></td>
                    </tr>
                </table>
                <input type="submit" value="Sign Up" class="btn" style="font-weight:bold; margin:25px; padding-left:20px; padding-right:20px"/>
            </div>
        </form>
        <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>
