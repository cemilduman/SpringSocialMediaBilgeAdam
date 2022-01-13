<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Spring Project Social Media & Subscriber</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
<h1 class="text-center"> Static Text Field: ${staticText}</h1>

<div class="container bg-dark text-white mt-5">
    <h2 class="text-success text-center display-2">Subscriber View: </h2>
    <ul class="list-group">
        <li class="list-group-item text-success">Subscriber Id: ${subscriber_print.subcriberId}</li>
        <li class="list-group-item text-success">Subscriber Name: ${subscriber_print.subsriberName}</li>
        <li class="list-group-item text-success">Subscriber Surname: ${subscriber_print.subscriberSurname}</li>
        <li class="list-group-item text-success">Subscriber Adress: ${subscriber_print.subscriberAdress}</li>
        <li class="list-group-item text-success mb-3">Date: ${subscriber_print.creationDate}</li>
    </ul>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>