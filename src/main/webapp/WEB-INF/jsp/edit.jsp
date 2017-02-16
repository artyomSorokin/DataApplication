<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Edit</title>
    <link rel="stylesheet" type="text/css" media="screen" href="/resources/css/style.css"/>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
    <script type="text/javascript">
        <%@ include file="/resources/js/validation.js"%>
    </script>
</head>
<body>
<div class="editForm">
    <form  action="edit" name="frm" ONSUBMIT="return validateForm()">
        <input name="id" type="hidden" value="${car.id}" />

        <label>Manufacturer</label><br />
        <input class="form-control <%--form-control-inline--%>" size="10" name="manufacturer" id="manufacturer" placeholder="manufacturer" value="${car.manufacturer}"><br />

        <label>Model</label><br />
        <input class="form-control" name="model" id="model" placeholder="model" value="${car.model}"><br />

        <label>Date</label><br />
        <fmt:formatDate value="${car.date}" var="dateString" pattern="yyyy-MM-dd" />
        <input type="date" class="form-control" name="date" id="date" placeholder="date" value="${dateString}" ><br />

        <label>Price</label><br />
        <input class="form-control" name="price" id="price" placeholder="price" value="${car.price}" ><br />

        <c:if test="${message != 'Not any row is selected'}" >
            <input type="submit" name="action" value="save" class="btn btn-primary btn-mini" />
        </c:if>
        <input type="submit" name="action" value="add" class="btn btn-primary btn-mini" />
        <input type="submit" name="action" value="cancel" class="btn btn-primary btn-mini" />
    </form>
</div>
</body>
</html>
