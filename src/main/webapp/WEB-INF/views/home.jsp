<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="title">
		Home page.
    </jsp:attribute>
	<jsp:attribute name="header">
      <t:uppercase>
      	<h2>Welcome to Developer's portal.</h2>
      </t:uppercase>
    </jsp:attribute>
	<jsp:attribute name="footer">
      	<p>Page Footer block</p>
    </jsp:attribute>
	<jsp:body>
        <P>The time on the server is ${serverTime}.</P>
		<a href="bloggers/createNewBlogger">Sign Up</a>
    </jsp:body>

</t:genericpage>