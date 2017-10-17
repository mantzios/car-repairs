<!DOCTYPE html>
<html>
<body>
<@layout flag="home" >
<div class="container">

<button type="button" style="margin:10px"  class="btn btn-warning pull-right" id="createBtn" onClick="location.href='/admin/repairs'" >Add New Repair</button>
<div class="container">
<div class="row">
<form action="/admin/repairs/search" method="get" name="searchForm">
   <label for="afm">Search by AFM</label>
   <input type="text" class="form-control" name="afm" placeholder="Enter afm">
   <button type="submit" class="btn btn-default">Submit</button>
</form>
   <form action="/admin/repairs/search" method="get" name="searchForm">
   <label for="vehiclePlate">Vehicle Plate</label>
   <input type="text" class="form-control" name="vehiclePlate" placeholder="ABC-1234">
       <button type="submit" class="btn btn-default">Submit</button>
   </form>


</div>

</div>

<table class="table table-hover">
    <thead>
    <tr>
        <th>#</th>
        <th>Date</th>
        <th>Type</th>
        <th>Status</th>
        <th>Cost</th>
        <th>Description</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
       <#list repairs as item>
       <tr>
           <th scope="row">${item?counter}</th>
           <td>${item.datetime}</td>
           <td>${item.type}</td>
           <td>${item.status}</td>
           <td>${item.cost}</td>
           <td>${item.textarea}</td>
           <td><a href="/admin/edit/repair?id=${item.id}"><image src="/edit.png" class=" "/></a></td>
           <td><a href="/admin/repairs/delete/${item.id}"><image src="/delete.png" class=" "/></a></td>

       </tr>
       </#list>

    </tbody>
</table>
</div>
</@layout>
</body>
</html>