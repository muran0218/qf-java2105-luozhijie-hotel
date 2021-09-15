<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>餐馆王平台</title>


	<jsp:include page="../resource/static_resource.jsp"/>
	<link href="${front_detail_path}/style/css/index.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="${front_detail_path}/style/css/dis_message.css" />
</head>
<body style="text-align: center">
	<div id="all">
		<!--左边菜品详细信息 -->
		<div id="menu1">
			<div class="menu2" style="text-align:center;">
				<img src="${front_detail_path}/style/images/order_detials_bg.png" />
			</div>
			<div class="menu3">
				<div class="menu3_left">
					<img src="${foods.foodImage}"
						style="width:270px; height:290px;" />
				</div>
				<div class="menu3_right">
					<p>菜名:${foods.foodName}</p>
					<c:if test="${sessionScope.user.isMember == 0}">
					<p>价格:&yen;&nbsp;${foods.foodPrice}</p>
					</c:if>
					<c:if test="${sessionScope.user.isMember == 1}">
						<p>会员价格:&yen;&nbsp;${foods.foodMprice}</p>
					</c:if>
					<p>简介:${foods.foodDesc}</p>
				</div>
			</div>
			<div class="menu4">
				
				<a href="clientCart.html" style="background:url(style/images/img/order_left_corner_bg.png);">放入餐车</a>
				<a href="#" onclick="javascript:history.go(-1);" style="background:url(style/images/img/order_right_corner_bg.png);">返回</a>
			</div>
		</div>
		
		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
			<div id="dish_top">
				<ul>
				<li class="dish_num"></li>
					<li>
						<a href="clientOrderList.html">
							<img src="${front_detail_path}/style/images/call2.gif" />
						</a>
					</li>
				</ul>
			</div>

			<div id="dish_2">
				<ul style="height:250px;overflow-y:scroll;">
					<c:forEach  items="${sessionScope.front_types}" var="type" >
						<li>
							<a href="javascript:void(0);" onclick="findByPageAndCondition(${type.typeId})">${type.typeName}</a>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div id="dish_3">
				<!-- 搜索菜品表单  -->
				<form action="/front" method="post">
					<table width="166px">
						<tr>
							<td>
								<input type="text" id="dish_name" name="foodName" class="select_value" value="${foodName}" placeholder="请输入菜品名称" />
								<input type="hidden" value="findByPageAndCondition" name="method">
							</td>
						</tr>
						<tr>
							<td><input type="submit" id="sub" value="" /></td>
						</tr>
						<tr>
							<td>
								<a href="/front?method=findByPageAndCondition">
									<img src="${front_detail_path}/style/images/look.gif" />
								</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
<script>
	function findByPageAndCondition(typeId){
		location.href = "/front?method=findByPageAndCondition&typeId=" + typeId;
	}
</script>
</html>
