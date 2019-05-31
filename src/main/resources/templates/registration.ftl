<#import "parts/common.ftl" as skileton>

<@skileton.html_skileton>
    <span>

     ${message?if_exists}
    </span>

    <div class="container">
        <style>
            .container {
                width: 30%;
                margin-top: 5%;
            }

            .login-link {
                display: block;
            }

        </style>
        <h1 class="chart-plot-background">Add new User</h1>
        <form action="/registration" method="post">
            <div class="form-group">
                <label for="exampleInputUsername">Username</label>
                <input type="text" class="form-control" name="username" id="exampleInputUsername" placeholder="Username"
                       required/>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Email</label>
                <input type="email" class="form-control" name="email" id="exampleInputEmail1" placeholder="Email"
                       required/>
            </div>
            <div class="form-group">
                <label for="exampleInputPass">Password</label>
                <input type="password" class="form-control" id="exampleInputPass" name="password" placeholder="Password"
                       required/>
            </div>

            <div class="d-flex justify-content-between">
                <#--<input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
                <button type="submit" class="btn btn-primary">Register</button>
                <a class="btn btn-info" href="/login">Login</a>
            </div>
        </form>
    </div>

</@skileton.html_skileton>
