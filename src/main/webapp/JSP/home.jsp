
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<div id="wrapper">
    <h1>
        Admin authorized, do you want to write something on your blog?
    </h1>
    <form method="POST" action="HelloServlet">
            <textarea name="textarea">
            </textarea>
        <input type="submit" name="btn" value="send">
    </form>
</div>
</body>
</html>
