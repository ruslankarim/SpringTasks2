<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-03-12
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of Cars</title>
</head>
<body>
    <center>
        <h1>List of Cars</h1>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${locale != null}">
                        <c:if test="${locale == \"en\"}">
                            Cars
                        </c:if>
                        <c:if test="${locale == \"ru\"}">
                            Машины
                        </c:if>
                    </c:if>
                    <c:if test="${locale == null}">
                        Cars
                    </c:if>
                </h2>
            </caption>
            <tr>
                <th>Name</th>
                <th>Series</th>
                <th>Number</th>
            <c:forEach var="car" items="${cars}">
                <tr>
                    <td><c:out value="${car.name}" /></td>
                    <td><c:out value="${car.series}" /></td>
                    <td><c:out value="${car.number}" /></td>
                </tr>
            </c:forEach>
            </tr>
        </table>
    </div>
</body>
</html>
