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
	var el = $("#addNewUser").find("input[type='text']"),
		sel = $("#addNewUser").find("select option:selected"),
		arr1 = new Array(),
		arr2 = new Array();
	var json={
		id:sel.attr("id")
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
	var datas = JSON.stringify(json);
	alert(datas);
	$.ajax({
		type:"POST",
		url:"../user/addNewUser",
		data:datas,
		dataType:"json",
		sucess:function back(data){
			alert(data);
		},
		error:function back(){
			alert("添加用户失败!");
		}
	});
	//在页面上添加新用户
	var html = "<tr><td class='hidinfo'>"+json.id+"</td><td>"+json.username+"</td><td class='hidinfo'>"+json.password+"</td><td>"
		+sel.val()+"</td><td>"+
		json.realname+"</td><td>"+json.email+"</td><td>"+"正常"+"</td><td>"+
		"<button type='button' class='btn btn-primary btn-xs' onclick='adjust(),addrol(this)'>编辑</button> "+
	    "<button type='button' class='btn btn-primary btn-xs' onclick='deluser(this)'>删除</button> "+
		"</td></tr>";
	$("#editable").find("tbody").append(html);
		
	
}


//删除用户
function deluser(btn){
	$(btn).parents("tr").remove();
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
	var inp = $("dialog").find("input"),arr = new Array();
	var td=$(btn).parent().parent().find("td:lt(7)");
	//$.each(td,function(){
		arr.push(td.text());
	//});
	
}

//编辑用户信息
function changedialog(){
	
	
	
	
}






