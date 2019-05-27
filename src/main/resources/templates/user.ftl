<#import "parts/userHeader.ftl" as header>
<#import "parts/common.ftl" as common>

<@common.html_skileton>

    <@header.userHeader/>

    <div class="container">
        <style>
            .container {
                margin-top: 7%;
            }
        </style>

        <span class="blo">User: ${user.username?if_exists}</span>
        <form action="createComposition">
            <button class="btn btn-info" type="submit">Create new Fanfic</button>
        </form>

        <#list compositions as composition>
        <div class="row">
            <p class="user">${user.username}</p>
            <p class="composition-name">${composition.compos_name?if_exists}</p>
            <p class="description">Краткое описание: ${composition.description?if_exists}</p>
            <p class="short-info">Количество
                глав: </p>
            <form action="/editUserComposition">
                <button class="btn btn-info" type="submit" name="addChapter" value="AddChapter">Add chapter</button>
                <button class="btn btn-info" type="submit" name="editChapter" value="EditChapter">Edit</button>
                <button class="btn btn-info" type="submit" name="deleteChapter" value="DeleterChapter">Delete
                </button>
            </form>
        </div>
        </#list>

    </div>



</@common.html_skileton>