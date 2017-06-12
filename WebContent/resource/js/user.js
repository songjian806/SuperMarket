	
$().ready(function(){
	init();
});


function init(){
	show();
	checkAll();
	del();
	modify();
	search();
}


function changeCheckAll(){
	var s = document.getElementsByName("checkSub");
	var s2 = document.getElementById("check");
	var flag = 0;
		for(var i=0;i<s.length;i++){
			if(s[i].checked == true){flag++;}
		}
		if(flag == s.length){
			s2.checked = true;
		}else{
			s2.checked = false;
		}
}

function search(){
	$("#search").unbind();
	$("#search").bind("click",function(){
		var userName = $("#searchname").val();

		var parm = {action:'search',userName:userName};
		$.post("UserServlet",parm,function(data){
			
			if("ERROR"==data){
				alert("未查到数据!");
			}else{				
				var obj = jQuery.parseJSON(data);
				$.each(obj,function(i,item){
					$temp = $("#mainDiv").children();
					$temp.remove();
					$("#mainDiv").append(													
							"<tr>"+
						    "<td width='50'>全选<input type='checkbox' name='' id='check' ></td>"+
						    "<td width='70' height='29'><div class='STYLE1' align='center'>编号</div></td>"+
						    "<td width='80'><div class='STYLE1' align='center'>用户名称</div></td>"+
						    "<td width='100'><div class='STYLE1' align='center'>性别</div></td>"+
						    "<td width='100'><div class='STYLE1' align='center'>年龄</div></td>"+
						    "<td width='150'><div class='STYLE1' align='center'>电话 </div></td>"+
						    "<td width='150'><div class='STYLE1' align='center'>地址 </div></td>"+
						    "<td width='100'><div class='STYLE1' align='center'>权限 </div></td>"+
						    "</tr>"+
						    
							"<tr>"+
							"<input type='hidden' id='pwd' value='"+item.password+"'>"+
							"<td><input type='checkbox' value='"+item.userUuid+"' name='checkSub' id='' ></td>"+
						    "<td height='23'><span class='STYLE1'>"+item.userId+"</span></td>"+
						    "<td><span class='STYLE1'><a >"+item.userName+"</a></span></td>"+
						    "<td><span class='STYLE1'>"+item.userSex+"</span></td>"+
						    "<td><span class='STYLE1'>"+item.userAge+"</span></td>"+
						    "<td><span class='STYLE1'>"+item.userPhone+"</span></td>"+
						    "<td><span class='STYLE1'>"+item.userAddress+"</span></td>"+
						    "<td><span class='STYLE1'>1</span></td>"+
						    "</tr>"					
					);
				});
				
			}			
		});
	
	});
}



function del(){
	$("#del").unbind();
	$("#del").bind("click",function(){

		var sub = $("input[type='checkbox'][name='checkSub']");
		var $id=1;
		for (var i = 0; i < sub.length; i++) {
			if(sub.get(i).checked == true){
				$id+=(sub.eq(i).val()+';');
			}
		}
		if($id==1){
			alert("你未选择数据");
		}else{
			var parm = {action:'del',id:$id};
			$.post("UserServlet",parm,function(data){
				if("OK"==data){
					alert("删除成功");
					window.location = "user_imassage.jsp";					
				}else{
					alert("删除失败");
				}
			});
		}
	});
}


function show(){	

	var parm = {action:'init'};
	$.post("UserServlet",parm,function(data){
		var obj = jQuery.parseJSON(data);
		$.each(obj,function(i,item){
			$("#mainDiv").append(
					"<tr>"+
					"<input type='hidden' id='pwd'  value='"+item.password+"'>"+
					"<td><input type='checkbox' onclick='changeCheckAll()' value='"+item.userUuid+"' name='checkSub' id='' ></td>"+
				    "<td height='23'><span class='STYLE1'>"+item.userId+"</span></td>"+
				    "<td><span class='STYLE1'><a >"+item.userName+"</a></span></td>"+
				    "<td><span class='STYLE1'>"+item.userSex+"</span></td>"+
				    "<td><span class='STYLE1'>"+item.userAge+"</span></td>"+
				    "<td><span class='STYLE1'>"+item.userPhone+"</span></td>"+
				    "<td><span class='STYLE1'>"+item.userAddress+"</span></td>"+
				    "<td><span class='STYLE1'>"+item.prior+"</span></td>"+
				    "</tr>"
			);
		});
		
	});
}


