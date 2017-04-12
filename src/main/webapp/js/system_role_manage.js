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
			"<button type='button' class='btn btn-primary btn-xs' onclick='popchRole(this);addrolim(this);'>编辑</button> "+
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
    //添加权限接口
    $.ajax({
    	url:"../limit/getAllLimits",
    	type:"post",
    	success:function back(data){
    		
    		var r = JSON.parse(data);
    		var lim = r.data,str;
    		var liml = lim.length;
    		
    		for(var m=0;m<liml;m++){
    			str+="<option id='"+lim[m].id+"'>"+lim[m].limitcode+"</option>";
    		}
    		$("#changeRole").find("select option").remove();
    		$("#changeRole").find("select").append(str);
    		
    		var arr=new Array();
    	    arr=$(btn).parent().parent().find("td").eq(3).text().split(",");
    	    var arrl = arr.length;
    	    var op=$("#changeRole").find("select option");
    	    var opl = op.length  //为什么获取不到option的长度
    	   
    	    for(var t=0;t<opl;t++){
    	    	for(var n=0;n<arrl;n++){
    	    		if(op.eq(t).val()==arr[n]){
    	    			op.eq(t).attr("selected",true);
    	    		}
    	    	}
    	   	
    	    } 
    		
    	},
    	error:function(){
    		alert("添加参数失败");
    	}
    });
    
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
//关闭编辑信息窗口
function closechRole() {
    $("#fullbg,#changeRole").hide();
}

//将编辑信息打包成json，发给后台
function changeroleinfo(){
	var str = $("#changeRole").find("input[name='state']").val();
	if(str=="正常"){
		str=1;
	}else{
		str=0;
	}
	var sl = $("#changeRole").find("option:selected").length;
	var arr=new Array();
	for(var i=0;i<sl;i++){
		arr[i]= {"id":$("#changeRole").find("option:selected").eq(i).attr("id")};
	
	}
	
	var json2 = {
		"role_id":$("#changeRole").find("input[name='role_id']").val(),
		"rolename":$("#changeLimit").find("input[name='rolename']").val(),
		"roledesc":$("#changeLimit").find("input[name='roledesc']").val(),
		"state":str
	};
	json2.limits = arr;
	alert(JSON.stringify(json2));
	$.ajax({
		
		url:"../limit/updateLimitInfo",
		type:"POST",
		data:json2,
		dataType:"json",
		success:function back(data){
			//var tdl = $("#editable").find("tbody tr:eq(0) td").length;
			var tr = $("#editable").find("tbody>tr");
			var trl = tr.length;
			for(var j=0;j<trl;j++){
				var td=tr.eq(j).find("td:eq(0)");
				var td0 = td.text();
				if(td0==json2.id){
						if(json2.state==1){
							json2.state="正常";
							tr.eq(j).find("td").eq(3).css("color","black");
						}else{
							json2.state = "禁用";
							tr.eq(j).find("td").eq(3).css("color","red");
						}
					
						tr.eq(j).find("td").eq(0).text(json2.id);
						tr.eq(j).find("td").eq(1).text(json2.rolename);
						tr.eq(j).find("td").eq(2).text(json2.roledesc);
						tr.eq(j).find("td").eq(3).text(json2.state);
						alert("修改角色成功");
						
					
				}
			}
		},
		error:function(){
			alert("修改权限失败！");
		}
	});
	
}





//删除角色
function delRole(btn){
	var tr = $(btn).parent().parent();
	var json={
			"roleid":tr.find("td:eq(0)").text()
	};
	var msg = "您真的要删除该角色吗？";
	if(confirm(msg)==true){
		$.ajax({
			url:"../role/delRoleById",
			type:"POST",
			data:json,
			dataType:"json",
			success:function back(data){
				tr.remove();
			},
			error:function(){
				alert("删除角色失败");
			}
		});
	}else{
		return false;
	}
	
}



