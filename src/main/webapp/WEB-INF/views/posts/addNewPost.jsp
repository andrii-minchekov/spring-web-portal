<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<sec:authorize ifAnyGranted="ROLE_USER">
    <sf:form
        servletRelativeAction="/posts"
        method="POST" modelAttribute="post">
        <fieldset>
        <table>
            <tr>
                <th>Create Post</th>
            </tr>
            <tr>
                <th><label for="title">Enter title:</label></th>
                <td><sf:input path="title" id="title" class="input-xxlarge"/> <sf:errors
                            path="title" cssClass="error" /></td>
            </tr>
            <tr>
                <th><label for="content">Content:</label></th>
                <td><sf:textarea path="content" id="content" class="input-xxlarge" /> <sf:errors
                            path="content" cssClass="error" /></td>
            </tr>

            <tr>
                <th></th>
                <td><input name="commit" type="submit" value="Create post" /></td>
            </tr>
        </table>
        </fieldset>
    </sf:form>
</sec:authorize>