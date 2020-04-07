<%--
  Created by IntelliJ IDEA.
  User: paeps
  Date: 7/04/2020
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style/style.css">
    <title>Zoek een film</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="Servlet?command=home">Home</a></li>
            <li><a href="voegToe.jsp">Voeg toe</a></li>
            <li><a href="Servlet?command=overview">Overzicht</a></li>
            <li><a id="current" href="Servlet?command=zoek">Zoek</a></li>
        </ul>
    </nav>
    <h1>Zoek film</h1>
</header>
<main>
    <form method="GET" action="Servlet" novalidate>
        <p>Welke film zoek je?</p>
        <label for="titel">Titel:</label>
        <input type="text" id="titel" name="titel" value="" required>

        <input type="hidden" name="command" value="zoek">

        <label for="zoek"></label>
        <input type="submit" id="zoek" value="Zoek Film">
    </form>
</main>

</body>
</html>
