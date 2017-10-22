<!DOCTYPE html>
<html>
<body>
<@layout flag="home" >

<div class="container" style="margin-top:50px">

    <table class="table table-hover">
        <thead>
        <tr>
            <th>#</th>
            <th>Date</th>
            <th>Type</th>
            <th>Status</th>
            <th>Cost</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
            <#if repairsOwners??>
            <#list repairsOwners as item>
            <tr>
                <th scope="row">${item?counter}</th>
                <td>${item.datetime}</td>
                <td>${item.type}</td>
                <td>${item.status}</td>
                <td>${item.cost}</td>
                <td>${item.textarea}</td>
            </tr>
            </#list>
            </#if>
        </tbody>
    </table>
</div>
</@layout>
</body>
</html>