<!DOCTYPE html>
<html>
<body>
<@layout flag="home" >
<div class="container">

    <p><div><button type="button" style="margin:10px"  class="btn btn-warning pull-right" id="createBtn" onClick="location.href='/admin/vehicles/new'" >Add New Vehicle</button>
</div></p>

    <h4 style=" font-weight: bold; font-size: 20px;">Vres ena repair</h4>
    <div class="row">


        <form action="/admin/repairs/search" method="get" name="searchForm">

            <div class="form-group ">

                <div class="col-md-2 inputGroupContainer">
                    <div class="col-md-12 input-group ">
                        <input  type="text" class="form-control" name="afm" placeholder="Enter afm">
                        <span class="input-group-btn">
                                       <button type="submit" class="btn btn-default">Submit</button>
                                    </span>


                    </div>


                </div>
            </div>

        </form>



        <form action="/admin/repairs/search" method="get" name="searchForm">
            <div class="form-group">

                <div class="col-md-2 inputGroupContainer">
                    <div class="col-md-12 input-group ">
                        <input type="text" class="form-control" name="vehiclePlate" placeholder="ABC-1234">
                        <span class="input-group-btn">
                                    <button type="submit" class="btn btn-default">Submit</button>
                                    </span>
                    </div>


                </div>
            </div>

        </form>
    </div>
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