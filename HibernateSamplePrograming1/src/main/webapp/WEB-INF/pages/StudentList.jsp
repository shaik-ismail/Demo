<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%--TagLibraries--%>
<%--Spring form TL--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--Core Tags--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--Formatting Tags--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--JSTL Functions--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--Spring message form TL--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form>
		<table>
			<c:forEach items="${commonVO}" var="alt">
				<tr>
					<td>${alt.Emp_ID}</td>
					<td>${alt.Emp_Address}</td>
					<td>${alt.Emp_Age}</td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>