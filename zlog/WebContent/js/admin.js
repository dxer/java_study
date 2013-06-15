function analyseHash() {
	var hash = window.location.hash;
	var tag = hash.substr(1, hash.length - 1);
	var tagList = tag.split("/");
	var tags = {};
	tags.page = 1, tags.hashList = [];
	for ( var i = 0; i < tagList.length; i++) {
		if (i === tagList.length - 1 && (/^\d+$/.test(tagList[i]))) {
			tags.page = tagList[i];
		} else {
			tags.hashList.push(tagList[i]);
		}
	}
	return tags;
}

function setCurByHash() {
	var tags = analyseHash();
	tab = "";
	subTab = "";
	if (tags.hashList.length == 1) {
		subTab = tags.hashList[0];
	} else if (tags.hashList.length == 2) {
		tab = tags.hashList[0];
		subTab = tags.hashList[1];
	}
	setSection(subTab);
}

function setSection(subTab) {
	url = "admin-" + subTab + ".html";
	if (subTab == "article") {
		creatKE();
	}
	sid = "#tabsPanel_" + subTab;
	$.ajax({
		url : url,
		success : function(HTML) {
			clearSection();
			$(sid).html(HTML);
		}
	});
}

function clearSection() {
	$("#tabsPanel").children().each(function() {
		var sid = $(this).attr('id');
		$("section[id='" + sid + "']").empty(); // 清除该节点内容
	});
}
