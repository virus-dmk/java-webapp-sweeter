<#import "parts/common.ftl" as skileton>
<#import "parts/userHeader.ftl" as header>

<@skileton.html_skileton>
    <@header.userHeader/>

    <div class="container">
        <a href="/user/composition/${chapter.composition.id}">Back to composition</a>
        <div><b>${(chapter.chapter_name)?if_exists}</b></div>
        <div>${(chapter.chapter_number)?if_exists}</div>
        <div>${(chapter.chapter_text)?if_exists}</div>

        <div>Chapter page numbers</div>

        <#--<#list chapters as chapter>-->

            <#--<div>Chapter name: ${chapter.name}</div>-->
            <#--<div>Chapter number: ${chapter.number}</div>-->
            <#--<a href="/user/composition/chapter/${chapter.id}">Open</a>-->

        <#--</#list>-->


    </div>


</@skileton.html_skileton>