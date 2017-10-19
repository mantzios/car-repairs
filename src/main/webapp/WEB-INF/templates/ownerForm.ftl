<!DOCTYPE html>
<html>
<@layout flag="repairs">
    <#import "/spring.ftl" as spring/>
<head>


    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

    <!-- Include Date Range Picker -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>

    <script type="text/javascript" src="https://formden.com/static/cdn/formden.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/clockpicker/0.0.7/bootstrap-clockpicker.min.js"></script>
    <!-- Special version of Bootstrap that is isolated to content wrapped in .bootstrap-iso -->
    <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />

    <!--Font Awesome (added because you use icons in your prepend/append)-->
    <link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/clockpicker/0.0.7/bootstrap-clockpicker.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>


</head>

<body>
<div class="container">

    <h3 style="color: green; font-weight: bold; font-size: 20px;">${message!""}</h3>

    <form class="well form-horizontal" action="/admin/owners/new" method="post" id="ownerForm" name="ownerForm">

        <div class="form-group">
            <@spring.bind "ownerForm.firstName"/>
            <label class="col-md-4 control-label">First Name</label>
            <div class="col-md-4 selectContainer">
                <div class="col-md-12 input-group">
                    <input  name="firstName" id="firstName" placeholder="First Name" class="form-control"  type="text">
                </div>
                <#list spring.status.errorMessages as error>
                    <span>${error}</span>
                </#list>
            </div>
        </div>


        <div class="form-group">
            <@spring.bind "ownerForm.lastName"/>
            <label class="col-md-4 control-label">Last Name</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="col-md-12 input-group">
                    <input  name="lastName" id="lastName" placeholder="Last Name" class="form-control"  type="text">
                </div>
                <#list spring.status.errorMessages as error>
                    <span>${error}</span>
                </#list>
            </div>
        </div>

        <div class="form-group">
            <@spring.bind "ownerForm.afm"/>
            <label class="col-md-4 control-label">Afm</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="col-md-12 input-group">
                    <input  name="afm" id="afm" placeholder="afm" class="form-control"  type="text">
                </div>
                <#list spring.status.errorMessages as error>
                    <span>${error}</span>
                </#list>
            </div>
        </div>

        <div class="form-group">
            <@spring.bind "ownerForm.access"/>
            <label class="col-md-4 control-label">Access</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="col-md-12 input-group ">
                    <input name="access" id="access" placeholder="Access" class="form-control"  type="text">
                </div>
                <#list spring.status.errorMessages as error>
                    <span>${error}</span>
                </#list>
            </div>
        </div>

        <div class="form-group">
            <@spring.bind "ownerForm.email"/>
            <label class="col-md-4 control-label">Email</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="col-md-12 input-group">
                    <input name="email" id="email" placeholder="Email" class="form-control"  type="email">
                </div>
                <#list spring.status.errorMessages as error>
                    <span>${error}</span>
                </#list>
            </div>
        </div>

        <div class="form-group">
            <@spring.bind "ownerForm.password"/>
            <label class="col-md-4 control-label">Password</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="col-md-12 input-group ">
                    <input name="password" id="password" placeholder="Access" class="form-control"  type="password">
                </div>
                <#list spring.status.errorMessages as error>
                    <span>${error}</span>
                </#list>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4"><br>
                <button type="submit" class="btn pull-right btn-warning" >Add Repair</button>
            </div>
        </div>


    </form>

</div><!-- /.container -->
</@layout>
</body>
</html>

<#--
<script>
    $(document).ready(function(){
        var date_input=$('input[name="datetime"]'); //our date input has the name "date"
        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
        date_input.datepicker({
            format: 'dd/mm/yyyy',
            container: container,
            todayHighlight: true,
            autoclose: true,
        })


        var time_input=$('input[name="time"]');
        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
        time_input.clockpicker({

            container: container,
            autoclose: true,

        })
    })
</script>-->

