<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:genericpage>
	<jsp:attribute name="title">
		Session Timeout.
    </jsp:attribute>
	<jsp:attribute name="header">
      <t:uppercase>
      	<h2>Invalid Session</h2>
      </t:uppercase>
    </jsp:attribute>
	<jsp:attribute name="footer">
      	<p>Page Footer block</p>
    </jsp:attribute>
	<jsp:body>
        <P>Your session appears to have timed out. Please <a href="<c:url value="/" />">start again</a>.</P>
    </jsp:body>

</t:genericpage>
