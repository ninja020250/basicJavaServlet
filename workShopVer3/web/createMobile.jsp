<%-- 
    Document   : createMobile
    Created on : 21-Oct-2017, 20:26:42
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="createMobile">
            <c:set var="err" value="${requestScope.CREATEERR}"/>
            Mobile Id : <input type="text" name="txtIdMobile" value="${param.txtNameMobile}" /><br/>
            <c:if test="${not empty err.mobileIdLengthErr}">
                <font color="red">
                ${err.mobileIdLengthErr}
                </font><br/>
            </c:if>
            Mobile description : <input type="text" name="txtDescription" value="${param.txtDescription}" /><br/>
            <c:if test="${not empty err.descriptionLenghthErr}">
                <font color="red">
                ${err.descriptionLenghthErr}
                </font><br/>
            </c:if>
            Mobile price : <input type="number" name="txtPrice" value="0" /><br/>
            Mobile Name : <input type="text" name="txtMobileName" value="${param.txtMobileName}" /><br/>
            <c:if test="${not empty err.mobileNameLengthErr}">
                <font color="red">
                ${err.mobileNameLengthErr}
                </font><br/>
            </c:if>
            year Of Production : <input type="number" name="txtYearOfProduction" value="${param.txtYearOfProduction}" /><br/>
            Mobile quantity : <input type="number" name="txtQuantity" value="${param.txtQuantity}" /><br/>
            notSale : <input type="checkbox" name="txtQuantity" value="ON"/><br/>
            <input type="submit" value="Create" />
            <input type="submit" value="Reset" /><br/>
            <c:if test="${not empty err.mobileNameExistedErr}">
                <font color="red">
                ${err.mobileNameExistedErr}
                </font><br/>
            </c:if>
        </form>
    </body>
</html>
