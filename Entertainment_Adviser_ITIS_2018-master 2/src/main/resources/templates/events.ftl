<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>All events</title>
    <#include "links.ftl">
    <style>
        #glaw {
            display:inline;
            width:680px;
        }
        .clrred {
            color: red;
        }
        .clrgreen{
            color: green;
        }
        .blok1 {
            float:left;
            margin: 3px 3px 3px 5px;
            width:350px;
            height:430px;
            padding: 10px;
            text-align: center;
            border-radius: 15px;
        }
        .blok2 {
            float:left;
            margin: 3px 3px 3px 5px;
            width:300px;
            height:200px;
            text-align: center;
        }
    </style>
</head>
<body>
<#include "menu.ftl">
<div class="container">
<form action="/events" method="get">
    <#list getAllevents as Event>
    <div id="glaw">
        <div class="blok1">
            <div class="row">
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img src="${Event.getImage()}" width="300" height="130" alt="">
                        <div class="caption">
                            <div class="blok2">
                                <h3><a href="/events/${Event.id}">${Event.name}</a></h3>
                                <p>${Event.description}</p>
                                <p>Адрес: ${Event.address}</p>
                            </div>
                            <#if "${Event.status}" == "Окончено">
                            <div class="clrred"><p>${Event.status}</p></div>
                            <#else>
                            <div class="clrgreen"><p>${Event.status}</p></div>
                            </#if>
                            <p><a href="/events/iGo" class="btn btn-primary" role="button" method ="post">Я пойду</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </#list>
</form>
</div>
</body>
</html>