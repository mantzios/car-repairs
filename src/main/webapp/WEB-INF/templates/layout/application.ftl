<#macro layout flag>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>


</head>
<body>
<div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
      <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Booo</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="<#if flag=="home">active</#if>"><a href="/admin/home">Home</a></li>
      <li class="<#if flag=="owners">active</#if>"><a href="/admin/owners">Owners</a></li>
      <li class="<#if flag=="repairs">active</#if>"><a href="/admin/repairs">Repairs</a></li>
    </ul>
  </div>
  </div>
</nav>

  <#nested>
</div>

</body>
</html>
</#macro>