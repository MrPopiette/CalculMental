<%--
  Created by IntelliJ IDEA.
  User: Maxime.M
  Date: 20/10/2019
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Questionnaire</title>
</head>
<body>

<form>
    <% for (int i = 0; i < 10; i += 1) { %>

    <ul>
        <li>
            <div class="questionnaire_display">
                <h1> Question n° ${i} </h1>
                <h2>

                </h2>
            </div>
        </li>
        <li>
            <div class="questionnaire_input">
                <input type="number" required class="questionnaire_input" value=""/>
            </div>
        </li>
    </ul>

    <% } %>

    <div class="questionnaire_submit">
        <button type="submit"></button>
    </div>
</form>


</body>
</html>
