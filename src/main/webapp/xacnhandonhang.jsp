<%@page import="model.chiTietDonHang"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.chiTietDonHangDAO"%>
<%@page import="dao.donHangDAO"%>
<%@page import="model.user"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xác nhận đơn hàng</title>
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
String donhang= request.getAttribute("donhang_id")+"";
donhang = (donhang.equals("null")) ? "0" : donhang;
int dh_id = Integer.parseInt(donhang);
String user_id= request.getAttribute("user_id")+"";
user_id = (user_id.equals("null")) ? "0" : user_id;
int u = Integer.parseInt(user_id);
chiTietDonHangDAO ctdhd= new chiTietDonHangDAO();
ArrayList<chiTietDonHang> listchitietdonhang=ctdhd.sellectAllById(dh_id);
chiTietDonHang[] ctdh = new chiTietDonHang[100];
int i = 0;
for (chiTietDonHang element : listchitietdonhang) {
	ctdh[i] = element;
	i++;
}
int tongtien=0;
for(int a=0;a<listchitietdonhang.size();a++){
	tongtien+=ctdh[a].getSoLuong()*ctdh[a].getSanPham().getGiaBan();
}
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
	<div class="container-fluid text-center"
		style="height: 40px; margin: 30px">
		<h3>ĐƠN HÀNG</h3>
	</div>
	<!-- giỏ hàng  -->
	<form action="hoanthanh" method="post" id="hoanthanh">
	     <input type="hidden" name="user_id" value="<%=u%>">
		<div class="row">
			<%
			for (int luc = 0; luc < listchitietdonhang.size(); luc++) {
			%>
			<div class="row col-lg-6"
				style="padding-top: 20px; padding-bottom: 20px">
				<div class="col-lg-3"></div>
				<div class="col-lg-2">
					<a href="#"><img class="card-img-top"
						src="<%=ctdh[luc].getSanPham().getAnh().getLink()%>" alt=""></a>
				</div>
				<div class="col-lg-3">
					<h4><%=ctdh[luc].getSanPham().getTieuDe()%></h4>
					<h6><%=ctdh[luc].getSanPham().getGiaBan()%></h6>
				</div>

				<div class="row col-lg-6"
					style="padding-top: 20px; padding-bottom: 20px"></div>
			</div>
			<div class="row col-lg-6"
				style="padding-top: 20px; padding-bottom: 20px">
				<div class="row col-lg-2">
					<h5><%=ctdh[luc].getSoLuong()%></h5>
				</div>

			</div>
			<%
			}
			%>
			<div class="row col-lg-6"
				style="padding-top: 20px; padding-bottom: 20px">
				<div class="col-lg-8"></div>
				<div class="col-lg-2">
					<h4>Tổng tiền :</h4>
				</div>
				<div class="col-lg-1"></div>
				<div class="row col-lg-1"
					style="padding-top: 20px; padding-bottom: 20px"></div>
			</div>
			<div class="row col-lg-6"
				style="padding-top: 20px; padding-bottom: 20px">
				<div class="row col-lg-2">
					<h4><%=tongtien %>đ</h4>
				</div>

			</div>
			<div class="text-center">
			      <button type="submit"><h3>Xác nhận</h3></button>
			</div>
		</div>
	</form>
</body>
</html>