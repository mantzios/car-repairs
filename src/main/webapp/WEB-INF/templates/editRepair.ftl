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
    <link rel="stylesheet"  type="text/css" href="/style.css" />

</head>
<body>
 <div class="container">
    <h3 style="color: green; font-weight: bold; font-size: 20px;">${error!""}</h3>

        <form class="well form-horizontal" action="/admin/edit/repair?id=${repair.id_repair}" method="post" id="editRepairForm" name="editRepairForm">
            <div class="form-group">
                <@spring.bind "repair.datetime"/>
                <label class="control-label col-md-4 requiredField" for="date">Date</label>
                <div class="col-md-4">
                    <div class="col-md-12 input-group">
                        <div class="input-group-addon">
                            <i class="fa fa-calendar">
                            </i>
                        </div>
                        <input class="form-control" id="datetime" name="datetime" placeholder="select date.." type="text"/>
                    </div>
                </div>
                 <div class="col-sm-12">
                                    <small  class="text-danger">
                                        <#list spring.status.errorMessages as error>
                                            <div>${error}</div>
                                        </#list>
                                    </small>
                                </div>
            </div>


             <div class="form-group">
                            <@spring.bind "repair.time"/>
                            <label class="control-label col-md-4 ">Time</label>
                            <div class="col-md-4">
                                <div class="col-md-12 input-group clockpicker">
                                    <div class="input-group-addon">
                                        <i class="glyphicon glyphicon-time">
                                        </i>
                                    </div>
                                        <input type="text" class="form-control" id="time" name="time" placeholder="select time..">
                                </div>
                            </div>
                             <div class="col-sm-12">
                                                <small  class="text-danger">
                                                    <#list spring.status.errorMessages as error>
                                                        <div>${error}</div>
                                                    </#list>
                                                </small>
                                            </div>
            </div>



            <div class="form-group">
                <@spring.bind "repair.status"/>
                <label class="col-md-4 control-label">Status</label>
                <div class="col-md-4 selectContainer">
                    <div class="col-md-12 input-group">
                        <select name="status" id="status" class="form-control selectpicker">
                            <option <#if "${repair.status}"=="Pending">selected</#if> >Pending</option>
                            <option <#if "${repair.status}"=="In Progress">selected</#if> >In Progress</option>
                            <option <#if "${repair.status}"=="Completed">selected</#if>>Completed</option>
                        </select>
                    </div>

                </div>
            </div>
            <div class="form-group">
                <@spring.bind "repair.cost"/>
                <label class="col-md-4 control-label">Cost</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="col-md-12 input-group">
                        <input  name="cost" id="cost" placeholder="Cost" class="form-control"  type="text">
                    </div>
                     <div class="col-sm-12">
                                        <small  class="text-danger">
                                            <#list spring.status.errorMessages as error>
                                                <div>${error}</div>
                                            </#list>
                                        </small>
                                    </div>
                </div>
            </div>
            <div class="form-group">
                <@spring.bind "repair.type"/>
                <label class="col-md-4 control-label">Type</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="col-md-12 input-group ">
                        <input  name="type" id="type" placeholder="Type" class="form-control"  type="text">
                     </div>
                     <div class="col-sm-12">
                                        <small  class="text-danger">
                                            <#list spring.status.errorMessages as error>
                                                <div>${error}</div>
                                            </#list>
                                        </small>
                                    </div>
                </div>
            </div>
            <div class="form-group">
                <@spring.bind "repair.textarea"/>
                <label class="col-md-4 control-label">Comments</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="col-md-12 input-group">
                        <textarea  class="form-control col-md-12" rows="5" name="textarea" id="textarea" placeholder="Add your comment here.."></textarea>
                    </div>
                      <div class="col-sm-12">
                                         <small  class="text-danger">
                                             <#list spring.status.errorMessages as error>
                                                 <div>${error}</div>
                                             </#list>
                                         </small>
                                     </div>
                </div>
            </div>
            <div class="form-group">
            <label class="col-md-4 control-label"></label>
                <div class="col-md-4"><br>
                    <button type="submit" class="btn pull-right btn-warning" >Save Changes</button>
                </div>
            </div>
        </form>

    </div>
 </div><!-- /.container -->

</@layout>
</body>
</html>

<script>
    $(document).ready(function(){
    		var date_input=$('input[name="datetime"]');
    		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
    		date_input.datepicker({
    			format: 'dd/mm/yyyy',
    			container: container,
    			todayHighlight: true,
    			autoclose: true,
    		});
    		var time_input=$('input[name="time"]');
            		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
            		time_input.clockpicker({

            		container: container,
                     autoclose: true,

            		});
    	});

       document.getElementById("datetime").value= "${repair.datetime}" ;
       document.getElementById("time").value= "${repair.time}" ;
       document.getElementById("cost").value= "${repair.cost}";
       document.getElementById("type").value= "${repair.type}";
       document.getElementById("textarea").value= "${repair.textarea}";
</script>