<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<sec:authorize var="loggedIn" access="isAuthenticated()" />

<sec:authentication var="principal" property="principal" />
<a href="/">Home</a>
<c:choose>
    <c:when test="${loggedIn}">
    	<a href="/posts">All posts</a>
    	<a href="/posts/blogger/${principal.username}">Edit Posts</a>
    	<a href="/blogger">Edit profile</a>
        <a href="/j_logout">Logout.</a>
        
    </c:when>
    <c:otherwise>
        <a href="/signup">Sign Up</a>
		<a href="/signin">Sign in</a>
		<a href="/posts">All posts</a>
    </c:otherwise>
</c:choose>