<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>T-Shirt Store</h1>

<form action = "AddTshirt" method = "get">
	Select T-shirt accessories :
	<input type = "checkbox" value = "Belt" name = "access"> Belt
	<input type = "checkbox" value = "Cap" name = "access"> Cap
	<input type = "checkbox" value = "Hairband" name = "access"> Hairband
	
	<br>
	
	T-shirt Tagline :
	<input type = "text" name = "tagline">
	
	<br>
	
	Type of Pocket :
	<input type = "radio" value = "Chest Pocket" name = "pocket"> Chest Pocket
	<input type = "radio" value = "No Chest Pocket" name = "pocket"> No Chest Pocket
	
	<br>
	
	T-shirt color :
	<select name = "color">
		<option>Red</option>
		<option>Blue</option>
		<option>Green</option>
	</select>
	
	<br>
	
	<button type = "submit">Click Me</button>
</form>

<form action = "ViewTshirt" method = "get">
	<button type = "submit">Display All T-shirts</button>
</form>

</body>
</html>