$().ready(function(){
	
	init();
	});
     
function init(){
	show();
}

function show(){

	var s2 = window.location.search;	
	var s = decodeURI(s2);
	alert(s);
	var arr = s.substring(1).split(",");
	$.each(arr,function(i,n){
		if(i==0){
			$("#spuuid").val(n);
		}
	    else if(i==1){
			$("input[name='spId']").val(n);
		}else if(i==2){
			$("input[name='spName']").val(n);
		}else if(i==3){
			$("textarea[name='spDescription']").text(n);
		}else if(i==4){
			$("input[name='spContacts']").val(n);
		}else if(i==5){
			$("input[name='spPhone']").val(n);
		}else{
			$("input[name='spAddress']").val(n);
		}
	});

}


