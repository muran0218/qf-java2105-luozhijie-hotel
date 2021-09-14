<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>餐馆王平台</title>


<jsp:include page="../resource/static_resource.jsp"/>
	<link href="${front_detail_path}/style/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body style="text-align: center">
	<div id="all">
		<div id="menu">
			<!-- 显示菜品的div -->
			<div id="top">
				<ul>
					<!-- 循环列出餐品 -->
					<c:forEach items="${PageBean.list}" var="food">
						<li>
							<dl>
								<dt>
									<a href="/food?method=findById&foodId=${food.foodId}">
										<img width="214px" height="145px" src="${pageContext.request.contextPath}${food.foodImage}" />
									</a>
								</dt>
								<dd class="f1">
									<a href="/food?method=findById&foodId=${food.foodId}">${food.foodName}</a>
								</dd>
								<dd class="f2">
									<a href="/food?method=findById&foodId=${food.foodId}">${food.foodPrice}</a>
								</dd>
							</dl>
						</li>
					</c:forEach>
				</ul>
			</div>

			<!-- 底部分页导航条div -->
			<div id="foot">



						<span style="float:left; line-height:53PX; margin-left:-50px; font-weight:bold; ">
							<span style="font-weight:bold">

								<a <c:if test="${PageBean.currentPage > 1 && PageBean.currentPage <= PageBean.totalPages}">
										href="/front?method=findByPageAndCondition&currentPage=${PageBean.currentPage-1}"
								</c:if>
										style=" text-decoration:none;color:#000000; font-weight:bold"
								>上一页</a>

							</span>
						</span>



				<div id="btn">
					<ul>
						<!-- 参看 百度, 谷歌是 左 5 右 4 -->
						<c:forEach begin="1" end="${PageBean.totalPages}" var="page">
							<li><a <c:if test="${page == PageBean.currentPage}"> style='color: purple; font-weight: bolder'</c:if>
								href="/front?method=findByPageAndCondition&currentPage=${page}&typeId=${typeId}&foodName=${foodName}">
									${page}</a></li>
						</c:forEach>
					</ul>
				</div>



				<span style="float:right; line-height:53px; margin-right:10px;  ">
							<a
							<c:if test="${PageBean.currentPage >= 1 && PageBean.currentPage < PageBean.totalPages}">
							href="/front?method=findByPageAndCondition&currentPage=${PageBean.currentPage+1}"
							</c:if>
							style=" text-decoration:none;color:#000000; font-weight:bold">下一页</a>
						</span>



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
