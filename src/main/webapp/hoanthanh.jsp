<%@page import="model.user"%>
<%@page import="dao.userDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hoàn thành</title>
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
<script>
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
String user_id= request.getAttribute("user_id")+"";
user_id = (user_id.equals("null")) ? "0" : user_id;
int u = Integer.parseInt(user_id);
userDAO usd= new userDAO();
user user1= usd.sellectByid(u);
%>
<!-- Navbar  -->
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
<div class="center" style="display: flex; justify-content: center; align-items: center; height: 100vh;"> <h2>Cảm ơn bạn <%=user1.getTenDangNhap() %> đã đặt hàng của chúng tôi</h2></div>
</body>
</html>