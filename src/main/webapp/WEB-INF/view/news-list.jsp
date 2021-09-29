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

			<!-- put new button: Add Customer -->

			<input type="button" value="Add News"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<!--  add our html table here -->

			<table>
				<tr>
					<th>Title</th>
					<th>Brief</th>
					<th>Body</th>
					<th>Operation</th>
				</tr>

				<!-- loop over and print our news -->
				<c:forEach var="tempNews" items="${newses}">

					<!-- construct an "update" link with news id -->
					<c:url var="updateLink" value="/news/showFormForUpdate">
						<c:param name="newsId" value="${tempNews.id}" />
					</c:url>

					<!-- construct an "delete" link with news id -->
					<c:url var="deleteLink" value="/news/newsDelete">
						<c:param name="newsId" value="${tempNews.id}" />
					</c:url>

					<tr>
						<td>${tempNews.title}</td>
						<td>${tempNews.brief}</td>
						<td><pre id="pre">${tempNews.body}</pre></td>

						<td>
							<!-- display the update link --> 
							<a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this news?'))) return false">Delete</a>
						</td>

					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>