<%-- 
    Document   : viewCart
    Created on : 19-Oct-2017, 11:51:42
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
        Hello ${sessionScope.USERID}, Your Cart Include this Items.
        </font>
        <c:set var="cart" value="${sessionScope.CART}"/>
        <c:if test="${not empty cart}">
            <c:set var="items" value="${cart.items}"/>
            <c:if test="${not empty items}">
                <form action="deleteItems">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Items Name</th>
                                <th>Quantity</th>
                                <th>is Choosing</th>    
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${items}" varStatus="counter">
                                <tr>
                                    <td>
                                        ${counter.count}
                                    </td>
                                    <td>
                                        ${item.key}
                                    </td>
                                    <td>
                                        ${item.value}
                                    </td>    
                                    <td>
                                        <input type="checkbox" name="chooseToDelete" value="${item.key}" />
                                    </td> 
                                </tr>

                            </c:forEach> 
                            <tr>
                                <td colspan="3">
                                    <a href="viewMobile.jsp">Add more Items to your cart</a>
                                </td>
                                <td>
                                    <input type="submit" value="Remove Selection Items" name="deleteItems"/>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
                <form action="saveCart">
                    <input type="hidden" name="cusId" value="${sessionScope.USERID}"/>
                    <input type="submit" value="Pay All" /><br/>
                </form>
            </c:if>
        </c:if>
        <form action="logOut">
            <input type="submit" value="log out" />
        </form>
    </body>
</html>
