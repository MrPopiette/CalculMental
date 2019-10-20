<%--
  Created by IntelliJ IDEA.
  User: T4raa
  Date: 20/10/2019
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Questionnaire</title>
</head>
<body>
<h1>Meilleurs scores : </h1>
<ul>
<c:forEach var="score" items="${ homeBean.listScores }" varStatus="status">
    <li>
        <td>Numéro d'utilisateur : ${score.idUser}</td>
        <br>
        <td>Score : ${score.value}</td>
    </li>
</c:forEach>
</ul>
<form method="POST" action="questionnaire">
    <button class="button expanded">Nouveau Questionnaire</button>
</form>

</body>
</html>
