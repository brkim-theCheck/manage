<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Please sign in</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">

  </head>
  <body>
     <style>
     html ,body {
        width: 100%;
        height: 100%;
        background: url(/img/auth_bg.jpg) no-repeat;
        background-size:cover;
     }

     body {
        display: flex;
        justify-content:center;
        align-items:center;
     }

     .logo {
        width: 340px;
        height: 68px;
        margin: 0 auto 25px;
     }
     .form-signin {
        display: flex;
        flex-direction: column;
        justify-content: center;
        min-width: 630px;
        margin: 0 auto;
        padding: 40px 70px;
        border-radius: 15px;
        background: #fff;
        box-shadow: 0 2px 15px 0 rgba(0, 0, 0, .3);
     }

     .form-signin .btn-submit {
        height: 60px;
        margin-top: 45px;
        color: #fff;
        font-size: 20px;
        border-radius: 5px;
        background: #32b8d3;
        border-color: #32b8d3;
     }
     </style>
     <div class="container">
      <form class="form-signin" method="post" action="/loginProc">
        <img class='logo' src="/img/logo.png"/>
        <p>
          <span for="username" class="">아이디</span>
          <input type="text" id="username" name="username" class="form-control" placeholder="Username" required="" autofocus="">
        </p>
        <p>
          <label for="password" class="">비밀번호</label>
          <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">
        </p>
        <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
        <button class="btn btn-lg btn-primary btn-block btn-submit" type="submit">로그인</button>
      </form>
    </div>
</body>
</html>