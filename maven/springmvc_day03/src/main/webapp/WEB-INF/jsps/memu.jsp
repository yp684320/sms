<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<aside class="main-sidebar">
	<section class="sidebar">
		<ul class="sidebar-menu">
			<li class="header"><i style="color: #ffffff">当前登录用户：${user.username }</i></li>
			<li class="header">菜单</li>
			<li class="treeview">
				<a href="${pageContext.request.contextPath}/findAllUser"> 用户管理</a>
			</li>
		</ul>
	</section>
</aside>