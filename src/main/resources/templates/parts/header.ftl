<#macro header >
    <header>
        <!-- Fixed navbar -->
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

            <a class="navbar-brand" href="#">Fanfic</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarCollapse">

                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Fanfics <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Other1</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Other2</a>
                    </li>
                </ul>

                <form class="form-inline mt-2 mt-md-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
                <span style="color:red">${loggedUser?if_exists}</span>
                <form action="/logout" method="post">
                    <input type="submit" value="Sign Out"/>
                </form>

                    <a class="btn btn-info my-2 my-sm-0" href="/login">Login</a>
                    <a class="btn btn-info my-2 my-sm-0" href="/registration">Registration</a>
                    <a class="btn btn-info" href="/user">User Page</a>

                <#--<button class="button" onclick="location.href='/login'">log</button>-->
                <#--<button class="button" onclick="location.href='/registration'">reg</button>-->
            </div>
        </nav>
    </header>
</#macro>