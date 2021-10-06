<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Read News</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/news-style.css"/>" />

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/news-read-style.css"/>" />

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Read News</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<table>
				<tbody>

					<tr>
						<th><label>Title:</label></th>
						<th><c:out value="${news.title}"></c:out></th>
					</tr>

					<tr>
						<td><label>Body:</label></td>
						<td><c:out value="${news.body}"></c:out></td>
						<%-- <td><pre id="pre">${news.body}</pre></td> --%>
					</tr>

				</tbody>
			</table>

			<div style=""></div>
			<br>
			<!-- put new button: Delete News -->
			<form action="${pageContext.request.contextPath}/newsDelete" method="GET">
				<button type="submit" name="newsId" value="${news.id}"
					onclick="if (!(confirm('Are you sure you want to delete this news?'))) return false"
					class="add-button">Delete</button>
			</form>

			<%-- <c:url var="deleteLink" value="/newsDelete">
				<c:param name="newsId" value="${news.id}" />
			</c:url>
			<p>
				<a href="${deleteLink}" class="delButton"
					onclick="if (!(confirm('Are you sure you want to delete this news?'))) return false">Delete</a>
			</p> --%>
			<p>
				<a href="list">Back to Newses</a>
			</p>

		</div>
	</div>

</body>
</html>