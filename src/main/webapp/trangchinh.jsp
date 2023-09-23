<%@page import="controller.timKiemSanPham"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.sanPham"%>
<%@page import="dao.sanPhamDAO"%>
<%@page import="model.user"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chính</title>
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
	function submitForm0() {
		var form = document.getElementById("myForm0");
		form.submit();
	}
	function submitForm1() {
		var form = document.getElementById("myForm1");
		form.submit();
	}
	function submitForm2() {
		var form = document.getElementById("myForm2");
		form.submit();
	}
	function submitForm3() {
		var form = document.getElementById("myForm3");
		form.submit();
	}
	function submitForm4() {
		var form = document.getElementById("myForm4");
		form.submit();
	}
	function submitForm5() {
		var form = document.getElementById("myForm5");
		form.submit();
	}
	function submitForm6() {
		var form = document.getElementById("myForm6");
		form.submit();
	}
	function submitForm7() {
		var form = document.getElementById("myForm7");
		form.submit();
	}
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
<style type="text/css">
.highlight:hover {
	color: red;
}
/* Định dạng tiêu đề "SẢN PHẨM BÁN CHẠY" */
.container-fluid h3 {
  font-size: 28px;
  font-weight: bold;
  color: #333;
  margin: 20px 0;
}
.card-img-top {
  object-fit: cover;
}
.card {
  border: none;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}
</style>
</head>
<body>
	<%
	int luot = 1;
	String l = request.getAttribute("luot") + "";
	l = (l.equals("null")) ? "1" : l;
	int l1 = Integer.parseInt(l);

	String timKiemDanhSach = request.getAttribute("timKiemDanhSach") + "";
	timKiemDanhSach = (timKiemDanhSach.equals("null")) ? "0" : timKiemDanhSach;
	int tkds = Integer.parseInt(timKiemDanhSach);

	String timKiemSanPham = request.getAttribute("listSanPham") + "";

	luot = l1;
	sanPhamDAO spd = new sanPhamDAO();
	ArrayList<sanPham> list = new ArrayList<>();
	if (luot == 1) {
		list = spd.sellectcuoi();
	} else if (luot == 2) {
		if (tkds == 1 || tkds == 2) {
			list = spd.sellectDanhMuc1(tkds, 3);
		} else if (tkds == 4) {
			list = spd.sellectDanhMuc2(tkds);
		}
	} else if (luot == 3) {
		list = spd.sellectByTieuDe(timKiemSanPham);
	}
	int i = 0;
	sanPham[] sp = new sanPham[100];
	for (sanPham element : list) {
		sp[i] = element;
		i++;
	}
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
					<li class="nav-item"><a class="nav-link active highlight"
						aria-current="page" href="#" onclick="submitPhuNu();">PHỤ NỮ</a>
						<form id="phuNu" method="post" action="timKiem">
							<input type="hidden" name="data" value="2" />
						</form></li>
					<li class="nav-item"><a class="nav-link active highlight"
						aria-current="page" href="#" onclick="submitDanOng();">ĐÀN ÔNG</a>
						<form id="danOng" method="post" action="timKiem">
							<input type="hidden" name="data" value="1" />
						</form></li>
					<li class="nav-item"><a class="nav-link active highlight"
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
	<!-- Slider -->
	<div id="carouselExampleIndicators" class="carousel slide">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/slider/1.png" class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="img/slider/2.png" class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="img/slider/3.png" class="d-block w-100" alt="...">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
	<!-- End Slider -->
	<div class="container-fluid text-center" style="margin: 20px">
		<h3>SẢN PHẨM BÁN CHẠY</h3>
	</div>
	<!-- Product -->


	<div class="row">
		<%
		for (int luc = 0; luc <list.size(); luc++) {
		%>
		
		<div class="col-lg-3 col-md-6 mb-4">
			<div class="card h-100">
				<a href="#" onclick="submitForm<%=luc%>()"><img class="card-img-top"
					style="width: 442px; height: 560px;"
					src="<%=sp[luc].getAnh().getLink()%>" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#" onclick="submitForm<%=luc%>();"><%=sp[luc].getTieuDe()%></a>
					</h4>
					<p class="card-text"><%=sp[luc].getMoTaSanPham()%></p>
					<h5><%=sp[luc].getGiaBan()%>đ</h5>
				</div>
			</div>
			<form id="myForm<%=luc %>" method="post" action="process">
				<input type="hidden" name="data" value="<%=sp[luc].getId()%>" />
			</form>
		</div>
		
		<%
		}
		%>
		
	</div>

	<!-- End Product -->
	<!-- Footer -->
	<footer class="footer bg-dark text-light">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h3>Thông tin liên hệ</h3>
					<p>Địa chỉ: 158 Đường Trương Định, Thành phố Hà Nội</p>
					<p>Email: nguyenvanluc@.com</p>
					<p>Điện thoại: 1234567890</p>
				</div>
			</div>
		</div>
	</footer>
	<!-- End Footer -->
</body>
</html>