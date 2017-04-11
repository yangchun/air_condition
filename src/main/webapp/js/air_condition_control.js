$(function(){
	onload();
});
function onload(){
	$.ajax({
		url:"../room/getAllRooms",
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
		if(list[i].air_speed<=10){
			list[i].air_speed="微风";
		}else if(list[i].air_speed>10&&list[i].air_speed<=20){
			list[i].air_speed="中风";
		}else{
			list[i].air_speed="强风";
		}
		if(list[i].state==1){
			list[i].state="运行";
		}else{
			list[i].state="关闭";
		}
		str+="<tr class='gradeX'><td>"+list[i].room_num+"</td><td>"+list[i].temp+"</td><td>"+list[i].humidity+
		"</td><td>"+list[i].type+"</td><td>"+list[i].air_speed+"</td><td>"+list[i].state+"</td><td>"+
		"<button type='button' class='btn btn-xs btn-primary' onclick='adjust("+list[i].room_num+")'>编辑</button> "+
		"<button type='button' class='btn btn-xs btn-primary' onclick='delRoom(this,"+list[i].room_num+")'>删除</button>"+
		"</td></tr>";
	}
	var table = $("#editable");
	table.find("tbody").append(str);
}
function delRoom(br,room_num){
	$(br).parents("tr").remove();
	$.ajax({
		type:"POST",
		url:"../room/delRoomById?room_num="+room_num,
		dataType:"json",
		success:function back(data){
			alert("删除成功！");
		},
		error:function back(){
			alert("删除失败!");
		}
	});
}
//获取添加房间数据
function addNewRoomData(){
	var state=$("input[type='radio']:checked").val();
	var datas={
		"room_num":	$("#newRoomNum").val(),
		"temp":$("#newRoomTemp").val(),
		"humidity":$("#newRoomHumidity").val(),
		"type":$("#newRoomType").val(),
		"air_speed":$("#newRoomAirSpeed").val(),
		"state":state
	}
	$.ajax({
		type:"POST",
		url:"../room/addNewRoom",
		data:datas,
		success: function back(data){
			$("#editable tbody").children().remove();
			onload();
	    },
	    error: function back(data){
	    	alert("系统提示","生成全局参数失败");
	    }
	});
	closeNewRoom();
}
function updateRoomInfo(room_num){
	$.ajax({
		url:"../room/getGetRoomInfoById?room_num="+room_num,
		type:"GET",
		success:function back(item){
			var r = JSON.parse(item);
			var roominfo=r.data;
			$("#updateRoomNum").val(roominfo.room_num);
			$("#updateRoomTemp").val(roominfo.temp);
			$("#updateRoomHumidity").val(roominfo.humidity);
			$("#updateRoomType").val(roominfo.type);
			$("#updateRoomAirSpeed").val(roominfo.air_speed);
			if(roominfo.state==1){
				$("#roomOn").attr("checked","checked");
			}else{
				$("#roomClose").attr("checked","checked");
			}
		},
		error:function back(){
			alert("系统提示：获取信息失败");
		}
	});
}
function sumbitUpdateRoomInfo(){
	var state=$("input[type='radio']:checked").val();
	var datas={
		"room_num":$("#updateRoomNum").val(),
		"temp":$("#updateRoomTemp").val(),
		"humidity":$("#updateRoomHumidity").val(),
		"type":$("#updateRoomType").val(),
		"air_speed":$("#updateRoomAirSpeed").val(),
		"state":state
	}
	$.ajax({
		type:"POST",
		url:"../room/updateRoomInfo",
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
    function adjust(room_num) {
        var bh = $("body").height();
        var bw = $("body").width();
        $("#fullbg").css({
            height:bh,
            width:bw,
            display:"block"
        });
        $("#dialog").show();
        updateRoomInfo(room_num);
    }
//关闭灰色 jQuery 遮罩 
function closedialog() {
    $("#fullbg,#dialog").hide();
}
function addNewRoom() {
    var bh = $("body").height();
    var bw = $("body").width();
    $("#fullbg").css({
        height:bh,
        width:bw,
        display:"block"
    });
    $("#newRoom").show();
}
function closeNewRoom() {
    $("#fullbg,#newRoom").hide();
}



