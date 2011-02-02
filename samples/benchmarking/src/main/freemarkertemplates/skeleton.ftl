<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>${title}</title>
</head>
<body>
<#if loggedInUser??>
<div id="userBox">
    Hello ${loggedInUser.userName}, You have ${loggedInUser.friends.size()} friends
</div>
</#if>

<h1>Entries</h1>
<#if (entries.size() > 0)>
<#list entries as entry>
<div>
    Entry Id: ${entry.entryId}, Date ${entry.entryDate?datetime}
    <h2>${entry.title}</h2>
    <div>Submitted By: ${entry.owner.userName} - ${entry.owner.email}</div>
    <div>${entry.body}</div>
    <#if (entry.comments.size() > 0)>
    <#list entry.comments as comment>
    <div>
        <div>Comment by: ${comment.owner.userName}</div>
        <div>${comment.commentText}</div>
    </div>
    </#list>
    <#else>
    <div>No comments yet</div>
    </#if>
</div>
</#list>
<#else>
<div>
    <td colspan="4">No Entries Found</td>
</div>
</#if>
</body>
</html>