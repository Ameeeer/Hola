<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">EntertainmentAdviser</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    <#if currentUser??>
        <li class="nav-item active"><a class="nav-link" href="/">Главная</a></li>
        <li class="nav-item active"><a class="nav-link" href="/user/${currentUser.id}">Профиль</a></li>
        <li class="nav-item active"><a class="nav-link" href="/tags">Предпочтения</a></li>
        <li class="nav-item active"><a class="nav-link" href="/events">Мероприятия</a></li>
    </#if>
    </ul>
        <#if currentUser??>
            <form class="form-inline my-2 my-lg-0" action="/logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log out</button>
            </form>
        <#else>
            <form class="form-inline my-2 my-lg-0" action="/login" method="get">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log in</button>
            </form>
        </#if>
    </div>
</nav>