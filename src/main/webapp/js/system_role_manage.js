function addNewRole() {
    var bh = $("body").height();
    var bw = $("body").width();
    $("#fullbg").css({
        height:bh,
        width:bw,
        display:"block"
    });
    $("#addNewRole").show();
}
function closeNewRole() {
    $("#fullbg,#addNewRole").hide();
}



