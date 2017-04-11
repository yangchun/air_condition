window.onload = function(){
	$.ajax({
		url:"../user/getAllUser",
		type:"POST",
		success:function back(item){
			addData(item);
		},
		error:function back(){
			alert("系统提示：获取信息失败");
		}
		
	});
	
}


function addData(data){
	var r = JSON.parse(data);
	var str;
	var list=r.data;
	for(var i=0;i<list.length;i++){
			if(list[i].state==1){
				list[i].state="正常";
			}else{
				list[i].state = "禁用";
			}
			str+="<tr class='gradex'><td class='hidinfo'>"+list[i].id+"</td><td>"+list[i].username+"</td><td class='hidinfo'>"+list[i].password+"</td><td>"+list[i].rolename+"</td><td>"+list[i].realname+
			"</td><td>"+list[i].email+"</td><td>"+list[i].state+"</td><td>"+
			"<button type='button' class='btn btn-xs btn-primary' onclick='adjust();addrol(this);'>编辑</button> "+
			"<button type='button' class='btn btn-xs btn-primary' onclick='deluser(this)'>删除</button>"+
			"</td></tr>";
	}	
	var table = $("#editable");
	table.find("tbody").append(str);
	table.find("tbody>tr").each(function(){
		$(this).find("td:eq(4)").text()=="禁用"?
				$(this).find("td:eq(4)").css("color","red")
				:$(this).find("td:eq(4)").css("color","black");		
	})
		
}


//显示灰色 jQuery 遮罩层
    function adjust() {
        var bh = $("body").height();
        var bw = $("body").width();
        $("#fullbg").css({
            height:bh,
            width:bw,
            display:"block"
        });
        $("#dialog").show();
        
    }
//关闭灰色 jQuery 遮罩 
function closedialog() {
    $("#fullbg,#dialog").hide();
}
function addNewUser() {
    var bh = $("body").height();
    var bw = $("body").width();
    $("#fullbg").css({
        height:bh,
        width:bw,
        display:"block"
    });
    $("#addNewUser").show();
    
  //添加角色接口
     $.ajax({
	    url:"../role/getAllRolesName",
	    type:"POST",
		success:function(data){
			addra(data);
		},
	  	error:function(){
	  	    alert("获取信息失败！");
	  	}
	});
	  
	function addra(data){
		 var r = JSON.parse(data);
		 var rolist=r.data,
		 len=rolist.length,
		 rol;
		 for(var i=0;i<len;i++){
			 rol+="<option id='"+rolist[i].id+"'>"+rolist[i].rolename+"</option>";
		 }
		 $("#addNewUser").find("select").append(rol);
	 }
}
function closeNewUser() {
    $("#fullbg,#addNewUser").hide();
    
}
function closeNewUser() {
    $("#fullbg,#addNewUser").hide();
}


//添加新用户信息
function addUserInfo(){
	var el = $("#addNewUser").find("input"),
		sel = $("#addNewUser").find("select option:selected"),
		arr1 = new Array(),
		arr2 = new Array();
	var json={
		role_id:sel.attr("id")
	};
	$.each(el,function(){
		var s = $(this);
		arr1.push(
		s.attr("name")	
	);
		arr2.push(
			s.val()
		);
	}); 
	
	for(var m=0;m<arr1.length+1;m++){
		json[arr1[m]] = arr2[m];
	}
	 
	//传添加的新用户信息给后台（数据格式为json）	
	$.ajax({
		type:"POST",
		url:"../user/addNewUser",
		data:json,
		dataType:"json",
		success:function back(data){
			//var ss=$("#addNewUser").find("select option:selected");
			//在页面上添加新用户
			var html;
			html= "<tr><td>"+json.username+"</td><td class='hidinfo'>"+json.password+"</td><td>"
			+sel.val()+"</td><td>"+json.realname+"</td><td>"+json.email+"</td><td>"+"正常"+"</td><td>"+
			"<button type='button' class='btn btn-primary btn-xs' onclick='adjust(),addrol(this)'>编辑</button> "+
		    "<button type='button' class='btn btn-primary btn-xs' onclick='deluser(this)'>删除</button> "+
			"</td></tr>";
			$("#editable").find("tbody").append(html);
			alert("添加用户信息成功！");
		},
		error:function back(){
			alert("添加用户失败!");
		}
	});
	
	
		
	
}


