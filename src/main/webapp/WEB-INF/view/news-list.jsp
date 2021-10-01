<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
					<c:url var="updateLink" value="/news/showFormForUpdate">
						<c:param name="newsId" value="${tempNews.id}" />
					</c:url>

					<!-- construct an "delete" link with news id -->
					<c:url var="readLink" value="/news/readNews">
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