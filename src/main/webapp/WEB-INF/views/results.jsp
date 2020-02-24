<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
<head>
<style>
.largeBox {
	background-color: lightgrey;
	width: 60%;
	border: 10px solid green;
	padding: 5%;
	margin: 10%;
}
.picBox{
	background-color: lightgrey;
	width: 50%;
	border: 5px solid green;
	padding: 5%;
	margin: 15%;
}

.alcoholPic {
	width: 100%;
	height: 100%:
}

.pic {
	width: 100%;
	height: 20%;
}
.name {
	background-color: lightgrey;
	width: 60%;
	border: 10px solid blue;
	padding: 5%;
	margin: 10%;
}
.descr{
	background-color: lightgrey;
	width: 60%;
	border: 10px solid green;
	padding: 5%;
	margin: 10%;

}
.comment{
	background-color: lightgrey;
	width: 60%;
	border: 10px solid orange;
	padding: 5%;
	margin: 10%;

}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Results</h1>
	<form action="searchAgain">
      <input type="text" placeholder="Search.." name="alcohol">
      <button type="submit">Search</button>
    </form>

	<c:forEach var="alcohol" items="${alc}">

		<div class="largeBox">
		<div class="picBox">
			<div class="pic">
				<c:choose>
					<c:when test="${alcohol.pic != null}">
						<img src="${alcohol.pic }" class="alcoholPic">
					</c:when>
					<c:otherwise>
						<img src="broken_image.jpg" class="alcoholPic">
					</c:otherwise>
				</c:choose>

			</div>
			</div>
			<c:choose>
					<c:when test="${alcohol.userId  != null}">
						<div><a href="userPage?id=${alcohol.userId }">User page</a></div>
					</c:when>
					<c:otherwise>
						<div></div>
					</c:otherwise>
				</c:choose>
			
			
			
			<div class="name"><H2>${alcohol.name }</H2></div>
		
			<div class="descr">${alcohol.description}</div>
			Star:${alcohol.getRating(alcohol.id) }
			Likes:${alcohol.getLikes(alcohol.id) }
			<div class="comment">${alcohol.comments }
			</div>
		</div>
	</c:forEach>
</body>
</html>