//删除用户
function deluser(btn){
	var tr = $(btn).parent().parent();
	$.ajax({
		url:"../user/delUserById",
		type:"GET",
		data:{userid:tr.find("td:eq(0)").text()},
		dataType:'json',
		success:function(data){
			var msg = "您真的要删除该用户吗？";
			if(confirm(msg)==true){
				tr.remove();
			}else{
				return false;//有bug
			}
		},
		error:function(){
			alert("删除用户失败！");
		}
	})
	
	
}

//添加角色接口
function addrol(btn){
	$.ajax({
		url:"../role/getAllRolesName",
		type:"POST",
		success:function(data){
			var r = JSON.parse(data);
			var rolist = r.data,
			len = rolist.length,
			sel;
			for(var i=0;i<len;i++){
				sel +="<option id='"+rolist[i].id+"'>"+rolist[i].rolename+"</option>"; 
			}
			$("#dialog").find("select").append(sel);
		},
		error:function(){
			alert("加载数据失败！");
		}
	});
	//点击编辑用户信息时，弹出窗口显示当前用户信息
	var inp = $("#dialog").find("input"),arr = new Array();
	var td = $(btn).parent().parent().find("td");
	var tdl=td.length;
	for(var n=0;n<tdl-2;n++){
		if(n>2){
			var str1 = td.eq(n+1).text();
			inp.eq(n).val(str1);
		}else{
			var str2 = td.eq(n).text()
			inp.eq(n).val(str2);
		};	
	}
	var str = td.eq(3).text();
	switch(str){
		case "系统管理人员":
			$("#dialog").find("select option[id='1']").attr("selected",true);break;
		case "系统维护人员":
			$("#dialog").find("select option[id='2']").attr("selected",true);break;
		case "客户管理员":
			$("#dialog").find("select option[id='3']").attr("selected",true);break;
		case "客户用户":
			$("#dialog").find("select option[id='4']").attr("selected",true);break;
	}
	
}

//编辑用户信息
function changedialog(add){
	var inval = $("#dialog").find("input"),
	arr1 = new Array(),arr2 = new Array(),
	json={
		role_id:$("#dialog").find("select option:selected").attr("id")
	};
	$.each(inval,function(){
		var s=$(this);
		arr1.push(s.attr("name"));
		arr2.push(s.val());
	});
	for(var i=0;i<arr1.length;i++){
		if(arr2[i]=="正常"){
			arr2[i]=1;
		}else if(arr2[i]=="禁用"){
			arr2[i]=0;
		}
		json[arr1[i]] = arr2[i];
	}
	//将修改的用户信息封装成json传给后台
	$.ajax({
		url:"../user/updateUserInfo",
		type:"POST",
		data:json,
		dataType:"json",
		success:function back(data){
			var tr = $("#editable").find("tbody>tr");
			var trl = tr.length;
			for(var j=0;j<trl;j++){
				var td=tr.eq(j).find("td:eq(0)");
				var td0 = td.text();
				if(td0==json.userid){
						if(json.state==1){
							json.state="正常";
						}else{
							json.state = "禁用";
						}
					//for(var m=0;m<tdl-1;m++){
						tr.eq(j).find("td").eq(0).text(json.userid);
						tr.eq(j).find("td").eq(1).text(json.username);
						tr.eq(j).find("td").eq(2).text(json.password);
						tr.eq(j).find("td").eq(4).text(json.realname);
						tr.eq(j).find("td").eq(5).text(json.email);
						tr.eq(j).find("td").eq(6).text(json.state);
						var str = json.role_id;
						switch(str){
							case "1":
								tr.eq(j).find("td").eq(3).text("系统管理员");break;
							case "2":
								tr.eq(j).find("td").eq(3).text("系统维护人员");break;
							case "3":
								tr.eq(j).find("td").eq(3).text("客户管理员");break;
							case "4":
								tr.eq(j).find("td").eq(3).text("客户用户");break;
						}
						alert("修改信息成功");
						
					//}
				}
			}
		},
		error:function back(){
			alert("修改信息失败!");
		}
	})
}






