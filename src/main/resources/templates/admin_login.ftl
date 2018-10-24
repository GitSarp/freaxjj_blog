<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>

    <script src="/blog_template/jquery.min.js"></script>
    <link href="/blog_template/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="/blog_template/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/blog_template/login.css">



</head>
<body>
<div class="container">

    <div class="row">
                    <#if msg??>
                    <#-- s 提示消息（用户名或密码错误） -->
                        <div class="alert alert-danger alert-dismissible fade show card-login mt-5 mx-auto"
                             role="alert">
                            ${msg!""}
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </#if>
    </div>
    <div class="form row">
        <form class="form-horizontal col-md-offset-3" id="login_form" action="/admin/index" method="post">
            <h3 class="form-title">LOGIN</h3>
            <div class="col-md-9">
                <div class="form-group">
                    <i class="fa fa-user fa-lg"></i>
                    <input class="form-control required" type="text" placeholder="Username" id="username" name="username" autofocus="autofocus" maxlength="20"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-lock fa-lg"></i>
                    <input class="form-control required" type="password" placeholder="Password" id="password" name="password" maxlength="8"/>
                </div>
                <div class="form-group">
                    <label class="checkbox">
                        <input type="checkbox" name="remember" value="1"/>记住我
                    </label>
                </div>
                <div class="form-group col-md-offset-9">
                    <a href="/admin/register">注册</a>
                    <button type="submit" class="btn btn-success pull-right" name="submit">登录</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>