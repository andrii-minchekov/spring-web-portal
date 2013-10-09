<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<h2>Blogs for ${blogger.email}</h2>
	<table cellspacing="15">
		<c:forEach items="${postList}" var="post">
			<tr>
				<td><img
					src="<s:url value="/resources/images/spitter_avatar.png"/>"
					width="48" height="48" /></td>
				<td><a href="<s:url value="/bloggers/${post.blogger.email}"/>">
						${post.blogger.username}</a> <c:out value="${post.text}" /><br /> 
					<c:out value="${post.when}" />
				</td>
			</tr>
		</c:forEach>
	</table>
</div>