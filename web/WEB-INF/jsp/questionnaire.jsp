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

<form method="POST" action="questionnaire">
    <ul>
        <c:forEach var="question" items="${ questionnaire.listeExpressions }" varStatus="status">
        <li>
            <div class="questionnaire_display">
                <h4>${ question.expression }</h4>
            </div>
            <div>
                <input type="text" placeholder="Reponse" name="${ status.index }" value="" required>
            </div>
        </li>
        </c:forEach>
    </ul>

    <input type="hidden" name="done" value="true">
<div class="questionnaire_submit">
    <button type="submit">Test</button>
</div>
</form>


</body>
</html>
