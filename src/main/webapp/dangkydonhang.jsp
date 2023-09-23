<%@page import="model.user"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Đăng ký đơn hàng</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
<style>
.red {
	color: red;
}
</style>
<script >
function submitPhuNu() {
	var form = document.getElementById("phuNu");
	form.submit();
}
function submitDanOng() {
	var form = document.getElementById("danOng");
	form.submit();
}
function submitTreEm() {
	var form = document.getElementById("treEm");
	form.submit();
}
</script>
</head>
<body>
	<%
	String user_id = request.getAttribute("user_id") + "";
	user_id = (user_id.equals("null")) ? "0" : user_id;
	int u = Integer.parseInt(user_id);
	ArrayList<Integer> List = (ArrayList<Integer>) request.getAttribute("selectedLucValues");
	%>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">RM Fashion</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#" onclick="submitPhuNu();">PHỤ NỮ</a>
						<form id="phuNu" method="post" action="timKiem">
							<input type="hidden" name="data" value="2" />
						</form></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#" onclick="submitDanOng();">ĐÀN ÔNG</a>
						<form id="danOng" method="post" action="timKiem">
							<input type="hidden" name="data" value="1" />
						</form></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#" onclick="submitTreEm();">TRẺ EM</a>
						<form id="treEm" method="post" action="timKiem">
							<input type="hidden" name="data" value="4" />
						</form></li>
				</ul>
				<form class="d-flex" action="timKiemSanPham" method="post">
					<input class="form-control" type="text" name="timKiemSanPham"
						id="timKiemSanPham">
					<button class="btn btn-outline-success" type="submit">TÌM
						KIẾM</button>
				</form>
				<%
				Object obj = session.getAttribute("user");
				user user = null;
				if (obj != null)
					user = (user) obj;

				if (user == null) {
				%>
				<a class="btn btn-primary" style="white-space: nowrap;"
					href="dangnhap.jsp"> Đăng nhập </a>
				<%
				} else {
				%>
				<div class="row text-center" style="margin-left: 0.25em">
					<div class="row">
						<b><%=user.getTenDangNhap()%></b>
					</div>
					<div class="row">
						<a style="white-space: nowrap;" href="dang-xuat"> Đăng xuất </a>
					</div>
				</div>
				<%
				}
				%>
			</div>
		</div>
	</nav>
	<!-- End Navbar -->
	<div class="container">
		<div class="text-center">
			<h1>THÔNG TIN ĐƠN HÀNG</h1>
		</div>
		<form class="form" action="dangkydonhang" method="post">
			<input type="hidden" name="user_id" value="<%=u%>">
			<%
			for (Integer value : List) {
			%>
			<input type="hidden" name="listParam" value="<%=value%>">
			<%
			}
			%>
			<div class="mb-3">
				<label for="ten" class="form-label">Tên<span class="red">*</span></label>
				<input type="text" class="form-control" id="ten" name="ten"
					required="required">
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email<span class="red">*</span></label>
				<input type="text" class="form-control" id="email" name="email"
					required="required" onkeyup="kiemTraMatKhau()">
			</div>
			<div class="mb-3">
				<label for="sdt" class="form-label">Số điện thoại<span
					class="red">*</span></label> <input type="text" class="form-control"
					id="sdt" name="sdt">
			</div>
			<div class="mb-3">
				<label for="diachi" class="form-label">Địa chỉ<span
					class="red">*</span></label> <input type="text" class="form-control"
					id="diachi" name="diachi">
			</div>
			<hr />
			<input class="btn btn-primary form-control" type="submit"
				value="Đăng ký" name="submit" id="submit" />
		</form>
	</div>
</body>
</html>