<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	function fun(id) {
		document.CommonVo.method = 'GET';
		document.CommonVo.action = 'Allstudent';
		document.CommonVo.buttonValue.value = id;
		document.CommonVo.submit();

	}
</script>
</head>
<body>
	<form:form modelAttribute="CommonVo" name="CommonVo" commandName="CommonVo">
		<table border="2" align="center">
			<tr>
				<td><spring:message code="lbl.stdId"></spring:message></td>
				<td><form:input path="Stdid" /></td>
			</tr>
			<tr>
				<td><spring:message code="lbl.stdName"></spring:message></td>
				<td><form:input path="StdName" /></td>
			</tr>
			<tr>
				<td><spring:message code="lbl.stdGender"></spring:message></td>
				<td><form:input path="Stdgender" /></td>
			</tr>
			<tr>
				<td><button id="button" onclick="fun('ADD')">Submit</button></td>
				<td><button id="button" onclick="fun('LIST')">LIST</button></td>
			</tr>
		</table>
		<input type="hidden" name="buttonValue">
	</form:form>
</body>
</html>