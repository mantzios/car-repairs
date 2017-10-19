<!DOCTYPE html>
<html>
<body>
<@layout flag="owners" >
<div class="container">

    <p><div><button type="button" style="margin:10px"  class="btn btn-warning pull-right" id="createBtn" onClick="location.href='/admin/owners/new'" >Add New Owner</button>
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
                    <a href="/admin/edit/repair?id=${item.ownerID}"><image src="/edit.png" class=" "/></a>
                </td>
                <td>
                    <a href="/admin/repairs/delete/${item.ownerID}"><image src="/delete.png" class=" "/></a>
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