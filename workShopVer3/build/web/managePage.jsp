<%-- 
    Document   : managePage
    Created on : 18-Oct-2017, 18:14:02
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Manager Page</title>
    </head>
    <body>
        <font color="red">
        welcome, ${sessionScope.USERID}
        </font>
        <form action="searchForManager">
            search by ID:<input type="text" name="txtSearchById" value="${param.txtSearchById}" /><br/>
            search by Name:<input type="text" name="txtSearchByName" value="${param.txtSearchByName}" /><br/>
            <input type="submit" value="searchId Or Name" name="btnSearch"/><br/>       
        </form>
        <form action="searchAll">
            <input type="submit" value="Show All" name="btnSearch" />   
        </form>
        <br/>  
        <c:set var="searchId" value="${param.txtSearchById}"/>
        <c:set var="searchName" value="${param.txtSearchByName}"/>
        <%--  <c:if test="${not empty searchId or not empty searchName}"> --%>
        <c:set var="result" value="${requestScope.SEARCHRESULTFORMANAGER}"/>
        <c:if test="${not empty result}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>id</th>
                        <th>FullName</th>
                        <th>class</th>
                        <th>address1</th>
                        <th>address2</th>
                        <th>status</th>
                        <th>Phone</th>                        
                        <th>Update</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${result}" varStatus="counter">
                    <form action="update">
                        <tr>
                            <td>
                                ${counter.count}
                            </td>
                            <td>
                                ${dto.id}
                            </td>
                            <td>
                                ${dto.firstName} +   ${dto.middleName} +   ${dto.lastName}
                            </td>
                            <td>
                                ${dto.classRoom}
                            </td>
                            <td>
                                ${dto.address1}
                            </td>
                            <td>
                                ${dto.address2}
                            </td>
                            <td>
                                ${dto.status}
                            </td>
                            <td>
                                ${dto.phone}
                            </td>
                            <td>
                                <input type="checkbox" name="IsNotSale" value="${dto.isMen}" 
                                       <c:if test="${dto.isMen}">
                                           checked="checked"
                                       </c:if>
                                       />
                            </td>                                                    
                            <td>
                                <input type="hidden" name="txtMobileId" value="${dto.mobileId}" />
                                <input type="hidden" name="txtLastSearchValueId" value="${searchId}" />
                                <input type="hidden" name="txtLastSearchValueName" value="${searchName}" />
                                <input type="submit" value="update" />
                            </td>
                        </tr>
                    </form>

                </c:forEach>

            </tbody>
        </table>
    </c:if>
    ${requestScope.NORESULT}
    <%--  </c:if> --%>  

    <a href="createMobile.jsp">click here to add more mobile</a>
</body>
</html>
