function login(){
	var json1={
			"username":$("#username").val(),
			"password":$("#password").val()
		};
		$.ajax({
			type:"POST",
			url:"user/login",
			data:json1,
			dataType:"json",
			success:function back(data){
				window.location.href="html/index.html";
			},
			error:function back(){
				alert("登录失败！");
			}
		});
}