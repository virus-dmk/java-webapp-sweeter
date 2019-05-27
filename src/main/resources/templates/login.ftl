<#import "parts/common.ftl" as common>
<#import "parts/header.ftl" as header>
<#import "parts/footer.ftl" as footer>

<@common.html_skileton>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <a class="navbar-brand" href="#">Fanfic</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav mr-auto">


                    <li class="nav-item active">
                        <a class="nav-link" href="#">User Info<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Users</a>
                    </li>
                    <form action="/logout" method="post">
                        <button type="submit" class="btn ">Sign Out</button>
                    </form>
                    </li>


                </ul>
                <form class="form-inline mt-2 mt-md-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </header>


    <main role="main">

        <div class="container index-container qwer">
            <style>
            .qwer {
            width: 30%;
            margin-top: 4%;

            }
                .container{
                    horiz-align: center;
                }
            </style>
            <h1 class="chart-plot-background">Login</h1>
            <form action="/login" method="post">

                <div class="form-group">
                    <label for="exampleInputEmail1">Username</label>
                    <input type="text" name="username" class="form-control" id="exampleInputEmail1"
                           aria-describedby="emailHelp"
                           placeholder="Enter username" required>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1"
                           placeholder="Password" required>
                </div>
                <div class="d-flex justify-content-between">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-primary" tabindex="5">Sign In</button>
                    <a class="btn btn-warning" href="/registration" tabindex="6">Add new User</a>
                </div>


            </form>

        </div>


    </main>
</@common.html_skileton>