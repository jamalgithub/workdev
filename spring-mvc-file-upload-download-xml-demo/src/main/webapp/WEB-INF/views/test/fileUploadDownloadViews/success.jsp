<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Spring MVC - File Upload</title>
        <link type="text/css" href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <h2>Uploaded File Details</h2>
                    <c:forEach items="${files}" var="file">
                        <div class="row" style="border:1px solid #ccc; margin:5px;">
                            <div class="col-md-4">
                                <b><c:out value="${file.name}" /></b>
                            </div>
                            <div class="col-md-4">
                                <c:out value="${file.path}" />
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>