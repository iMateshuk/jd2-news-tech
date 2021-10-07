<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<title>Save News</title>

	<link rel="stylesheet" type="text/css" 
	href="<c:url value="/resources/css/news-style.css"/>" />
	
	<link rel="stylesheet" type="text/css" 
	href="<c:url value="/resources/css/news-dop-style.css"/>" />
	
	
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>User Registration</h2>
		</div>
	</div>

	<div id="container">
		<h3>User form</h3>
	
		<form:form action="saveUser" modelAttribute="user" method="POST">
		
			<table>
				<tbody>
					<tr>
						<td><label>User name:</label></td>
						<td><form:input path="username" /></td>
					</tr>
				
					<tr>
						<td><label>Password:</label></td>
						<td><form:password path="password"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Submit" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="list">Back to Newses</a>
		</p>
	
	</div>

</body>

</html>










