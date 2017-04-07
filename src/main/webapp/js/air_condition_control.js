
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



