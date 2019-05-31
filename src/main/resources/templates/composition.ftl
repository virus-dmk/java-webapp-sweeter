<#import "parts/common.ftl" as skileton>
<#import "parts/userHeader.ftl" as header>

<@skileton.html_skileton>
    <@header.userHeader/>

    <div class="container">

        <div>${(composition.compos_name)?if_exists}</div>
        <div>${(composition.description)?if_exists}</div>
        <a class="btn btn-info" href="/user/composition/${composition.id}/createChapterPage" name="createChapter" value="AddChapter">Create chapter</a>
        <#list chapters as chapter>
            <div>
                <div>Chapter name: ${chapter.chapter_name}</div>
                <div>Chapter number: ${chapter.chapter_number}</div>
                <a class="btn btn-info" href="/user/composition/chapter/${chapter.id}">Open</a>

            </div>
        </#list>


    </div>


</@skileton.html_skileton>