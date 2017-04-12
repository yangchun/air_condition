var page=1;
$(function(){
	onload(page);
});
function onload(page){
	$.ajax({
		url:"../equipmentdata/getAllEqData?page="+page,
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
	$("#editable tbody").children().remove();
	for(var i=0;i<list.length;i++){
		str+="<tr class='gradeX'><td>"+list[i].eqparm+"</td><td>"+list[i].eqname+"</td><td>"+list[i].eqvalue+
		"</td><td>"+list[i].eqstate+"</td></tr>";	
	}
	var table = $("#editable");
	table.find("tbody").append(str);
}
function prePage(){
	if(page<=1){
		onload(page);
	}else{
		page=page-1;
		onload(page);
	}
}
function nextPage(){
	page=page+1;
	onload(page);
}