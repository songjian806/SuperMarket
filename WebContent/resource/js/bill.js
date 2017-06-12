
$().ready(function(){
	init();
});

function init(){
	checkAll();
	show();
	modify();
	del();
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
		var productName = $("input[name=productName]").val();
		var payStatus = $("select[name=payStatus]").val();
		if(productName==""|payStatus==""){
			alert("查找内容不能为空");
		}else{
			var parm = {action:'search',productName:productName,payStatus:payStatus};
			$.post("MarketServlet",parm,function(data){			
				if("ERROR"==data){
					alert("未查询到结果");
				}else{
					var obj = jQuery.parseJSON(data);
					$.each(obj,function(i,item){
						$temp = $("#mainDiv").children();
						$temp.remove();
						$("#mainDiv").append(							
 							 "<tr>"+
								"<td>全选<input type='checkbox' name='' id='check' ></td>"+
								"<td>账单编号</td>"+
								"<td>商品名称</td>"+
								"<td>商品数量</td>"+
								"<td>交易金额</td>"+
								"<td>是否付款</td>"+
								"<td>供应商名称</td>"+
								"<td>商品描述</td>"+
								"<td>账单时间</td>"+		
							 "</tr>"+			
									
							 "<tr>"+
								"<td><input type='checkbox' name='checkSub' value='"+item.uid+"'></td>"+
								"<td>"+item.no+"</td>"+
								"<td>"+item.name+"</td>"+
								"<td>"+item.goodSum+"</td>"+
								"<td>"+item.tradeMoney+"</td>"+
								"<td>"+((item.pay)==true?'是':'否')+"</td>"+
								"<td>"+item.suppliersName+"</td>"+
								"<td>"+item.goodsDescription+"</td>"+
								"<td>"+item.time+"</td>"+
							 "</tr>"		
							);
					});
				}
			});		
		}
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
			$.post("MarketServlet",parm,function(data){
				if("OK"==data){
					alert("删除成功");
					window.location = "imassage.jsp";					
				}else{
					alert("删除失败");
				}
			});
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
			var spUuid = $("input:checkbox:checked").val();
			var no = s.eq(0).text();
			var name = s.eq(1).text();
			var goodSum = s.eq(2).text();
			var tradeMoney = s.eq(3).text();
			var isPay = s.eq(4).text();
			var suppliersName = s.eq(5).text();
			var goodsDescription = s.eq(6).text();
			var time = s.eq(7).text();
			
			$("body").remove();
			$("html").append(
					
			  "<div class='main'>"+
			  "<div class='optitle clearfix'>"+
			  "<div class='title'>修改账单&gt;&gt;</div>"+
		      "</div>"+
		      "<form action='MarketServlet?action=modify' method='post'>"+
			    "<div class='content'>"+
				"<table class='box'>"+
					"<tr>"+
						"<input type='hidden' name='uid' value='"+spUuid+"'/>"+
					    "<td class='field'>商品名称：</td>"+
						"<td><input type='text' name='goodName' class='text' value='"+name+"'/></td>"+
					"</tr>"+
					"<tr>"+
					    "<td class='field'>商品数量：</td>"+
						"<td><input type='text' name='goodSum' class='text' value='"+goodSum+"'/></td>"+
					"</tr>"+
					"<tr>"+
						"<td class='field'>账单编号：</td>"+
						"<td><input type='text' name='billNum' class='text' value='"+no+"'/></td>"+
					"</tr>"+
					"<tr>"+
						"<td class='field'>账单时间：</td>"+
						"<td><input type='text' name='billTime' class='text' value='"+time+"'/></td>"+
					"</tr>"+
					"<tr>"+
						"<td class='field'>供应商：</td>"+
						"<td><input type='text' name='suppliers' class='text' value='"+suppliersName+"'/></td>"+
					"</tr>"+
					"<tr>"+
						"<td class='field'>交易金额：</td>"+
						"<td><input type='text' name='money' class='text' value='"+tradeMoney+"'/></td>"+
					"</tr>"+
					"<tr>"+
						"<td class='field'>商品描述：</td>"+
						"<td><textarea name='discription'>"+goodsDescription+"</textarea></td>"+
					"</tr>"+
					"<tr>"+
						"<td class='field'>是否付款：</td>"+
						"<td><select name='isPay'>"+
							"<option value='1' >是</option>"+
							"<option value='0' >否</option>"+
						"/select></td>"+
					"</tr>"+
				"</table>"+
			"</div>"+
			"<div class='buttons'>"+
				"<input type='submit' name='submit' value='确认' class='input-button'/>"+
				"<input type='button' name='button' value='返回' class='input-button' onclick=''/>"+
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

function show(){
	var parm = {action:'show'};
	$.post("MarketServlet",parm,function(data){
		var obj = jQuery.parseJSON(data);
		$.each(obj,function(i,item){
			$("#mainDiv").append(
					 "<tr>"+
						"<td><input type='checkbox' onclick='changeCheckAll()' name='checkSub' value='"+item.uid+"'></td>"+
						"<td>"+item.no+"</td>"+
						"<td>"+item.name+"</td>"+
						"<td>"+item.goodSum+"</td>"+
						"<td>"+item.tradeMoney+"</td>"+
						"<td>"+((item.pay)==true?'是':'否')+"</td>"+
						"<td>"+item.suppliersName+"</td>"+
						"<td>"+item.goodsDescription+"</td>"+
						"<td>"+item.time+"</td>"+
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


function updata(){
	var id=1,flag = 0,index;
	var s= document.getElementsByName("checkSub");
	for(var i = 0;i<s.length;i++){
		if(s[i].checked==true){
			flag++;
			index = i;
		}
	}
	
	if(flag==1){
		id = s[index].value;
		window.location = "MarketServlet?action=updata&updateuuid="+id;
	}else if(flag == 0){
		alert("你未选择要删除的数据");
	}else{
		alert("每次只能选择一项");
	}
}



