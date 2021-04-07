<!-- page directive -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit - MehdiSarfejoo Phone Project</title>
    <link rel="stylesheet" href="../css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
</head>
<body>

<%@include file="header.jsp"%>

<div style="font-family:system-ui">

    <form method="post" action="editPhone" id="editPhone">

        <table align="center" style="font-size: larger;text-align: center" border="1" cellpadding="5" width="50%">

            <tr>

                <th colspan="2">
                    PHONE AND SIM CARD FORM
                </th>
            </tr>

            <tr>
                <td>Enter Your Favorite Phone Number: </td>
                <td><input name="number" id="number" type="text" size="11" value="${thePhone.simCard.number}"></td>
            </tr>

            <tr>
                <td>
                    <label for="simCards">Choose Your SIM CARD: </label>
                </td>

                <td>
                    <select name="simCard" id="simCards">

                        <option value="HAMRAHAVAL">Hamrah E Aval</option>
                        <option value="IRANCELL">MTN IRANCELL</option>
                        <option value="RIGHTEL">Rightel</option>

                    </select>
                </td>

            </tr>

            <tr>
                <td>
                    <label for="devices">Specify Your Device: </label>
                </td>

                <td>
                    <select name="device" id="devices">
                        <option value="SmartPhone">Smart Phone</option>
                        <option value="Tablet">Tablet</option>
                    </select>
                </td>

            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Register">
                </td>
            </tr>

        </table>

    </form>

</div>

<form method="get" action="${pageContext.request.contextPath}" style="text-align: center">
    <input type="submit" value="Go To Index">
</form>

</body>
<script type="text/javascript">

    $(document).ready(function () {

        $("#editPhone").validate(
            {
                rules: {
                    number: {
                        required: true, maxlength: 10, minlength: 10
                    }
                }
                ,
                messages: {

                    number: {
                        required: "Please Enter Number Of Your SIM CARD",
                        maxlength: "Enter 10 Digit - Do Not Enter Leading Zero!",
                        minlength: "Enter 10 Digit - Do Not Enter Leading Zero!"
                    }
                }
            });
    });

</script>
</html>
