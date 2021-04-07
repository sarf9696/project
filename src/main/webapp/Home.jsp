<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- page directive -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Index - MehdiSarfejoo Phone Project</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<%@include file="frontend/header.jsp" %>

<div style="font-family:system-ui">
    <c:if test="${thePhone eq null}">
        <table align="center" style="font-size: larger;text-align: center" border="1" cellpadding="5" width="50%">

            <tr>

                <th colspan="2">
                    PHONE AND SIM CARD Manager
                </th>
            </tr>

            <tr>
                <td colspan="2">
                    SIM Card Manager is a program that enables you to Manage Your SIM card.
                </td>
            </tr>

            <tr>
                <td>
                    <form method="get" action="showLoginForm">
                        <input type="submit" value="Sign In">
                    </form>
                </td>

                <td>
                    <form method="get" action="showRegisterForm">
                        <input type="submit" value="Sign Up">
                    </form>
                </td>
            </tr>

        </table>
    </c:if>

    <c:if test="${thePhone ne null}">

        <form method="post" action="recharge_simcard">

            <table align="center" style="font-size: larger;text-align: center" border="1" cellpadding="5" width="50%">

                <tr>

                    <th colspan="2">
                        SIM Card Panel
                    </th>
                </tr>

                <tr align="center">
                    <td>
                        Charge Your Sim Card
                    </td>

                    <td>
                        <b>
                            <a href="">Charge</a>
                        </b>
                    </td>

                </tr>


                <tr align="center">
                    <td>
                        Edit Your SimCard Info
                    </td>

                    <td>
                        <b>
                            <a href="editForm">Edit Info</a>
                        </b>
                    </td>

                </tr>

                <tr align="center">
                    <td>
                        Delete Your SIM Card Account
                    </td>

                    <td>
                        <b>
                            <a href="deleteInfo">Delete Info</a>
                        </b>
                    </td>

                </tr>

                <tr align="center">
                    <td>
                        Your SIM Card Balance:
                    </td>

                    <td>
                        <b>
                                ${thePhone.simCard.balance} Rial
                        </b>
                    </td>

                </tr>

                <tr>
                    <td align="center" colspan="3">
                        <input type="submit" value="Recharge My ${thePhone.simCard.name} SIM CARD">
                        <input type="button" onclick="location.href='javascript:history.go(-1)';"
                               value="Return To Previous Page">
                        <input type="button" onclick="location.href='logout'"
                               value="Sign Out">
                    </td>
                </tr>

            </table>
        </form>

    </c:if>
</div>

</body>
</html>
