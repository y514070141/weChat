<html>
<body>
<script src='http://res.wx.qq.com/open/js/jweixin-1.2.0.js'></script>
<h2>Hello World!</h2>
        <%
           String code =  request.getParameter("code");
           String state =  request.getParameter("state");
        %>
<form action="wx/loginOpen.action" method="post">
    <p>First name: <input type="text" name="code" value="<%= code%>"/></p>
    <p>Last name: <input type="text" name="state" value="<%= state%>"/></p>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
