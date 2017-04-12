$(function(){
	onload();
});
function onload(){
	$.ajax({
		url:"../equipment/getAllEqs",
		type:"GET",
		success:function back(item){
			initRoomData(item);
		},
		error:function back(){
			alert("系统提示：获取信息失败");
		}
	});
}
function initRoomData(item){
	var r = JSON.parse(item);
	var str;
	var list=r.data;
	for(var i=0;i<list.length;i++){
		var repairtime=""; 
		var eqbuytime = jsTimeToString(list[i].eqbuytime);
		if(list[i].repairtime!=null){
			repairtime = jsTimeToString(list[i].repairtime);
		}
		str+="<tr class='gradeX'><td>"+list[i].id+"</td><td>"+list[i].eqname+"</td><td>"+list[i].eqtype+
		"</td><td>"+eqbuytime+"</td><td>"+repairtime+"</td><td>"+list[i].repairnum+"</td><td>"+
		"<button type='button' class='btn btn-xs btn-primary' onclick='adjust("+list[i].id+")'>编辑</button> "+
		"<button type='button' class='btn btn-xs btn-primary' onclick='delEq(this,"+list[i].id+")'>删除</button>"+
		"</td></tr>";	
	}
	var table = $("#editable");
	table.find("tbody").append(str);
}
function submitNewEquipment(){
	var datas={
		"eqname":$("#newEqName").val(),
		"eqtype":$("#newEqType").val()
	}
	$.ajax({
		type:"POST",
		url:"../equipment/addNewEq",
		data:datas,
		success: function back(data){
			$("#editable tbody").children().remove();
			onload();
	    },
	    error: function back(data){
	    	alert("系统提示","生成全局参数失败");
	    }
	});
	closeNewEquipment();
}
function delEq(br,eqid){
	$(br).parents("tr").remove();
	$.ajax({
		type:"POST",
		url:"../equipment/delEqById?eqid="+eqid,
		dataType:"json",
		success:function back(data){
			alert("删除成功！");
		},
		error:function back(){
			alert("删除失败!");
		}
	});
}
function updateEqInfo(eqid){
	$.ajax({
		url:"../equipment/getEqInfoByEqId?eqid="+eqid,
		type:"GET",
		success:function back(item){
			var r = JSON.parse(item);
			var eqinfo=r.data;
			$("#updateEqId").val(eqinfo.id);
			$("#updateEqName").val(eqinfo.eqname);
			$("#updateEqType").val(eqinfo.eqtype);
			$("#updateEqBuyTime").val(jsTimeToString(eqinfo.eqbuytime));
		},
		error:function back(){
			alert("系统提示：获取信息失败");
		}
	});
}
function submitUpdateEq(){
	var datas={
			"eqid":$("#updateEqId").val(),
			"eqname":$("#updateEqName").val(),
			"eqtype":$("#updateEqType").val()
		}
		$.ajax({
			type:"POST",
			url:"../equipment/updateEqInfo",
			data:datas,
			success: function back(data){
				$("#editable tbody").children().remove();
				onload();
		    },
		    error: function back(data){
		    	alert("系统提示");
		    }
		});
	closedialog();
}

//显示灰色 jQuery 遮罩层
    function adjust(eqid) {
        var bh = $("body").height();
        var bw = $("body").width();
        $("#fullbg").css({
            height:bh,
            width:bw,
            display:"block"
        });
        $("#dialog").show();
        updateEqInfo(eqid);
    }
//关闭灰色 jQuery 遮罩 
function closedialog() {
    $("#fullbg,#dialog").hide();
}
function addNewEquipment() {
    var bh = $("body").height();
    var bw = $("body").width();
    $("#fullbg").css({
        height:bh,
        width:bw,
        display:"block"
    });
    $("#newEquipment").show();
}
function closeNewEquipment() {
    $("#fullbg,#newEquipment").hide();
}
//将js的时间对象转换为字符串yyyyMMddHHssmm     
function jsTimeToString(time){     
    var year=time.year+1900;     
    var month=time.month+1;     
    var day=time.date;     
    var hour=time.hours;     
    var minute=time.minutes;     
    var second=time.seconds;     
    if(month<10){     
        month="0"+month;     
    }     
    if(day<10){     
        day="0"+day;     
    }     
    if(hour<10){     
        hour="0"+hour;     
    }     
    if(minute<10){     
        minute="0"+minute;     
    }     
    if(second<10){     
        second="0"+second;     
    }     
    var strTime = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;      
return strTime;     
}


