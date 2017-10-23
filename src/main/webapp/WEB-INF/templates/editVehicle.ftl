<!DOCTYPE html>
<html>
<@layout flag="repairs">
    <#import "/spring.ftl" as spring/>
<head>


    <script type='text/javascript' src='http://code.jquery.com/jquery-1.11.0.js'></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript" src="https://formden.com/static/cdn/formden.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/clockpicker/0.0.7/bootstrap-clockpicker.js"></script>


    <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
    <link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/clockpicker/0.0.7/bootstrap-clockpicker.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

    <style>
        h5 {color: red}
    </style>
</head>

<body>
<div class="container">

    <h2 style="color: green; font-weight: bold; font-size: 20px;">${error!""}</h2>
    <#if error??>
    <#else>
    <form class="well form-horizontal" action="/admin/vehicles/edit?id=${vehicleForm.vehicleID}" method="post" id="vehicleForm" name="vehicleForm">

        <div class="form-group">
            <@spring.bind "vehicleForm.plate"/>
            <label class="col-md-4 control-label">Vehicle Plate</label>
            <div class="col-md-4 selectContainer">
                <div class="col-md-12 input-group">
                    <input  name="plate" id="plate" value="${vehicleForm.plate!""}" placeholder="Vehicle Plate" class="form-control"  type="text">
                </div>
                <#list spring.status.errorMessages as error>
                    <h5>${error}</h5>
                </#list>
            </div>
        </div>


        <div class="form-group">
            <@spring.bind "vehicleForm.model"/>
            <label class="col-md-4 control-label">Model</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="col-md-12 input-group">
                    <input  name="model" id="model" value="${vehicleForm.model!""}" placeholder="Model" class="form-control"  type="text">
                </div>
                <#list spring.status.errorMessages as error>
                    <h5>${error}</h5>
                </#list>
            </div>
        </div>

        <div class="form-group">
            <@spring.bind "vehicleForm.color"/>
            <label class="col-md-4 control-label">Color</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="col-md-12 input-group">
                    <input  name="color" id="color" value="${vehicleForm.color!""}" placeholder="Color"  class="form-control"  type="text">
                </div>
                <#list spring.status.errorMessages as error>
                    <h5>${error}</h5>
                </#list>
            </div>
        </div>

        <div class="form-group">
            <@spring.bind "vehicleForm.year"/>
            <label class="col-md-4 control-label">Year</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="col-md-12 input-group ">
                    <input name="year" id="year" placeholder="Year" value="${vehicleForm.year!""}" class="form-control"  type="text">
                </div>
                <#list spring.status.errorMessages as error>
                    <h5>${error}</h5>
                </#list>
            </div>
        </div>

        <div hidden="hidden" class="form-group">
            <@spring.bind "vehicleForm.ownerAfm"/>
            <label class="col-md-4 control-label">Year</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="col-md-12 input-group ">
                    <input name="ownerAfm" id="ownerAfm" value="${vehicleForm.ownerAfm!"123456789"}" placeholder="Year" hidden="hidden" class="form-control"  type="text">
                </div>
                <#list spring.status.errorMessages as error>
                    <h5>${error}</h5>
                </#list>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4"><br>
                <button type="submit" class="btn pull-right btn-warning" >Add Vehicle</button>
            </div>
        </div>


    </form>
    </#if>
</div><!-- /.container -->
</@layout>
</body>
</html>