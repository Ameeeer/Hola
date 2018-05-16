<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>User tags</title>
    <#include "links.ftl">
</head>
<body>
<#include "menu.ftl">
<div class="container">
    <form>
        <#list userTagList as userTag>
            <label for="userTag">${userTag.tagName}</label>
            <input type="checkbox" value="${userTag.id}" id="userTag"
            <#if userTag.getChosen()??> <#if userTag.getChosen()> checked</#if> </#if>
            >

        </#list>
        <button type="submit">Сохранить</button>
    </form>
</div>
</body>
</html>