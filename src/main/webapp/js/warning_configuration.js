$(function(){
	onload();
});
function onload(){
	$.ajax({
		url:"../warningconfig/getAllWarning_Config",
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
		var bt="";
		if(list[i].state==1){
			bt="<button type='button' class='btn btn-xs btn-danger' onclick='updateWarnConfigState("+list[i].eqid+",0)'>禁用</button> "
		}else{
			bt="<button type='button' class='btn btn-xs btn-primary' onclick='updateWarnConfigState("+list[i].eqid+",1)'>启用</button> "
		}
		str+="<tr class='gradeX'><td>"+list[i].eqname+"</td><td>"+list[i].warning_temp+"</td><td>"+list[i].warning_power+
		"</td><td>"+list[i].inform_user+"</td><td>"+bt+
		"<button type='button' class='btn btn-xs btn-primary' onclick='adjust("+list[i].eqid+")'>编辑</button>"+
		"</td></tr>";	
	}
	var table = $("#editable");
	table.find("tbody").append(str);
}
function updateWarnConfigState(eqid,state){
	var datas={
			"eqid":eqid,
			"state":state
	}
	$.ajax({
		type:"POST",
		url:"../warningconfig/updateWarning_configstate",
		data:datas,
		success: function back(data){
			$("#editable tbody").children().remove();
			onload();
	    },
	    error: function back(data){
	    	alert("系统提示","生成全局参数失败");
	    }
	});
}

function updateWarningConfig(eqid){
	$.ajax({
		url:"../warningconfig/getWarning_configByEqId?eqid="+eqid,
		type:"GET",
		success:function back(item){
			var r = JSON.parse(item);
			var wcinfo=r.data;
			$("#updateConfigEqId").val(wcinfo.eqid);
			$("#updateConfigEqName").val(wcinfo.eqname);
			$("#updateConfigEqTemp").val(wcinfo.warning_temp);
			$("#updateConfigEqPower").val(wcinfo.warning_power);
			$("#updateConfigEqInformUser").val(wcinfo.inform_user);
		},
		error:function back(){
			alert("系统提示：获取信息失败");
		}
	});
}
function submitUpdateConfig(){
	var datas={
			"eqid":$("#updateConfigEqId").val(),
			"warningTemp":$("#updateConfigEqTemp").val(),
			"warningPower":$("#updateConfigEqPower").val(),
			"informUser":$("#updateConfigEqInformUser").val()
	}
	$.ajax({
		type:"POST",
		url:"../warningconfig/updateWarning_config",
		data:datas,
		success: function back(data){
			$("#editable tbody").children().remove();
			onload();
	    },
	    error: function back(data){
	    	alert("系统提示","生成全局参数失败");
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
        updateWarningConfig(eqid);
}
//关闭灰色 jQuery 遮罩 
function closedialog() {
    $("#fullbg,#dialog").hide();
}
function addNewWarnConfig() {
    var bh = $("body").height();
    var bw = $("body").width();
    $("#fullbg").css({
        height:bh,
        width:bw,
        display:"block"
    });
    $("#newWarnConfig").show();
}
function closeNewWarnConfig() {
    $("#fullbg,#newWarnConfig").hide();
}



