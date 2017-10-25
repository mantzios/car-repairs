<!DOCTYPE html>
<html>
<@layout flag="owners" >
    <#import "/spring.ftl" as spring/>
<head>

<link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />
    <link rel="stylesheet"  type="text/css" href="/style.css"/>



</head>

<body>

<div class="container">
    <h3>${delete!""}</h3>
<div class="row">
    <button type="button" style="margin:10px"  class="btn btn-warning pull-right" id="createBtn" onClick="location.href='/admin/owners/new'" ><i class="fa fa-plus"></i>  Add New Owner</button>

</div>
<div class="row ">
                <form  class="form-inline" action="/admin/owners/search" method="get" name="searchOwner">

                           <div class="form-group pull-right">
                           <@spring.bind "searchOwner.searchText"/>
                           <div class="col-md-12 inputGroupContainer">
                             <div class="col-md-12 input-group   ">
                                   <input  type="text" class="form-control" name="searchText" placeholder="Search by AFM or Email">
                                      <span class="input-group-btn">
                                        <button type="submit" class="btn btn-default pull-right "><i class="fa fa-search"></i></button>
                                      </span>
                               </div>
                             </div>
                           </div>
                 </form>


</div>
</div>
<div class="container">
<h4 style=" font-weight: bold; font-size: 18px; color: red;">${message!""}</h4>
</div>
<div class="container" style="margin-top:50px">

    <table class="table table-hover">
        <thead>
        <tr>
            <th>#</th>
            <th>AFM</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Access</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <#if owners??>
            <#list owners as item>
            <tr>
                <th scope="row">${item?counter}</th>
                <td>${item.afm}</td>
                <td>${item.firstName!""}</td>
                <td>${item.lastName!""}</td>
                <td>${item.email}</td>
                <td>${item.access}</td>

                <td>
                    <a href="/admin/owners/edit?id=${item.ownerID}"><image src="/edit.png" class=" "/></a>
                </td>
                <td>
                    <a href="/admin/owners/delete/${item.ownerID}"><image src="/delete.png" class=" "/></a>
                </td>

            </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</div>
</@layout>
</body>

</html>
