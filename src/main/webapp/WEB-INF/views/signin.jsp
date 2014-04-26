<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="title">
		Sign in page.
    </jsp:attribute>
	<jsp:attribute name="header">
      <t:uppercase>
      	<h2>Sign in.</h2>
      </t:uppercase>
    </jsp:attribute>
	<jsp:attribute name="footer">
      	<p>Page Footer block</p>
    </jsp:attribute>
	<jsp:body>
       <sf:form method="Post" servletRelativeAction="/signin_check">
			<fieldset>
				<table>
					<tr>
						<th><label for="email">Email:</label></th>
						<td><input type="text" id="email" name="email"/>
						<p class="error">${errorMessage}</p>
						</td>
					</tr>
					<tr>
						<th><label for="password">Password:</label></th>
						<td><input type="password" name="password" id="password" />
						</td>
					</tr>
					<tr>
						<td><input name="commit" type="submit"
								value="Login" /></td>
					</tr>
				</table>
			</fieldset>
		</sf:form>
    </jsp:body>

</t:genericpage>