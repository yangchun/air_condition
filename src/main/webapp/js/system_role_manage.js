//页面初始化
$(function(){
	$.ajax({
		url:"../role/getAllRolesList",
		type:"post",
		success:function back(data){
			addrolelist(data);
		},
		error:function(){
			alert("加载信息失败!");
		}
	})
});

function addrolelist(data){
	var r = JSON.parse(data);
	var  role = r.data,str;
	var len = role.length;
	for(var i=0;i<len;i++){
		var lim = role[i].limits,liml = lim.length,val;
		for(var j=0;j<liml;j++){
			val+=lim[j].limitcode+",";
		}
		val = val.substr(0,val.length-1);
		if(role[i].state==1){
			role[i].state="正常";
		}else{
			role[i].state = "禁用";
		}
		str+="<tr><td class='hid'>"+role[i].id+"</td><td>"+role[i].rolename+"</td><td>"
			+role[i].roledesc+"</td><td>"+val+"</td><td>"+role[i].state+"</td><td>"
	}
	
	
}
//弹出添加新角色窗口
function popchRole() {
    var bh = $("body").height();
    var bw = $("body").width();
    $("#fullbg").css({
        height:bh,
        width:bw,
        display:"block"
    });
    $("#changeRole").show();
}
function closechRole() {
    $("#fullbg,#changeRole").hide();
}



