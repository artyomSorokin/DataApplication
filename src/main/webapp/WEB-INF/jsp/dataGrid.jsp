<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>List users</title>
    <link rel="stylesheet" type="text/css" media="screen" href="/resources/css/style.css"/>
    <script type="text/javascript" src="/resources/jquery/jquery.js"></script>
    <script src="/resources/jquery/scripts.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
</head>
<body>
<form action="event">
    <table align="center" class="table" border="1">
        <thead>
        <tr>
            <td>Manufacturer</td>
            <td>Model</td>
            <td>Release Date</td>
            <td>price</td>
            <td>Select</td>
        </tr>
        </thead>
        <c:forEach var="bean" items="${carList}">
            <tr>
                <td>${bean.manufacturer}</td>
                <td>${bean.model}</td>
                <td><fmt:formatDate value="${bean.date}" pattern="dd.MM.yyyy" /></td>
                <td>${bean.price}</td>
                <td><input type="checkbox" name="carId" value="${bean.id}"/></td>

            </tr>
        </c:forEach>
    </table>
    <input type="submit" name="action" value="refresh" class="btn btn-primary btn-mini" />
    <input type="submit" name="action" value="edit" class="btn btn-primary btn-mini" />
    <input type="submit" name="action" value="delete" class="btn btn-primary btn-mini" />
</form>
<br><br>

<c:if test="${message == 'Please select just one row to be edited'}" >
    <div id="coolmenu" align="center" class="errorMsg">
        Please select just one row to be edited
    </div>
</c:if>
<c:if test="${message == 'Please select row to delete'}" >
    <div id="coolmenu" align="center" class="errorMsg">
        Please select row to delete
    </div>
</c:if>
<c:if test="${message == 'Row was deleted'}" >
    <div id="coolmenu" align="center" class="successMsg">
        Row was deleted
    </div>
</c:if>

<c:if test="${message == 'User was updated'}" >
    <div id="coolmenu" align="center" class="successMsg">
        User was updated
    </div>
</c:if>
<c:if test="${message == 'User was added'}" >
    <div id="coolmenu" align="center" class="successMsg">
        User was added
    </div>
</c:if>
<c:if test="${message == 'Canceled'}" >
    <div id="coolmenu" align="center" class="successMsg">
        Canceled
    </div>
</c:if>

</body>
</html>