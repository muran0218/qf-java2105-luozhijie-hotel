<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>注册页面</title>
		
	<!-- 引入css样式 -->

		<!-- 引入css样式 -->
		<link rel="stylesheet" href="${front_detail_path}/user/css/bootstrap.min.css">
		<!-- 引入jQuery -->
		<script src="${front_detail_path}/user/js/jquery-3.4.1.min.js" ></script>
		<!-- 引入bootstrap的js -->
		<script src="${front_detail_path}/user/js/bootstrap.min.js" ></script>
	</head>

	<body>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<form class="form-horizontal" action="/user?method=reg" method="post">
					
				  <div class="form-group">
				    <label for="username" class="col-sm-2 control-label">用户名:</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="userName" id="username" placeholder="用户名"><span id="userNameMsg"></span>
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="inputPassword" class="col-sm-2 control-label">密码:</label>
				    <div class="col-sm-10">
				      <input type="password" class="form-control" name="password" id="inputPassword" placeholder="密码">
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="rwd" class="col-sm-2 control-label">确认密码:</label>
				    <div class="col-sm-10">
				      <input type="password" class="form-control" name="rwd" id="rwd" placeholder="确认密码">
				    </div>
				  </div>

					<div class="form-group">
						<label for="" class="col-sm-2 control-label">是否成为会员:</label>
						<div class="col-sm-10">
							<label class="radio-inline">
								<input type="radio" name="isMember" id="isAdmin1" value="1" checked> 是
							</label>
							<label class="radio-inline">
								<input type="radio" name="isMember" id="isAdmin2" value="0"> 否
							</label>
						</div>
					</div>

				  
				  <div class="form-group">
				  	<label for="" class="col-sm-2 control-label">性别:</label>
				  	<div class="col-sm-10">
					  	<label class="radio-inline">
						  <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="0" checked > 保密
						</label>
						<label class="radio-inline">
						  <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="1">  男
						</label>
						<label class="radio-inline">
							<input type="radio" name="inlineRadioOptions" id="inlineRadio3" value="1"> 女
						</label>
					</div>
				  </div>

				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <button type="submit" id="btn" class="btn btn-primary" style="float: right;">注册</button>
				    </div>
				  </div>
				  
				</form>
				</div>
			<div class="col-md-3"></div>
		</div>
	</body>
	<script>
		$(function () {
			$("#username").change(function () {
				var userNameVal = $(this).val();
				$.get('/user?method=existsUserName', {userName: userNameVal}, function (result) {
					if(result.success) {
						$("#userNameMsg").html("<span style='color: green;'>" + result.message + "</span>");
						$("#btn").attr("disabled", false);
					} else {
						$("#userNameMsg").html("<span style='color: red;'>" + result.message + "</span>");
						$("#btn").attr("disabled", true);
					}
				}, "json");
			});
		})
	</script>
</html>
