<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>

<title>Newses</title>

<!-- reference our style sheet -->

<link rel="stylesheet" type="text/css" 
href="<c:url value="/resources/css/news-style.css"/>">

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Newses</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- put new button: Add News -->
			<input type="button" value="Add News"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<sec:authentication var="userPrincipal" property="principal" />
			<!-- put new button: Login in portal -->
			<c:if test="${userPrincipal == 'anonymousUser'}">
				<input type="button" value="Login"
					onclick="window.location.href='login'; return false;"
					class="add-button" />

				<!-- <input type="button" value="Registration"
					onclick="window.location.href='showFormForAddUser'; return false;"
					class="add-button" /> -->
			</c:if>

			<!-- put new button: Logout in portal -->
			<c:if test="${userPrincipal != 'anonymousUser'}">
				<input type="button" value="Logout" 
					onclick="window.location.href='logout'; return false;"
					class="add-button" />
			</c:if>

			<!--  add our html table here -->

			<table>
				<tr>
					<th>Title</th>
					<th>Brief</th>
					<th></th>
					<th></th>
				</tr>

				<!-- loop over and print our news -->
				<c:forEach var="tempNews" items="${newses}">

					<!-- construct an "update" link with news id -->
					<c:url var="updateLink" value="/showFormForUpdate">
						<c:param name="newsId" value="${tempNews.id}" />
					</c:url>

					<!-- construct an "delete" link with news id -->
					<c:url var="readLink" value="/readNews">
						<c:param name="newsId" value="${tempNews.id}" />
					</c:url>

					<tr>
						<td><c:out value="${tempNews.title}"></c:out></td>
						<td><c:out value="${tempNews.brief}"></c:out></td>
						<td><a href="${readLink}">Read</a></td>
						<td><a href="${updateLink}">Update</a></td>

					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>