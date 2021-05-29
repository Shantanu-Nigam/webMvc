<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>My Todos Page</title>
</head>
<body>

<h1>${errorMessage}</h1>
Hey There, here are your Todos!!

<br><br>

 <table>
	<thead>
		<tr>
			<td>ID</td>
			<td>OWNER</td>
			<td>DESCRIPTION</td>
			<td>CREATEDOn</td>
			<td>IsCOMPLETE</td>
		</tr>
	</thead>
	<tr>
		<c:forEach items="${Todos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.owner}</td>
						<td>${todo.desc}</td>
						<td>${todo.createdOn}</td>
						<td>${todo.isComplete()}</td>
					</tr>
		</c:forEach>
		<br>
		
	</tr>
</table>
 
 Create New Todo: <a href="/add-todo">Click Here!!</a><br>
 Update your Todo:<br>
 <form method="POST">
 Please provide the todo id: <input type="text" name="idToUpdate">
 <input type="submit" value="Submit">
 </form>

</body>
</html>