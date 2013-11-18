<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="title">
		Error page.
    </jsp:attribute>
	<jsp:attribute name="header">
      <t:uppercase>
      	<h2>Erorr page.</h2>
      </t:uppercase>
    </jsp:attribute>
	<jsp:attribute name="footer">
      	<p>Page Footer block</p>
    </jsp:attribute>
	<jsp:body>
        <P>${errorMessage}</P>
    </jsp:body>

</t:genericpage>