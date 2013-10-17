<jsp:doBody var="theBody"/>

<%
String bc = (String) pageContext.getAttribute("theBody");
%>

<%= bc.toUpperCase() %>