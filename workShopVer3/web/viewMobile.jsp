<%-- 
    Document   : viewMobile
    Created on : 18-Oct-2017, 18:13:39
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <font color="red">
        welcome, ${sessionScope.USERID}
        ${requestScope.SAVECARTERR}
        </font>
        <form action="search">
            Search device with price in range: <br/>
            <input type="text" name="txtSearchValueMin" value="${param.txtSearchValueMin}" />
            <input type="text" name="txtSearchValueMax" value="${param.txtSearchValueMax}" />   <br/>
            <input type="submit" value="search" />
        </form> 
        <c:set var="searchValueMin" value="${param.txtSearchValueMin}"/>
        <c:set var="searchValueMax" value="${param.txtSearchValueMax}"/>
        <c:if test="${not empty searchValueMin  and not empty searchValueMax}"> 
            <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No. ${requestScope.TEST}</th>
                            <th>mobileId</th>
                            <th>description</th>
                            <th>price</th>
                            <th>mobileName</th>
                            <th>yearOfProduction</th>
                            <th>quantity</th>
                            <th>notSale</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form action="shopping">
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    ${dto.mobileId}
                                </td>
                                <td>
                                    ${dto.description}
                                </td>
                                <td>
                                    ${dto.price}
                                </td>
                                <td>
                                    ${dto.mobileName}
                                </td>
                                <td>
                                    ${dto.yearOfProduction}
                                </td>
                                <td>
                                    ${dto.quantity}
                                </td>
                                <td>
                                    ${dto.notSale}
                                </td>
                                <td>
                                    <input type="submit" value="add to Cart" />
                                    <input type="hidden" name="itemsWantToBuy" value="${dto.mobileId}"/>
                                    <input type="hidden" name="lastSearchValueMin" value="${searchValueMin}"/>
                                    <input type="hidden" name="lastSearchValueMax" value="${searchValueMax}"/>
                                </td>
                            </tr>
                        </form>

                    </c:forEach>

                </tbody>
            </table>
        </c:if>
        <c:if test="${empty result}">
            no record matched
        </c:if>
    </c:if>   
    <a href="viewCart.jsp">click here to view your cart</a>
    <form action="logOut">
        <input type="submit" value="log out" />
    </form>
</body>
</html>
