<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Details</title>
</head>
<body>
<h2>Flight Details</h2>
Flight Number:${flight.flightNumber}<br/>
Operating Airlines:${flight.operatingAirlines}<br/>
Departure City:${flight.departureCity}<br/>
Arrival City:${flight.arrivalCity}<br/>
Departure Date:${flight.dateOfDeparture}
<h2>Enter Passenger Details</h2>
<form action="confirmReservation" method="post">
<pre>
First Name<input type="text" name="firstName"/>
Last Name<input type="text" name="lastName"/>
Middle Name<input type="text" name="middleName"/>
Email<input type="text" name="email"/>
Phone<input type="text" name="phone"/>
<input type="hidden" name="flightId" value="${flight.id}"/>
<h2>Enter Payment Details</h2>
Name On The Card<input type="text" name="cardHolderName"/>
Card Number <input type="text" name="cardNumber"/>
Cvv <input type="text" name="cvvCode"/>
Expiry Date<input type="text" name="expiryDate"/>
<input type="submit" value="completeReservation"/>
</pre>
</form>
</body>
</html>