function checkAll() {
	$("#check").unbind();
	$("#check").bind("click",function(){
		if($("#check").is(':checked')){
			$("input[name='checkSub']").prop("checked",true);
		}else{
			$("input[name='checkSub']").prop("checked",false);
		}		
	});
}


function modify(){
	$("#modify").unbind;
	$("#modify").bind("click",function(){
		var sub = $("input[type='checkbox'][name='checkSub']");
		var num = 0;
		for (var i = 0; i < sub.length; i++) {
			if(sub.get(i).checked == true){
				num++;
			}
		}
		if(num==1){
			var s = $("input:checkbox:checked").parent().siblings();
			var userUuid = $("input:checkbox:checked").val();
			var userId = s.eq(1).text();
			var userName = s.eq(2).text();
			var password = $("pwd").val();
			var userSex = s.eq(3).text();
			var userAge = s.eq(4).text();
			var userPhone = s.eq(5).text();
			var userAddress = s.eq(6).text();
			
			$("body").remove();
			$("html").append(
			"<body>"+
			"<div class='main'>"+
			"<div class='optitle clearfix'>"+
				"<div class='title'>用户管理&gt;&gt;</div>"+
			"</div>"+
			"<form id='form1' name='form1' method='post' action='UserServlet?action=modify'>"+
				"<div class='content'>"+
					"<table class='box'><font color='red'></font>"+
					"<input type='hidden' name='useruuid' value='"+userUuid+"'>"+
					"<tr>"+
							"<td class='field'>用户编号：</td>"+
							"<td><input type='text' value='"+userId+"' name='userId' id='textfield' class='text'/> <font color='red'>*</font></td>"+
						"</tr>"+
					"<tr>"+
							"<td class='field'>用户名称：</td>"+
							"<td><input type='text' value='"+userName+"' name='username' class='text' id='textfield2'/><font color='red'>*</font></td>"+
						"</tr>"+
						"<tr>"+
							"<td class='field'>用户密码：</td>"+
							"<td><input type='password' value='"+password+"' name='password' class='text' id='textfield2'/> <font color='red'>*</font></td>"+
						"</tr>"+
						"<tr>"+
							"<td class='field'>用户性别：</td>"+
							"<td><select name='sex' id='select'>"+
		                          "<option value='女'>女</option>"+
		                          "<option value='男'>男</option>"+
		                        "</select></td>"+
						"</tr>"+
						"<tr>"+
							"<td class='field'>用户年龄：</td>"+
							"<td><input type='text' name='age' value='"+userAge+"' class='text' id='textfield2'/><font color='red'>*</font></td>"+
						"</tr>"+
						"<tr>"+
							"<td class='field'>用户电话：</td>"+
							"<td><input type='text' name='phone' value='"+userPhone+"' class='text' id='textfield2'/><font color='red'>*</font></td>"+

						"</tr>"+
						"<tr>"+
							"<td class='field'>用户地址：</td>"+
							"<td><textarea name='address' id='textarea' class='text' cols='45' rows='5'>"+userAddress+"</textarea></td>"+
						"</tr>"+
						"<tr>"+
							"<td class='field'>用户权限：</td>"+
							"<td><input type='radio' name='auth' id='auth' value='0' checked='checked'/>普通用户"+
							"<input type='radio' name='auth' id='auth' value='1' />经理</td>"+
						"</tr>"+
					"</table>"+
				"</div>"+
				"<div class='buttons'>"+
					"<input type='submit' name='button' id='button' value='数据提交' class='input-button'/>"+
					"<input type='button' name='button' id='button' value='返回' class='input-button'/>"+ 
				"</div>"+
			"</form>"+
		"</div>"+
		"</body>"
		);
			
		}else if(num==0){
				alert("你未选择数据");
		}else{
			alert("一次只能修改一条数据");
		}
	});

}


