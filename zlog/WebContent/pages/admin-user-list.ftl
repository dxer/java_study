<a data-toggle="modal" href="#myModal" class="btn btn-primary btn-large">+ Add New Admin</a>
<!-- Modal -->
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">添加用户</h3>
  </div>
  <div class="modal-body">
  	<form class="form-horizontal" id="userForm">
	<div class="control-group">
		<label class="control-label" for="inputEmail">UserName</label>
		<div class="controls">
			<input class="span9" type="text" name="userName" placeholder="UserName">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="inputEmail">Email</label>
		<div class="controls">
			<input class="span9" type="text" placeholder="test@example.com" name="email" >
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="inputPassword">Password</label>
		<div class="controls">
			<input class="span9" type="password" id="inputPassword" name="password" placeholder="Password">
		</div>
	</div>
	</form>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true" onclick="reset()">Close</button>
    <button class="btn btn-primary" onclick="saveModal()">Save</button>
  </div>
</div>
<div class="clear"></div>
<br>
<div class="bs-docs-example">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#编号</th>
				<th>用户名</th>
				<th>邮箱</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<#list list as user>
				<tr>
					<td>${user_index + 1}</td>
					<td>${user.userName}</td>
					<td>${user.email}</td>
					<td>
						<button type="button" class="btn btn-mini btn-primary" onclick="updateUser(${user.id?string('#')});"">Update</button>&nbsp;&nbsp
						<button type="button" class="btn btn-mini btn-danger" onclick="delUser(${user.id?string('#')});">Delete</button>		
					</td>
				</tr>
			</#list>
		</tbody>
	</table>
</div>