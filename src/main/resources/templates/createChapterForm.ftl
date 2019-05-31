<#import "parts/common.ftl" as skilet>
<#import "parts/userHeader.ftl" as header>

<@skilet.html_skileton>
    <@header.userHeader/>

<div class="container">
    <form action="/user/composition/${composition.id}/createChapter" method="post">
        <input type="text" name="chapterName" placeholder="Chapter Name" required>
        <input type="number" name="chapterNumber" min="1" placeholder="Chapter Number" required>
        <textarea name="chapterText" id="mytextarea">...add chapter text here...</textarea>
        <div>


            <#--<#list genres as genre>-->
                <#--<label for="id-${genre?if_exists}">-->
                    <#--<input type="checkbox" name="${genre?if_exists}"-->
                           <#--id="id-${genre?if_exists}" ${user.genres?seq_contains(genre)?string("checked","")}>${genre?if_exists}-->
                <#--</label>-->
            <#--</#list>-->
        </div>
        <button type="submit">Create</button>
    </form>

</div>




</@skilet.html_skileton>