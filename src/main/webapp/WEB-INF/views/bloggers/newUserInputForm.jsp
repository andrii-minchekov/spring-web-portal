<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="title">
		Create account page.
    </jsp:attribute>
	<jsp:attribute name="header">
      <t:uppercase>
      	<h4>Create a free Blog account</h4>
      </t:uppercase>
    </jsp:attribute>
	<jsp:attribute name="footer">
      	<p>Page Footer block</p>
    </jsp:attribute>
	<jsp:body>
		<sf:form method="POST" modelAttribute="blogger"
			enctype="multipart/form-data">
			<fieldset>
				<table>
					<tr>
						<th><label for="firstName">First name:</label></th>
						<td><sf:input path="firstName" size="15" id="firstName" />
						<sf:errors path="firstName" cssClass="error" />
						</td>
					</tr>
					<tr>
						<th><label for="lastName">Last name:</label></th>
						<td><sf:input path="lastName" size="15" id="lastName" />
						<sf:errors path="lastName" cssClass="error" />
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
						<td><sf:input path="login" size="30" id="login" /> <small></small> <sf:errors
									path="login" cssClass="error" /></td>
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
						<td><input name="commit" type="submit"
								value="Create my account" /></td>
					</tr>
	
				</table>
			</fieldset>
		</sf:form>
    </jsp:body>
</t:genericpage>
