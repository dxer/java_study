function creatKE() {
	$.getScript('edit/kindeditor.js', function() {
		$.getScript('edit/lang/zh_CN.js', function() {
			KindEditor.basePath = 'edit/';
			editor = KindEditor.create('textarea[name="content"]', {
				cssPath : 'plugins/code/prettify.css',
				resizeType : 1,
				allowPreviewEmoticons : false,
				allowImageUpload : false
			});
			prettyPrint();

			$('input[name=getHtml]').click(function(e) {
				alert($('input[name=articleTitle]').val());
				alert(editor.html());
			});
			$('input[name=isEmpty]').click(function(e) {
				alert(editor.isEmpty());
			});
			$('input[name=getText]').click(function(e) {
				alert(editor.text());
			});
			$('input[name=selectedHtml]').click(function(e) {
				alert(editor.selectedHtml());
			});
			$('input[name=setHtml]').click(function(e) {
				editor.html('<h3>Hello KindEditor</h3>');
			});
			$('input[name=setText]').click(function(e) {
				editor.text('<h3>Hello KindEditor</h3>');
			});
			$('input[name=insertHtml]').click(function(e) {
				editor.insertHtml('<strong>插入HTML</strong>');
			});
			$('input[name=appendHtml]').click(function(e) {
				editor.appendHtml('<strong>添加HTML</strong>');
			});
			$('input[name=clear]').click(function(e) {
				editor.html('');
			});
		});
	});
}
