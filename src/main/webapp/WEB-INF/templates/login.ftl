
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <#--<link rel="stylesheet"  type="text/css" href="/style.css" />-->
    <link rel="stylesheet"  type="text/css" href="/background.css" />

</head>

<body>
<br></br>
<br></br>
<section id="loginform" class="outer-wrapper">

    <div class="inner-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-sm-4 col-sm-offset-4">
                    <h2 class="text-center">Welcome back.</h2>
                    <form action="/login" method="post" id="loginForm" name="loginForm">
                        <div class="form-group name="login" method="POST">
                        <label for="username">Email address</label>
                        <input type="email" class="form-control" id="username" name="username" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                </div>

                <button type="submit" class="btn btn-default">Submit</button>
                <#if error_message??>
                    <div class="alert alert-danger alert-dismissable fade in">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        ${error_message!""}
                    </div>




                </#if>

                </form>
            </div>
        </div>
    </div>
    </div>

</section>

</body>
</html>
