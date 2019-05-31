<#import "parts/common.ftl" as skilet>
<#import "parts/userHeader.ftl" as header>

<@skilet.html_skileton>
    <@header.userHeader/>


    <form action="/user/createFanfic" method="post">
        <input type="text" name="fanficName" placeholder="Fanfic Name">
        <textarea name="fanficDescription" placeholder="Short Description"></textarea>

        <div>
            <label for="crime">Crime<input type="checkbox" name="CRIME" id="crime"></label>
            <label for="adventure">Adventure<input type="checkbox" name="ADVENTURE" id="adventure"></label>
            <label for="fantasy">Fantasy<input type="checkbox" name="FANTASY" id="fantasy"></label>
            <label for="gothic">Gothic<input type="checkbox" name="GOTHIC" id="gothic"></label>
            <label for="historical">Historical<input type="checkbox" name="HISTORICAL" id="historical"></label>
            <label for="horror">Horror<input type="checkbox" name="HORROR" id="horror"></label>
            <label for="science">Science<input type="checkbox" name="SCIENCE" id="science"></label>
            <label for="thriller">Thriller<input type="checkbox" name="THRILLER" id="thriller"></label>
            <label for="western">Western<input type="checkbox" name="WESTERN" id="western"></label>

            <#--<#list genres as genre>-->
                <#--<label for="id-${genre?if_exists}">-->
                    <#--<input type="checkbox" name="${genre?if_exists}"-->
                           <#--id="id-${genre?if_exists}" ${user.genres?seq_contains(genre)?string("checked","")}>${genre?if_exists}-->
                <#--</label>-->
            <#--</#list>-->
        </div>
        <button type="submit">Create</button>
    </form>





</@skilet.html_skileton>