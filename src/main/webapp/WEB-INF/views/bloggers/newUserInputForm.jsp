<%@ taglib prefix = "sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content=""/>
    <meta name="author" content="aminchekov"/>

    <title>Developer's portal</title>

    <link href=<c:url value="/resources/css/bootstrap.min.css"/> rel="stylesheet">
    </link>
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
 </head>
<div>
	<h2>Create a free Blog account</h2>
	<sf:form method="POST" modelAttribute="blogger" enctype="multipart/form-data">
		<fieldset>
			<table cellspacing="0">
				<tr>
					<th><label for="firstName">First name:</label></th>
					<td><sf:input path="firstName" size="15" id="firstName" />
					<sf:errors path="firstName" classClass="error" />
					</td>
				</tr>
				<tr>
					<th><label for="lastName">Last name:</label></th>
					<td><sf:input path="lastName" size="15" id="lastName" />
					<sf:errors path="lastName" classClass="error" />
					</td>
				</tr>
				<tr>
					<th><label for="user_email">EmailAddress:</label></th>
					<td><sf:input path="email" size="30" id="user_email" /> <small>In
							case you forget something</small> <sf:errors path="email"
							cssClass="error" /></td>
				</tr>
				<tr>
					<th><label for="login">Login:</label></th>
					<td><sf:input path="login" size="30" id="login" /> <small></small> <sf:errors path="login"
							cssClass="error" /></td>
				</tr>
				<tr>
					<th><label for="user_password">Password:</label></th>
					<td><sf:password path="password" size="30" showPassword="true"
							id="user_password" /> <small>2 characters or more(be
							tricky!)</small> <sf:errors path="password" cssClass="error" /></td>
				</tr>

				<tr>
					<th></th>
					<td><sf:checkbox path="updateByEmail"
							id="user_send_email_newsletter" /> <label
						for="user_send_email_newsletter">Send me email updates!</label></td>
				</tr>
				<tr>
					<th><label for="image">Profile image:</label></th>
					<td><input name="image" type="file" />
				</tr>
				<tr>
					<th></th>
					<td><input name="commit" type="submit"
						value="Create my account" /></td>
				</tr>

			</table>
		</fieldset>
	</sf:form>
</div>