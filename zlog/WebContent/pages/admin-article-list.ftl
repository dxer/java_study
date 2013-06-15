<div>
	<table class="table table-hover table-condensed">
		<tr>
			<th width="8%">编号</th>
			<th>姓名</th>
			<th>邮箱</th>
			<th>管理员</th>
			<th>操作</th>
		</tr>

		<#list list as user>
			<tr>
				<td>${user_index + 1}</td>
				<td>${user.userName}</td>
				<td>${user.userName}</td>
				<td>${user.userName}</td>
				<td>
					<a href="#" >update</a>
					<a href="#" >delete</a> 
				</td>
			</tr>
		</#list>
	</table>
</div>

<div class="pagination">
  		<ul>
    		<li><a href="#">Prev</a></li>
    		<li><a href="#">1</a></li>
    		<li><a href="#">2</a></li>
    		<li><a href="#">3</a></li>
    		<li><a href="#">4</a></li>
    		<li><a href="#">5</a></li>
    		<li><a href="#">Next</a></li>
  		</ul>
	</div>