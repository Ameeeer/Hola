<html lang="ru">
<head>
    <#include "links.ftl">
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<#include "menu.ftl">
<div class="container">
<form action="/events/{id}" method="get">
<#list getEventById as Event>
    <img src="${Event.getImage()}" width="300" height="130" alt="">
    <h1>${Event.name}</h1>
    <h5>${Event.description}</h5>
</#list>
</form>
</div>
</body>
</html>