$(document).ready(function(){
	    var text;
	    var rules = new Array();
		var url = location.search; //获取url中"?"符后的字串
		if (url.indexOf("?") != -1) { //判断是否有参数
		var str = url.substr(1); //从第一个字符开始 因为第0个是?号 获取所有除问号的所有符串
		strs = str.split("="); //用等号进行分隔 （因为知道只有一个参数 所以直接用等号进分隔 如果有多个参数 要用&号分隔 再用等号进行分隔）
		path = strs[1]; //直接弹出第一个参数 （如果有多个参数 还要进行循环的）
		path = decodeURI(path);
		var rule3 ={
				name:null,
				text:null,
				location :path
		}
		post= JSON.stringify(rule3);
		 $.ajax({
				url : "ReturnText",
				dataType : "json",
				method : "POST",		
				data : post,
				contentType : "application/json; charset=utf-8",
				error : function(json, textStatus, errorMessage) {
					alert("加载失败，原因为：" + errorMessage);
				},
				success : function(json) {
					rules = json.rules;	
					var rule = new Object();
					rule.text = rules[0].text;	
			        text = rule.text;
		        $("#textarea").html(text);
				}

		})
		
		}	
})

$("#btnCreateRule").click(function createRule() {
	
	
	var ttxt = $("#textarea").val();
	var rule = {			
	    name : null,
		text : ttxt,
		location:path
	};
	alert(rule.text);
	var post = JSON.stringify(rule);
	$.ajax({
		url : "CreateRule",
		dataType : "json",
		method : "POST",
		data : post,
		async : false,
		contentType : "application/json; charset=utf-8",
		error : function(json, textStatus, errorMessage) {
			alert("连接失败，原因为：" + errorMessage);
		},
		success : function(json) {
			if (json.result == "success")
				alert("生成成功！");

			if (json.result == "false")
				alert("生成失败");
		}

	})
})