
$(document).ready(function(){
	init();
	
});

function init(){
	show();//显示所有教师信息
	checkAll();//全选
	del();
	modify();
	comqury();
}

function comqury(){
	$("#comqury").unbind();
	$("#comqury").bind("click",function(){
		var providerName = $("input[name=providerName]").val();
		var providerDesc = $("input[name=providerDesc]").val();
		if(providerName==""|providerDesc==""){
			alert("查找内容不能为空");
		}else{

			var parm = {action:'comqury',providerName:providerName,providerDesc:providerDesc};
			$.post("SupplierServlet",parm,function(data){
				var obj = jQuery.parseJSON(data);
				$.each(obj,function(i,item){
					$temp = $("#mainDiv").children();
					$temp.remove();
					$("#mainDiv").append(
														
							"<tr>"+
							  "<td>全选<input type='checkbox'  id='check' ></td>"+
							    "<td width='70' height='29'><div class='STYLE1' align='center'>编号</div></td>"+
							    "<td width='80'><div class='STYLE1' align='center'>供应商名称</div></td>"+
							    "<td width='100'><div class='STYLE1' align='center'>供应商描述</div></td>"+
							    "<td width='100'><div class='STYLE1' align='center'>联系人</div></td>"+
							    "<td width='100'><div class='STYLE1' align='center'>电话</div></td>"+
							    "<td width='100'><div class='STYLE1' align='center'>地址</div></td>"+
							  "</tr>"+
														
							"<tr>"+
							"<td><input type='checkbox' name='checkSub' class='sub' value='"+item.spUUID+"'></td>"+
							"<td>"+item.spId+"</td>"+	
							"<td>"+item.spName+"</td>"+
							"<td>"+item.spDescription+"</td>"+
							"<td>"+item.spContacts+"</td>"+
							"<td>"+item.spPhone+"</td>"+
							"<td>"+item.spAddress+"</td>"+
							"</tr>"
					);
				});
				
			});
		
		}
	});
}

function show(){
	var parm = {id:'2'};
	$.post("SupplierServlet",parm,function(data){
		var obj = jQuery.parseJSON(data);
		$.each(obj,function(i,item){
			$("#mainDiv").append(
					"<tr>"+
					"<td><input type='checkbox' name='checkSub' class='sub' onclick='changeCheckAll()' value='"+item.spUUID+"'></td>"+
					"<td>"+item.spId+"</td>"+	
					"<td>"+item.spName+"</td>"+
					"<td>"+item.spDescription+"</td>"+
					"<td>"+item.spContacts+"</td>"+
					"<td>"+item.spPhone+"</td>"+
					"<td>"+item.spAddress+"</td>"+
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

function modify(){

	$("#modifyButton").unbind;
	$("#modifyButton").bind("click",function(){
		var sub = $("input[type='checkbox'][name='checkSub']");
		var num = 0;
		for (var i = 0; i < sub.length; i++) {
			if(sub.get(i).checked == true){
				num++;
			}
		}
		if(num==1){
			var s = $("input:checkbox:checked").parent().siblings();
			var spUuid = $("input:checkbox:checked").val();
			var spId = s.eq(0).text();
			var spName = s.eq(1).text();
			var spDescription = s.eq(2).text();
			var spContacts = s.eq(3).text();
			var spPhone = s.eq(4).text();
			var spAddress = s.eq(5).text();
			
			$("body").remove();
			$("html").append(								
					"<body>"+
					"<div class='main'>"+
					"<div class='optitle clearfix'>"+
						"<div class='title'>供应商管理&gt;&gt修改数据</div>"+
					"</div>"+
					"<form id='form1' name='form1' method='post' action='SupplierServlet?action=modify'>"+
						"<div class='content'>"+
							"<font color='red'></font> <input name='flag' value='doAdd' type='hidden'>"+
							"<table class='box'>"+
								"<tbody>"+
									"<tr>"+
										"<td class='field'>供应商编号：<input type='hidden' name='spUuid' id='spuuid' value='"+spUuid+"'></td>"+							
										"<td><input name='spId' id='textfield' class='text' value='"+spId+"' type='text'> <font color='red'*</font></td>"+
									"</tr>"+
									"<tr>"+
										"<td class='field'>供应商名称：</td>"+
										"<td><input name='spName' id='textfield2' value='"+spName+"' class='text'  type='text'> <font color='red'>*</font></td>"+
									"</tr>"+
									"<tr>"+
										"<td class='field'>供应商描述：</td>"+
										"<td><textarea name='spDescription' id='textarea' cols='45' rows='5'>"+spDescription+"</textarea></td>"+
									"</tr>"+
									"<tr>"+
										"<td class='field'>供应商联系：</td>"+
										"<td><input name='spContacts' id='textfield3' value='"+spContacts+"' class='text' type='text'></td>"+
									"</tr>"+
									"<tr>"+
										"<td class='field'>供应商电话：</td>"+
										"<td><input name='spPhone' id='textfield4' value='"+spPhone+"' class='text' type='text'></td>"+
									"</tr>"+		
									"<tr>"+
										"<td class='field'>供应商地址：</td>"+
										"<td><input name='spAddress' id='textfield5' value='"+spAddress+"' class='text' type='text'></td>"+
									"</tr>"+
								"</tbody>"+
							"</table>"+
						"</div>"+
						"<div class='buttons'>"+
							"<input name='button id='submit' value='提交' class='input-button' type='submit'>"+ 
							"<input name='button' id='button' value='返回' class='input-button' type='button'>"+
						"</div>"+
					"</form>"+
				"</div></body>"
							
			);
			
		}else if(num==0){
				alert("你未选择数据");
		}else{
			alert("一次只能修改一条数据");
		}
	});

}

function del(){
	$("input[name='del']").unbind();
	$("input[name='del']").bind("click",function(){
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
			$.post("SupplierServlet",parm,function(data){
				if("OK"==data){
					alert("删除成功");
					window.location = "sp_imassage.jsp";					
				}else{
					alert("删除失败");
				}
			});
		}
	});
}


