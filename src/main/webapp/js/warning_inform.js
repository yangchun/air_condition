$(function(){
	onload();
});

function onload(){
	$.ajax({
		url:"../eventinform/getAllEventInform",
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
		var g="";
		if(list[i].grade=="一级"){
			g="<font color='red'>一级</font>"
		}else if(list[i].grade=="二级"){
			g="<font color='orange'>二级</font>"
		}
		if(list[i].state==1){
			list[i].state="<font color='red'>未处理</font>"
		}else{
			list[i].state="已处理"
		}
		str+="<tr class='gradeX'><td>"+list[i].eqname+"</td><td>"+jsTimeToString(list[i].informtime)+"</td><td>"+g+
		"</td><td>"+list[i].desc+"</td><td>"+list[i].state+"</td><td>"+
		"<button type='button' class='btn btn-xs btn-primary' onclick='dealInform(this,"+list[i].id+")'>处理</button> "+
		"<button type='button' class='btn btn-xs btn-primary' onclick='closeInform("+list[i].id+")'>关闭</button>"+
		"</td></tr>";	
	}
	var table = $("#editable");
	table.find("tbody").append(str);
}

function dealInform(br,id){
		$.ajax({
			type:"POST",
			url:"../eventinform/dealEventInform?id="+id,
			success: function back(data){
				alert($(br).children('td').eq(1).text());
		    },
		    error: function back(data){
		    	alert("系统提示");
		    }
		});
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


