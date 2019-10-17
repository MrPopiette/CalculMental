<%--
  Created by IntelliJ IDEA.
  User: T4raa
  Date: 17/10/2019
  Time: 09:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connexion</title>
</head>
<body>
<div class="callout large primary">
    <div class="row column text-center">
        <h1>Connexion</h1>
    </div>
</div>
<div class="row small-5 small-centered">
    <form method="POST" action="login">
        <div class="form-icons">
            <div class="input-group">
						<span class="input-group-label">
							<i class="fa fa-user"></i>
						</span>
                <input class="input-group-field" type="text" placeholder="Identifiant" name="form-login"
                       value="${loginBean.login}"/>
            </div>
            <div class="input-group">
						<span class="input-group-label">
							<i class="fa fa-envelope"></i>
						</span>
                <input class="input-group-field" type="text" placeholder="Mot de passe" name="form-password"/>
            </div>
        </div>
        <button class="button expanded">Se connecter</button>
    </form>


</div>
</body>
</html>
