<jsp:doBody var="theBody"/>

<% 
String bc = (String) jspContext.getAttribute("theBody");
%>

<%= bc.toUpperCase() %>