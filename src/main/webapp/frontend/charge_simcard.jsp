<!-- page directive -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>MehdiSarfejoo Phone Project</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<%@include file="header.jsp" %>
<div style="font-family:system-ui">

    <form method="post" action="add_charge">

        <table align="center" style="font-size: larger;text-align: center" border="1" cellpadding="5" width="50%">

            <tr>

                <th colspan="2">
                    SIM CARD Panel
                </th>
            </tr>

            <tr>
                <td>
                    <label for="amounts">Amount : </label>
                </td>

                <td>
                    <select name="amount" id="amounts">

                        <option value="1">
                            10.000 Rial
                        </option>

                        <option value="2">
                            20.000 Rial
                        </option>

                        <option value="3">
                            50.000 Rial
                        </option>

                    </select>
                </td>

            </tr>


            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Charge!">
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
