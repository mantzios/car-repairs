<@layout flag="repairs">
<table class="table table-hover">
  <thead>
    <tr>
      <th>#</th>
      <th>Time</th>
      <th>Type</th>
      <th>Status</th>
      <th>Cost</th>
      <th>Description</th>
    </tr>
  </thead>
  <tbody>
<#list repairs as item>

   <tr>
         <th scope="row">1</th>
         <td>${item.datetime}</td>
         <td>${item.status}</td>
         <td>${item.type}</td>
          <td>${item.cost}</td>
          <td></td>
   </tr>
</#list>


  </tbody>
</table>

</@layout>