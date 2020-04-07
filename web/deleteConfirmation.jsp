<%--
  Created by IntelliJ IDEA.
  User: paeps
  Date: 7/04/2020
  Time: 15:55
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
    <title>Bevestiging</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="Servlet?command=home">Home</a></li>
            <li><a href="voegToe.jsp">Voeg toe</a></li>
            <li><a href="Servlet?command=overview">Overzicht</a></li>
            <li><a href="zoek.jsp">Zoek</a></li>
        </ul>
    </nav>
</header>
</body>
<main>
    <h1>Verwijder film</h1>
    <p>Ben je zeker dat je <%=request.getParameter("titel")%> wilt verwijderen?</p>
    <form action="Servlet?command=deleteConfirmation&titel=<%=request.getParameter("titel")%>" method="POST">
        <input type="hidden" name="titel" value="">
        <input type="submit" name="submit" value="Zeker">
        <input type="submit" name="submit" value="Toch niet">
    </form>
</main>

</html>
