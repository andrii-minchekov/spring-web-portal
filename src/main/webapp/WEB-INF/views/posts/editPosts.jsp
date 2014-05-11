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
	<h4>Edit your posts.</h4>
    </jsp:attribute>
	<jsp:attribute name="footer">
      	<p>Page Footer block</p>
    </jsp:attribute>
	<jsp:body>
	    <jsp:include page="/WEB-INF/views/posts/addNewPost.jsp" />

		<table class="table">
			<c:forEach items="${postList}" var="post">
				<tr>
					<td><img
							src="<s:url value="/resources/store/test_avatar.png"/>" width="48"
							height="48" /></td>
					<td><a href="<s:url value="/bloggers/${post.blogger.login}"/>">
							${post.blogger.firstName} ${post.blogger.lastName}</a><br /> 
							<c:out value="${post.lastUpdatedDate}" />
					</td>
					<td>
                        <security:authorize ifAnyGranted="ROLE_USER">
                            <sf:form
                                servletRelativeAction="/posts/${post.id}" method="DELETE">
                                    <input name="Delete" type="submit" value="Delete post" />
                            </sf:form>
                        </security:authorize>
                    </td>
				</tr>
				<tr>
					<td colspan="3">${post.content}</td>
			    </tr>
			</c:forEach>
		</table>
    </jsp:body>

</t:genericpage>
