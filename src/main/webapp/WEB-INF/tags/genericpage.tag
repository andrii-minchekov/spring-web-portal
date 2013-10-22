<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="title" fragment="true"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>

<html>
<head>
<%@include file="metacss.tagf"%>
<title><jsp:invoke fragment="title" /></title>
</head>
<body>
	<div id="pageheader">
		<jsp:invoke fragment="header" />
	</div>
	<div id="body">
		<jsp:doBody />
	</div>
	<div id="pagefooter">
		<jsp:invoke fragment="footer" />
	</div>
	<%@include file="../views/footer.jsp" %>
	<%-- action <jsp:include page="../views/footer.jsp" /> --%>
</body>
</html>