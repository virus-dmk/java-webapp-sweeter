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
        <form action="/user/createFanfic" method="get">
            <button class="btn btn-info" type="submit">Create new Fanfic</button>
        </form>

        <#if compositions??>
            <#list compositions as composition>
            <#--<div class="row">-->
                <p class="composition-name" >${composition.compos_name?if_exists}</p>
                <p class="description">Краткое описание: ${composition.description?if_exists}</p>
                <p class="short-info">Количество глав: </p>
                <span></span>

                <a class="btn btn-info" href="/user/composition/${composition.id}/createChapterPage"
                   name="createChapter" value="AddChapter">Create chapter</a>
                <a class="btn btn-info" href="/user/composition/${composition.id}" name="editChapter">Edit</a>
                <form action="/user/composition/deleteComposition=${composition.id}" method="post">
                    <button class="btn btn-info" type="submit" name="deleteCompositionId" value="${composition.id}">Delete
                    </button>
                </form>
            <#--</div>-->
            </#list>
        </#if>

    </div>



</@common.html_skileton>