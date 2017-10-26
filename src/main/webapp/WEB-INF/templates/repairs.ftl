<!DOCTYPE html>
<html>
<@layout flag="repairs">
    <#import "/spring.ftl" as spring/>
<head>


    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript" src="https://formden.com/static/cdn/formden.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/clockpicker/0.0.7/bootstrap-clockpicker.js"></script>


    <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
    <link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/clockpicker/0.0.7/bootstrap-clockpicker.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
    <link rel="stylesheet"  type="text/css" href="/style.css" />


</head>

<body>
<div class="container">

    <h3 style="color: green; font-weight: bold; font-size: 20px;">${error!""}</h3>
<#--<#if error??>-->
<#--<#else>-->

    <form class="well form-horizontal" action="/admin/repairs" method="post" id="createRepairForm" name="createRepairForm">

        <div class="form-group">
            <@spring.bind "createRepairForm.datetime"/>
            <label class="control-label col-md-4 requiredField" for="date">Date</label>

            <div class="col-md-4">
                <div class="col-md-12 input-group">
                    <div class="input-group-addon">
                        <i class="fa fa-calendar">
                        </i>
                    </div>
                    <input class="form-control" id="datetime" name="datetime" value= "${createRepairForm.datetime!""}"  placeholder="select date.." type="text"/>
                </div>
                <div class="col-sm-12">
                    <small  class="text-danger">
                        <#list spring.status.errorMessages as error>${error}</#list>
                    </small>
                </div>
            </div>

        </div>

        <div class="form-group">
            <@spring.bind "createRepairForm.time"/>
            <label class="control-label col-md-4 ">Time</label>
            <div class="col-md-4">
                <div class="col-md-12 input-group clockpicker">
                    <div class="input-group-addon">
                        <i class="fa fa-clock-o" style="font-size:16px">
                        </i>
                    </div>
                    <input type="text" class="form-control" id="time" name="time"  value= "${createRepairForm.time!""}" placeholder="select time..">
                </div>
                <div class="col-sm-12">
                    <small  class="text-danger">
                        <#list spring.status.errorMessages as error>${error}</#list>
                    </small>
                </div>
            </div>


        </div>
        <div class="form-group">
            <@spring.bind "createRepairForm.status"/>
            <label class="col-md-4 control-label">Status</label>
            <div class="col-md-4 selectContainer">
                <div class="col-md-12 input-group">
                    <select name="status" id="status" class="form-control selectpicker">
                        <option value= "" >Select status</option>
                        <option>New</option>
                        <option>In Progress</option>
                        <option >Completed</option>
                    </select>
                </div>
                <div class="col-sm-12">
                    <small  class="text-danger">
                        <#list spring.status.errorMessages as error>${error}</#list>
                    </small>
                </div>

            </div>
        </div>


        <div class="form-group">
            <@spring.bind "createRepairForm.cost"/>
            <label class="col-md-4 control-label">Cost</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="col-md-12 input-group">
                    <input  name="cost" id="cost" placeholder="Cost" class="form-control"  value= "${createRepairForm.cost!""}" type="text">
                </div>
                <div class="col-sm-12">
                    <small  class="text-danger">
                        <#list spring.status.errorMessages as error>${error}</#list>
                    </small>
                </div>

            </div>
        </div>

        <div class="form-group">
            <@spring.bind "createRepairForm.afm"/>
            <label class="col-md-4 control-label">Owner's AFM</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="col-md-12 input-group">
                    <input  name="afm" id="afm" placeholder="afm" class="form-control"  value= "${createRepairForm.afm!""}"type="text">
                </div>
                <div class="col-sm-12">
                    <small  class="text-danger">
                        <#list spring.status.errorMessages as error>${error}</#list>
                    </small>
                </div>
            </div>

        </div>

        <div class="form-group">
            <@spring.bind "createRepairForm.plate_num"/>
            <label class="col-md-4 control-label ">Plate Number</label>
            <div class="col-md-4 inputGroupContainer ">
                <div class="col-md-12 input-group">
                    <input  name="plate_num" id="plate_num" placeholder="ABC-1234" value= "${createRepairForm.plate_num!""}" class="form-control "  type="text">
                </div>
                <div class="col-sm-12">
                    <small  class="text-danger">
                        <#list spring.status.errorMessages as error>${error}</#list>
                    </small>
                </div>

            </div>
        </div>

        <div class="form-group">
            <@spring.bind "createRepairForm.type"/>
            <label class="col-md-4 control-label">Type</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="col-md-12 input-group ">
                    <input name="type" id="type" placeholder="Type" class="form-control"  value= "${createRepairForm.type!""}"type="text">
                </div>
                <div class="col-sm-12">
                    <small  class="text-danger">
                        <#list spring.status.errorMessages as error>${error}</#list>
                    </small>
                </div>
            </div>
        </div>

        <div class="form-group">
            <@spring.bind "createRepairForm.textarea"/>
            <label class="col-md-4 control-label">Comments</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="col-md-12 input-group">
                    <textarea class="form-control col-md-12" rows="5" name="textarea" value= "${createRepairForm.textarea!""}" id="textarea" placeholder="Add your comment here.."></textarea>
                </div>
                <div class="col-sm-12">
                    <small  class="text-danger">
                        <#list spring.status.errorMessages as error>${error}</#list>
                    </small>
                </div>

            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4"><br>
                <button type="submit" class="btn pull-right btn-warning" >Add Repair</button>
            </div>
        </div>


    </form>
<#--</#if>-->
</div><!-- /.container -->
</@layout>
</body>
</html>

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

</script>

