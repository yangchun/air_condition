function addNewLimit() {
    var bh = $("body").height();
    var bw = $("body").width();
    $("#fullbg").css({
        height:bh,
        width:bw,
        display:"block"
    });
    $("#addNewLimit").show();
}
function closeNewLimit() {
    $("#fullbg,#addNewLimit").hide();
}



