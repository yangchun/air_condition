$(function(){
	onload();
});
function onload(){
	$.ajax({
		url:"../equipment/getAllEqs",
		type:"GET",
		success:function back(item){
			insert(item);
		},
		error:function back(){
			alert("系统提示：获取信息失败");
		}
	});
}
function insert(item){
	var r = JSON.parse(item);
	var str="";
	var list=r.data;
	$("#alleqs").children().remove();
	for(var i=0;i<list.length;i++){
		str+="<li><a href='javascript:changeEq()'>"+list[i].eqname+"</a></li>"	
	}
	var ul = $("#alleqs");
	ul.append(str);
}