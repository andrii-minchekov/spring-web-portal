<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="title">
		Blog list of ${blogger.email}.
    </jsp:attribute>
	<jsp:attribute name="header">
      <t:uppercase>
      	<h4>Blogs for ${blogger.email}</h4>
      </t:uppercase>
    </jsp:attribute>
	<jsp:attribute name="footer">
      	<p>Page Footer block</p>
    </jsp:attribute>
	<jsp:body>
        <sf:form
			servletRelativeAction="/bloggers/${blogger.login}/createNewPost"
			method="POST" modelAttribute="post">
			<fieldset>
			<table cellspacing="0">
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

		<table class="table" style="float:left" cellspacing="15">
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
					<td>${post.content}
				
					</tr>
			</c:forEach>
		</table>
    </jsp:body>

</t:genericpage>
