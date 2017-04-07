
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
}
function closeNewUser() {
    $("#fullbg,#addNewUser").hide();
}


$.ajax({
	url:"..user/getAllUser",
	type:"POST",
	dataType:'json',
	success:function back(data){
		addData(data);
	},
	error:function back(data){
		alert("系统提示：修改信息失败");
	}
	
});

function addData(data){
	var r = JSON.parse(data);
	var str;
	var list=r.map;
	for(var i=list.length-2;i<list.length;i++){
		var dList = list[i].length
		for(var j=0;j<dList;j++){
			str+="<tr><td>"+list[i][j].username+"</td><td>"+list[i][j].rolename+"</td><td>"+list[i][j].email+"</td><td>"+
			"<button type='button' class='btn btn-xs btn-primary' onclick='adjust()'>编辑</button>  "+
			"<button type='button' class='btn btn-xs btn-primary'>删除</button>"+
			"</td></tr>";
		}
	}	
	$("tbody").append(str);
}






