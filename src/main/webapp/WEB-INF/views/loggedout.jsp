<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:genericpage>
	<jsp:attribute name="title">
		Logged Out.
    </jsp:attribute>
	<jsp:attribute name="header">
      <t:uppercase>
      	<h2>Logged Out.</h2>
      </t:uppercase>
    </jsp:attribute>
	<jsp:attribute name="footer">
      	<p>Page Footer block</p>
    </jsp:attribute>
	<jsp:body>
       You have been logged out. <a href="<c:url value="/"/>">Start again</a>.
    </jsp:body>

</t:genericpage>
