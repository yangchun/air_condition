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
		var lim = role[i].limits;
		var liml = lim.length;
		var val="";
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
			+role[i].roledesc+"</td><td>"+val+"</td><td>"+role[i].state+"</td><td>"+
			"<button type='button' class='btn btn-primary btn-xs' onclick='popchRole(this)'>编辑</button> "+
		    "<button type='button' class='btn btn-primary btn-xs' onclick=''>删除</button> "+
			"</td></tr>";
	}
	$("#editable").find("tbody").append(str);
	
}
//弹出添加新角色窗口
function popchRole(btn) {
    var bh = $("body").height();
    var bw = $("body").width();
    $("#fullbg").css({
        height:bh,
        width:bw,
        display:"block"
    });
    $("#changeRole").show();
    //使弹出的窗口获取当前行的角色信息
    var td = $(btn).parent().parent().find("td");
    var tdl = td.length;
    var inp = $("#changeRole").find("input");
    for(var i=0;i<tdl-1;i++){
    	if(i>2){
    		var str1 = td.eq(i+1).text()
    		inp.eq(i).val(str1);
    	}else{
    		var str2 = td.eq(i).text();
    		inp.eq(i).val(str2);
    	}
    	
    }
    
}
function closechRole() {
    $("#fullbg,#changeRole").hide();
}

//


