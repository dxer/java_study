$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};

function addUser() {
	var jsonuserinfo = $.toJSON($('#form').serializeObject());
	jQuery.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : 'addUser.html',
		data : jsonuserinfo,
		dataType : 'json',
		success : function(data) {
			setSection("user-list");
		},
		error : function() {
			alert("error");
		}
	});
}

function delUser(id) {
	if (confirm("确定要删除该记录？")) {
		var url = "delUser.html?id=" + id;
		$.get(url, function(data) {
			if (data == "success") {
				setSection("user-list");
			}
		});
	}

	// jQuery.ajax({
	// type : 'POST',
	// contentType : 'application/json',
	// url : 'delUser.html/' + id,
	// dataType : 'json',
	// success : function(data) {
	// alert("11111111111111111111111");
	// },
	// error : function(data) {
	// alert(data);
	// }
	// });
}

function updateUser(id) {
	alert("update");
}

function reset() {
	$('#userForm :input').each(function() {
		$(this).val('');
	});
}

function validation() {
	$('#userForm :input').each(function() {
		if ($(this).val() == "" || $(this).val().length <= 0) {
			
		}
	});
}

function saveModal() {
	validation();
	var jsonuserinfo = $.toJSON($('#userForm').serializeObject());
	jQuery.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : 'addUser.html',
		data : jsonuserinfo,
		dataType : 'json',
		success : function(data) {
			$('#myModal').modal('hide');
			setSection("user-list");
		},
		error : function() {
			alert("error");
		}
	});
}