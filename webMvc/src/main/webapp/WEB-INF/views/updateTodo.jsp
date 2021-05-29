<html>
<head>
<title>My Login Page</title>
</head>
<body>

<h1>${errorMessage}</h1>
Please update the selected Todo!!
<br><br>
<form action="/updated-list" method = "post">
<input type="text" name="todoID" value="${UpdateTodo.id}" hidden>
desc : <input type="text" name="NewDesc" value="${UpdateTodo.desc}"><br>
isComplete: <input type="text" name="NewStatus" value="${UpdateTodo.isComplete()}"><br>
WantToDelete: <input type="text" name="deleteIt" value="No"><br>
<input type="submit" value="Submit">
</form> 

</body>
</html>