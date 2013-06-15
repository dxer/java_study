<div id="form"><br>
	<label><h5>标题</h5></label>
	<input class="input-xxlarge" type="text" name="articleTitle" > 
	<label><h5>正文</h5></label>
	<textarea name="content" style="width:800px;height:500px;visibility:hidden;resize:none">
	</textarea>
	<p>
		<input type="button" name="getHtml" value="取得HTML" />
		<input type="button" name="isEmpty" value="判断是否为空" />
		<input type="button" name="getText" value="取得文本(包含img,embed)" />
		<input type="button" name="selectedHtml" value="取得选中HTML" />
		<br /><br />
		<input type="button" name="setHtml" value="设置HTML" />
		<input type="button" name="setText" value="设置文本" />
		<input type="button" name="insertHtml" value="插入HTML" />
		<input type="button" name="appendHtml" value="添加HTML" />
		<input type="button" name="clear" value="清空内容" />
		<input type="reset" name="reset" value="Reset" />
	</p><br>
	<label><h5>标签（使用英文输入状态下的逗号进行分隔）：</h5></label>
    <form class="navbar-form pull-left">
    	<input type="text" class="input-xxlarge">
        <button type="" class="btn">Choose</button>
    </form>
    <br><br>
    <button type="button" class="btn btn-primary">Primary</button>
</div>