<!-- page directive -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registeration Done</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<%@include file="header.jsp" %>

<div style="font-family:system-ui">

    <h3 align="center" style="color: #ff338d">
        Thank you for your registration. Your registration was successful.
    </h3>

    <form method="post" action="recharge_simcard">
        <table align="center" style="font-size: larger;text-align: center" border="1" cellpadding="5" width="50%">

            <tr>

                <th colspan="2">
                    Your Phone And SIM Card Information
                </th>
            </tr>

            <tr align="center">
                <td>
                    Your Device:
                </td>

                <td>
                    <b>
                        "${thePhone.type}"
                    </b>
                </td>

            </tr>


            <tr align="center">
                <td>
                    Operator:
                </td>

                <td>
                    <b>
                        "${thePhone.simCard.name}"
                    </b>
                </td>

            </tr>

            <tr align="center">
                <td>
                    Your Number:
                </td>

                <td>
                    <b>
                        ${thePhone.simCard.number}
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
                <td align="center" colspan="2">
                    <input type="submit" value="Recharge My ${thePhone.simCard.name} SIM CARD">
                    <input type="button" onclick="location.href='javascript:history.go(-1)';"
                           value="Return To Previous Page">
                </td>
            </tr>

        </table>
    </form>
</div>

<form method="get" action="${pageContext.request.contextPath}" style="text-align: center">
    <input type="submit" value="Go To Index">
</form>

</body>
</html>
