<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<t:genericpage>
	<jsp:attribute name="title">
		Blog portal.
    </jsp:attribute>
	<jsp:attribute name="header">
      <t:uppercase>
      	<h4>Blogs for ${blogger.email}</h4>
      </t:uppercase>
      	<p><a href="<s:url value="/logout"/>">Logout</a></p>
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
                        <th>New blog post</th>
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

		<table class="table">
			<c:forEach items="${postList}" var="post">
				<tr>
					<td><img
							src="<s:url value="/resources/store/test_avatar.png"/>" width="48"
							height="48" /></td>
					<td><a href="<s:url value="/bloggers/${post.blogger.login}"/>">
							${post.blogger.firstName} ${post.blogger.lastName}</a><br /> 
							<c:out value="${post.lastUpdatedDate}" /></td>
				</tr>
				<tr>
					<td colspan="2">${post.content}</td>
				
					</tr>
			</c:forEach>
		</table>
    </jsp:body>

</t:genericpage>
