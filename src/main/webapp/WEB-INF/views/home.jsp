<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<t:genericpage>
	<jsp:attribute name="title">
		Home page.
    </jsp:attribute>
	<jsp:attribute name="header">
      <t:uppercase>
        <a href="signup">Sign Up</a>
        <a href="signin">Sign in</a>
        <a href="posts">All posts</a>
      	<h4>Welcome to Developers portal.</h4>
      	The time on the server is ${serverTime}.
      </t:uppercase>
    </jsp:attribute>
	<jsp:attribute name="footer">
      	<p>Page Footer block</p>
    </jsp:attribute>
	<jsp:body>
		<security:authorize ifAnyGranted="ROLE_USER">
                    <sf:form
                        servletRelativeAction="/bloggers/${blogger.login}/createNewPost"
                        method="POST" modelAttribute="post">
                        <fieldset>
                        <table>
                            <tr>
                                <th>Author: <security:authentication property="principal.username"></security:authentication></th>
                            </tr>
                            <tr>
                                <th><label for="title">Enter title:</label></th>
                                <td><sf:input path="title" id="title" size="64" /> <sf:errors
                                            path="title" cssClass="error" /></td>
                            </tr>
                            <tr>
                                <th><label for="content">Content:</label></th>
                                <td><sf:textarea path="content" id="content" cols="64" /> <sf:errors
                                            path="content" cssClass="error" /></td>
                            </tr>

                            <tr>
                                <th></th>
                                <td><input name="commit" type="submit" value="Create post" /></td>
                            </tr>
                        </table>
                        </fieldset>
                    </sf:form>
                </security:authorize>
    </jsp:body>

</t:genericpage>