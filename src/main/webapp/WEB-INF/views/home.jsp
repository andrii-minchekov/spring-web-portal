<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<t:genericpage>
	<jsp:attribute name="title">
		Home page.
    </jsp:attribute>
	<jsp:attribute name="header">
      	<h4>Welcome to Developers portal.</h4>
      	The time on the server is ${serverTime}.
      <t:uppercase>
      </t:uppercase>
    </jsp:attribute>
	<jsp:attribute name="footer">
      	<p>Page Footer block</p>
    </jsp:attribute>
	<jsp:body>
		<%@include file="posts/addNewPost.jsp"%>
    </jsp:body>

</t:genericpage>