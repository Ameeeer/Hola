<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>All events</title>
    <#include "links.ftl">
</head>
<body>
<#include "menu.ftl">
<style>
    #glaw {
   display:inline;
   width:680px;
   }
    .clrred {
    color: red;
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
<form action="/events" method="get">
    <#list getAllevents as Event>
    <div id="glaw">
        <div class="blok1">
            <div class="row">
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img src="https://kpfu.ru/portal/docs/F1897406703/_ITIS_7.jpg" width="300" height="130" alt="">
                        <div class="caption">
                            <div class="blok2">
                                <h3>${Event.name}</h3>
                                <p>${Event.description}</p>
                                <p>Адрес: ${Event.address}</p>
                            </div>
                            <div class="clrred"><p>${Event.status}</p></div>
                            <p><a href="#" class="btn btn-primary" role="button">Я пойду</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </#list>
</form>
</body>
</html>