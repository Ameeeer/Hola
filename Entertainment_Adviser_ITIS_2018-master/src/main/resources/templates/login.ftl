<!DOCTYPE html>
<html lang="en">

<head>
<#include "links.ftl">
<style>
    html,
    body {
        height: 100%;
    }

    body {
        display: -ms-flexbox;
        display: flex;
        -ms-flex-align: center;
        align-items: center;
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
    }

    .form-signin {
        width: 100%;
        max-width: 330px;
        padding: 15px;
        margin: auto;
    }
    .form-signin .checkbox {
        font-weight: 400;
    }
    .form-signin .form-control {
        position: relative;
        box-sizing: border-box;
        height: auto;
        padding: 10px;
        font-size: 16px;
    }
    .form-signin .form-control:focus {
        z-index: 2;
    }
    .form-signin input[type="text"] {
        margin-bottom: -1px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }
    .form-signin input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }
</style>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login page</title>
</head>
<body class="text-center">


<form class="form-signin" role="form" action="/login" method="post">
    <img class="mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


    <label for="inputUsername" class="sr-only">Username</label>
    <input type="text" name="username" class="form-control" id="inputUsername" placeholder="username" required
           autofocus/>

    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" name="password" class="form-control" id="inputPassword" placeholder="password" required/>
    <#if model.error.isPresent()>
        <p>The email or password you have entered is invalid, try again.</p>
    </#if>
    <button class="btn btn-success  " type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">© 2017-2018 It-Park</p>

</form>
</body>
</html>