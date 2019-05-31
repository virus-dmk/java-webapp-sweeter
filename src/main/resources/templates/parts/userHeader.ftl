<#macro userHeader>
    <#include "./security.ftl">
<#---->
<#--<#if known>-->
<#--//выводим раздел-->
<#--</#if>-->

    <nav class="navbar navbar-expand-md navbar-dark bg-dark" role="navigation">
        <a class="navbar-brand" href="#">Fanfic</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">


                <li class="nav-item active">
                    <a class="nav-link" href="/user/${(user.id)?if_exists}">User Info<span
                                class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user">User</a>
                </li>
                <#if isAdmin>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/adminForm">Admin pannel</a>
                    </li>
                </#if>
                <form action="/logout" method="post">
                    <button type="submit" class="btn btn-info">Sign Out</button>
                </form>
                </li>


            </ul>
            <form class="form-inline mt-2 mt-md-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</#macro>