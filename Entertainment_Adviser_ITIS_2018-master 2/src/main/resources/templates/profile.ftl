<html>
<head>
    <#include "links.ftl">
</head>
<body>
<#include "menu.ftl">
<div class="container">
    <form action="/create" method="POST">
    <#list user_profile as user>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <h1>Профиль</h1>
        <div class="row">
            <div class="col-1">Username:</div>
            <div class="col-11"><input type="text" name="username" id="username" value="${user.username}"></div>
        </div>
        <div class="row">
            <div class="col-1">Firstname:</div>
            <div class="col-11"><input type="text" name="firstname" id="firstname" value="${user.firstname}"></div>
        </div>
        <div class="row">
            <div class="col-1">Username:</div>
            <div class="col-11"><input type="text" name="secondname" id="secondname" value="${user.secondname}"> </div>
        </div>

        <div class="goodbutton">
            <input type="submit" value="Сохранить изменения">
        </div>
    </#list>
    </form>
</div>
</body>
</html>





