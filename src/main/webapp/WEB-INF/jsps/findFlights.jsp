<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Flights</title>
</head>
<body>
<h2>Find Flights</h2>
<form action="findFlight" method="post">
From:<input type="text" name="from"/>
To:<input type="text" name="to"/>
Departure Date:<input type="text" name="departureDate"/>
<input type="Submit" value="Search"/>
</form>
</body>
</html>