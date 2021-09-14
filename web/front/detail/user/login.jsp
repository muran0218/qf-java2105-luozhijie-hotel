<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>登录页面</title>
		
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
				<form class="form-horizontal" action="/user?method=login" method="post">
					
				  <div class="form-group">
				    <label for="username" class="col-sm-2 control-label">用户名:</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" name="userName" id="username" placeholder="用户名">
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="inputPassword" class="col-sm-2 control-label">密码:</label>
				    <div class="col-sm-10">
				      <input type="password" class="form-control" name="password" id="inputPassword" placeholder="密码">
				    </div>
				  </div>

					<div class="form-group">
						<label for="inputPassword" class="col-sm-2 control-label">验证码:</label>
						<div class="col-sm-10">
							<input type="text" name="valCode"><img src="/createCode" onclick="updateCode(this)"><br>
						</div>
					</div>

				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <button type="submit" class="btn btn-primary" style="float: left;">登录</button>
						<a href="register.jsp" style="float: right">注册</a>
				    </div>
				  </div>
				  
				</form>
				</div>
			<div class="col-md-3"></div>
		</div>
	</body>
	<script>
		function updateCode(obj) {
			obj.src="/createCode?time="+new Date().getTime();
		}

	</script>
</html>
