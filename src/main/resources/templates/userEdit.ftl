<#import "parts/common.ftl" as common>
<#import "parts/userHeader.ftl" as header>

<@common.html_skileton>
    <@header.userHeader/>

    <h1>User Editor</h1>

    <form action="/user" method="post">
        <input type="text" name="username" value="${user.username}">
        <#list roles as role>
            <div>
               <label for="id-${role}">
                   <input type="checkbox" name="${role}" id="id-${role}" ${user.roles?seq_contains(role)?string("checked","")}>${role}
               </label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">

        <button type="submit">Save</button>
    </form>




</@common.html_skileton>