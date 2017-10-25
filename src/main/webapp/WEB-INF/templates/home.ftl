<!DOCTYPE html>
 <html>
 <@layout flag="home" >
 <#import "/spring.ftl" as spring/>
 <head>

 <link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />
     <link rel="stylesheet"  type="text/css" href="/style.css" />

 </head>
<body>

<div class="container">

<p><div><button type="button" style="margin:10px"  class="btn btn-warning pull-right" id="createBtn" onClick="location.href='/admin/repairs'" >Add New Repair</button>
</div></p>

<h4 style=" font-weight: bold; font-size: 20px;">${message!""}</h4>
    <h3>${delete!""}</h3>
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
<div class="container">
<form class="form-inline pull-right" action="/admin/home/search" method="get" id="searchRepairByDate" name="searchRepairByDate">
 <@spring.bind "searchRepairByDate.dateStart"/>
            <div class="form-group ">

                    <div class="col-md-12 input-group">
                        <div class="input-group-addon">
                            <i class="fa fa-calendar">
                            </i>
                        </div>
                        <input class="form-control" id="dateStart" name="dateStart" type="date"/>

                </div>

            </div>
            <div class="form-group">
                <@spring.bind "searchRepairByDate.dateEnd"/>
                <div class="col-md-1">
                    <div class="col-md-12 input-group">

                        <input class="form-control" id="dateEnd" name="dateEnd"  type="date"/>
                        <span class="input-group-btn">
                            <button type="submit" class="btn btn-default pull-right "><i class="fa fa-search"></i></button>
                         </span>
                    </div>
                </div>
                <#list spring.status.errorMessages as error>
                <span>${error}</span>
                </#list>
            </div>

        </form>
</div>
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
        <th>Vehicle Plate</th>
        <th>Owner</th>
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
           <td>${item.vehicle.plate}</td>
           <td>${item.owner.lastname!""}</td>
           <td><a href="/admin/edit/repair?id=${item.id}"><image src="/edit.png" class=" "/></a></td>
           <td><a href="/admin/repairs/delete/${item.id}" m><image src="/delete.png" class=" "/></a></td>

       </tr>
       </#list>

    </tbody>
</table>
</div>
</@layout>
</body>
</html>
