<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<!--test1
${user.username}
-->
<!--test2
${orderform.orderformnum}
-->
<!--test3
<img width="256" height="144"src="${user.userImage}" />
-->
<!--test4
登录成功，欢迎你，${user.username}
-->
<!--test5
注册成功，欢迎你，${user.username}
-->
<!--test6
${orderform.username}
-->
<!--test7
-->
<form action="${pageContext.request.contextPath}/order.action" method="post">
    商品名：<br>
    <input type="text" name="shoppingName"><br>
    购买数量：<br>
    <input type="text" name="amount"><br>
    <input type="submit" value="提交">
</form>
${msg}
<!--test7
-->
<!--test8
<img width="50" height="50"src="${user.userImage}" />
<form action="${pageContext.request.contextPath}/modify.action" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" value="${user.username}"></td>
        </tr>
        <tr>
            <td>地址：</td>
            <td><input type="text" name="address" value="${user.address}"></td>
        </tr>
        <tr>
            <td>真实姓名：</td>
            <td><input type="text" name="userName" value="${user.userName}"></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="phone" value="${user.phone}"></td>
        </tr>
        <tr>
            <td>头像</td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="text" name="email" value="${user.email}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
    -->
</body>
</html>
