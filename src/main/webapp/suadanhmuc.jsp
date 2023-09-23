<%@page import="model.danhMuc"%>
<%@page import="dao.danhMucDAO1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa danh mục</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
	integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
	crossorigin="anonymous"></script>
</head>
<body>
<%
String danhmuc_id = request.getAttribute("danhmuc_id") + "";
danhmuc_id = (danhmuc_id.equals("null")) ? "1" : danhmuc_id;
int dm = Integer.parseInt(danhmuc_id);
danhMucDAO1 dmd= new danhMucDAO1();
danhMuc danhmuc= dmd.sellectByid(dm);
%>
	<div class="center" style="display: flex; justify-content: center; align-items: center; height: 100vh;">
		<form class="d-flex" action="suadanhmucxong" method="post">
		    <input type="hidden" name="danhmuc_id" value="<%=dm%>">
			<input class="form-control" type="text" name="suadanhmuc"
				id="suadanhmuc" placeholder="<%=danhmuc.getTenDanhMuc()%>">
			<button class="btn btn-outline-success" type="submit">Sửa</button>
		</form>
	</div>
</body>
</html>