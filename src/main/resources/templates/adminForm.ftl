<#import "parts/common.ftl" as common>



<@common.html_skileton>


    <div class="container">

        <div class="container">
            <h1 inline="text">Hello, ${currentUser}</h1>
            <!--<form action="/logout" method="post">-->
            <!--<input class="btn btn-outline-secondary" type="submit" name="mainButton" value="Sign Out">-->
            <!--</form>-->
            <style>
                h1 {
                    margin-top: 4%;
                    margin-bottom: 4%;
                }

                thead input[type=checkbox]#selectAll {
                    margin-left: 5px !important;
                }

                table {
                    margin-top: 10px;
                }

                input.big-checkbox {
                    width: 20px;
                    height: 20px;
                }
            </style>
            <form method="post" action="adminFormButtons">
                <#--<input class="btn btn-outline-secondary" type="submit" name="mainButton" value="Sign Out">-->

                <button class="btn btn-outline-secondary inline-block" type="submit" name="activeBlockbtn"
                        value="active/block">
                    Active / Block
                </button>
                <button class="btn btn-outline-secondary inline-block" type="submit" name="deleteBtn" value="delete">
                    Delete
                </button>


                <table class="table table-bordered table-hover table-sm">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">
                            <div class="d-flex justify-content-around">User</div>
                        </th>
                        <th scope="col">
                            <div class="d-flex justify-content-around">Email</div>
                        </th>
                        <th scope="col">
                            <div class="d-flex justify-content-around">Status</div>
                        </th>
                        <th scope="col">
                            <div class="d-flex justify-content-around">Role</div>
                        </th>
                        <th scope="col">
                            <div class="d-flex justify-content-around">Edit</div>
                        </th>
                        <th scope="col">
                            <div class="d-flex justify-content-around">
                                <div class="form-check form-check-inline">
                                    <label class="form-check-label" for="selectAll">Select all</label>
                                    <input class="checkbox big-checkbox" type="checkbox" id="selectAll" value="option1">
                                </div>
                            </div>

                        </th>
                    </tr>
                    </thead>

                    <tbody>
                    <#list usrs as  user>
                        <tr>
                            <td>
                                <div class="d-flex justify-content-around"><h4>
                                        <span class="badge badge-outline-primary">${user.username}</span>
                                    </h4></div>
                            </td>
                            <td>
                                <div class="d-flex justify-content-around"><h4>
                                        <span class="badge badge-outline-primary">${user.email}</span>
                                    </h4></div>
                            </td>
                            <td>
                                <div class="d-flex justify-content-around"><h5>
                                        <span class="badge badge-secondary">${user.active?string}</span>
                                    </h5></div>
                            </td>
                            <td>
                                <div class="d-flex justify-content-around">
                                    <span class="badge badge-secondary">
                                        <#list user.roles as role>${role}<#sep>, </#list>
                                    </span>
                                </div>

                            </td>
                            <td>
                                <div class="d-flex justify-content-around">
                                    <a href="/user/${user.id}">Edit</a>
                                </div>
                            </td>

                            <!--<input type="checkbox" class="form-check-input alone" id="select1" onclick="checkCheckboxes()">-->
                            <!--<input class="big-checkbox" type="checkbox" name="id" value="{{id}}"/>-->
                            <th scope="row">
                                <div class="d-flex justify-content-around"><input class="big-checkbox" type="checkbox"
                                                                                  name="userId" value="${user.id}"/></div>
                            </th>

                        </tr>
                    </#list>
                    </tbody>
                </table>

            </form>
        </div>
    </div>


</@common.html_skileton>