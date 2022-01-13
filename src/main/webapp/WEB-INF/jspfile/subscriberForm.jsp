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

<div class="container bg-dark text-white mt-5">
    <h2 class="text-success text-center display-2">MY FORM</h2>
    <form:form method="post" modelAttribute="form_key">
        <fieldset class="form-group">
            <form:label path="subscriberId">Subscriber ID:</form:label>
            <form:input cssClass="form-control" path="subscriberId" disabled="false"/>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="subscriberName">Subscriber NAME:</form:label>
            <form:input cssClass="form-control" path="subscriberName"/>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="subscriberSurname">Subscriber SURNAME:</form:label>
            <form:input cssClass="form-control" path="subscriberSurname"/>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="subscriberAdress">Subscriber ADRESS:</form:label>
            <form:input cssClass="form-control" path="subscriberAdress"/>
        </fieldset>

        <input type="submit" class="btn btn-primary ml-5 mb-5" value="Send"/>
        <input type="reset" class="btn btn-danger ml-5 mb-5" value="Delete"/>
    </form:form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>