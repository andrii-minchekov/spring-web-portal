<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content=""/>
    <meta name="author" content="aminchekov"/>

    <title>Developer's portal</title>

    <link href=<c:url value="/resources/css/bootstrap.min.css"/> rel="stylesheet"></link>
    <style type="text/css">
        body {
            padding-top: 60px;
            padding-bottom: 40px;
        }

        .sidebar-nav {
            padding: 9px 0;
        }
    </style>
    <!-- See http://twitter.github.com/bootstrap/scaffolding.html#responsive -->
    <link href=<c:url value="/resources/css/bootstrap-responsive.min.css"/> rel="stylesheet">
    </link>

	<title>Home Page</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="bloggers/createNewBlogger">Sign Up</a>
</body>
</html>
