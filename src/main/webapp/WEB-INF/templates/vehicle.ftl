<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />

</head>
<body>
<@layout flag="vehicles" >
<#import "/spring.ftl" as spring/>
<div class="container">

   <div class="row">
       <button type="button" style="margin:10px"  class="btn btn-warning pull-right" id="createBtn" onClick="location.href='/admin/vehicles/new'" ><i class="fa fa-plus"></i>  Add New Vehicle</button>

   </div>

   <div class="row ">
                   <form  class="form-inline" action="/admin/vehicle/search" method="get" name="searchVehicle" id="searchVehicle">

                              <div class="form-group pull-right">
                              <@spring.bind "searchVehicle.searchText"/>
                              <div class="col-lg-12 inputGroupContainer">
                                <div class="col-md-12 input-group   ">
                                      <input  type="text" class="form-control" id= "searchText" name="searchText" placeholder="Search by AFM or Plate">
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
            <th>Vehicle Plate</th>
            <th>Model</th>
            <th>Year</th>
            <th>Color</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
            <#list vehicles as item>
            <tr>
                <th scope="row">${item?counter}</th>
                <td>${item.plate}</td>
                <td>${item.model}</td>
                <td>${item.year}</td>
                <td>${item.color}</td>

                <td><a href="/admin/vehicles/edit?id=${item.id}"><image src="/edit.png" class=" "/></a></td>
                <td><a href="/admin/repairs/delete/${item.id}" m><image src="/delete.png" class=" "/></a></td>

            </tr>
            </#list>

        </tbody>
    </table>
</div>
</@layout>
</body>
</html>