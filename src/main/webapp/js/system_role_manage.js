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
	 
	
	
}
//弹出添加新角色窗口
function popchRole() {
    var bh = $("body").height();
    var bw = $("body").width();
    $("#fullbg").css({
        height:bh,
        width:bw,
        display:"block"
    });
    $("#changeRole").show();
}
function closechRole() {
    $("#fullbg,#changeRole").hide();
}



