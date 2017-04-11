//页面初始化
window.onload = function(){
	$.ajax({
		url:"../limit/getAllLimits",
		type:"POST",
		success:function back(data){
			addData(data);
		},
		error:function back(){
			alert("加载信息失败!");
		}
	});
}
function addData(lidata){
	var r = JSON.parse(lidata);
	var lilist = r.data,
		len = lilist.length,
		str;
	
	for(var i=0;i<len;i++){
		if(lilist[i].state==1){
			lilist[i].state = "正常";
		}else{
			lilist[i].state ="禁用";
		}
		str+="<tr><td class='hid'>"+lilist[i].id+"</td><td>"
		+lilist[i].limitcode+"</td><td>"
		+lilist[i].limitdesc+"</td><td>"
		+lilist[i].state+"</td><td>"
		+"<button type='button' class='btn btn-xs btn-primary' onclick='popchlimit(this)'>编辑</button> "
		+"<button type='button' class='btn btn-xs btn-primary'>删除</button>"
		+"</td></tr>";
	}
	$("#editable").find("tbody").append(str);
	$("editable").find("tbody>tr").each(function(){
		$(this).find('tr eq:(3)').Text()=="正常"?
			$(this).find('tr eq:(3)').css("color","black")
			:$(this).find('tr eq:(3)').css("color","red");
	})
}

//添加新权限
function addNewLimit() {
    var bh = $("body").height();
    var bw = $("body").width();
    $("#fullbg").css({
        height:bh,
        width:bw,
        display:"block"
    });
    $("#addNewLimit").show();
}
function closeNewLimit() {
    $("#fullbg,#addNewLimit").hide();
}

//添加xin权限信息
function addlimitinfo(){
	var json1={
		"limitcode":$("#addNewLimit").find("input[name='limitcode']").val(),
		"limitdesc":$("#addNewLimit").find("input[name='limitdesc']").val()
	};
	$.ajax({
		type:"POST",
		url:"../limit/getAllLimits",
		data:json1,
		dataType:"json",
		success:function back(data){
			var str;
			str+="<tr><td>"+json1.limitcode+"</td><td>"
				+json1.limitdesc+"</td><td>"+"正常"+"</td><td>"
				+"<button class='btn btn-xs btn-primary' type='button' onclick='popchlimit(this)'>编辑</button> "
				+"<button class='btn btn-xs btn-primary' type='button'>删除</button>"
				+"</td></tr>";
			$("#editable").find("tbody").append(str);
			alert("添加权限成功！");
			var r = JSON.parse(data);
			
		},
		error:function back(){
			alert("添加权限失败！");
		}
	});
	
}

//弹出编辑权限信息窗口
function popchlimit(btn){
	var bh = $("body").height();
    var bw = $("body").width();
    $("#fullbg").css({
        height:bh,
        width:bw,
        display:"block"
    });
    $("#changeLimit").show();
    
    //时弹出的编辑信息窗口含有当前所在行权限信息
    var inpval = $("#changeLimit").find("input");
    var td = $(btn).parent().parent().find("td");
    var tdl = td.length;
    for(var i=0;i<tdl-1;i++){
    	inpval.eq(i).val(td.eq(i).text());
    }
}
//关闭权限信息编辑窗口
function closechlimit(){
	$("#fullbg,#changeLimit").hide();
}
//修改权限信息
function chlimitinfo(){
	var str = $("#changeLimit").find("input[name='state']").val();
	if(str=="正常"){
		str=1;
	}else{
		str=0;
	}
	var json2 = {
		"id":$("#changeLimit").find("input[name='limitid']").val(),
		"limitcode":$("#changeLimit").find("input[name='limitcode']").val(),
		"limitdesc":$("#changeLimit").find("input[name='limitdesc']").val(),
		"state":str
	}
	alert(JSON.stringify(json2));
	$.ajax({
		
		url:"../limit/updateLimitInfo",
		type:"POST",
		data:json2,
		dataType:"json",
		success:function back(data){
			/*var r = JSON.parse(data);
			//var tdl = $("#editable").find("tbody tr:eq(0) td").length;
			var tr = $("#editable").find("tbody>tr");
			var trl = tr.length;
			for(var j=0;j<trl;j++){
				var td0=tr.eq(j).find("td:eq(0)");
				if(td0==json.id){
						if(json.state==1){
							json.state="正常";
						}else{
							json.state = "禁用";
						}
					//for(var m=0;m<tdl-1;m++){
						tr.eq(j).find("td").eq(0).text(json.id);
						tr.eq(j).find("td").eq(1).text(json.limitcode);
						tr.eq(j).find("td").eq(2).text(json.limitdesc);
						tr.eq(j).find("td").eq(3).text(json.state);
						
					//}
				}
			}*/
		},
		error:function(){
			alert("修改权限失败！");
		}
	})
	
}

//删除权限
function delLimit(btn){
	var tr = $(btn).parent().parent
	tr.remove();
}


















