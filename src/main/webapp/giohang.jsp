<%@page import="model.user"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.gioHang"%>
<%@page import="dao.giohangDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giở hàng</title>
</head>
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
	// Định nghĩa hàm tính tổng tiền
	function calculateTotal() {
		// Lấy danh sách các checkbox đã được chọn
		var checkboxes = document.getElementsByName('selectedItems');

		// Khởi tạo biến tổng tiền
		var total = 0;

		// Lặp qua từng checkbox
		for (var i = 0; i < checkboxes.length; i++) {
			// Nếu checkbox được chọn
			if (checkboxes[i].checked) {
				// Lấy form tinhtien tương ứng
				var form = document.getElementById('tinhtien' + i);

				// Lấy giá bán và số lượng từ form
				var giaban = parseFloat(form
						.querySelector('input[name="giaban"]').value);
				var soluong = parseInt(form
						.querySelector('input[name="soluong"]').value);

				// Tính tổng tiền của sản phẩm và cộng vào tổng tiền chung
				total += giaban * soluong;
			}
		}
		var tongtienElement = document.getElementById("tongtien");
		console.log('Tổng tiền: ' + total);
		tongtienElement.textContent = total;
	}
</script>

<script>
	
</script>
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
	function xoa0() {
		var form = document.getElementById("xoa0");
		form.submit();
	}
	function xoa1() {
		var form = document.getElementById("xoa1");
		form.submit();
	}
	function xoa2() {
		var form = document.getElementById("xoa2");
		form.submit();
	}
	function xoa3() {
		var form = document.getElementById("xoa3");
		form.submit();
	}
	function xoa4() {
		var form = document.getElementById("xoa4");
		form.submit();
	}
	function xoa5() {
		var form = document.getElementById("xoa5");
		form.submit();
	}
	function xoa6() {
		var form = document.getElementById("xoa6");
		form.submit();
	}
	function xoa6() {
		var form = document.getElementById("xoa7");
		form.submit();
	}
	function xoa8() {
		var form = document.getElementById("xoa8");
		form.submit();
	}
	function xoa9() {
		var form = document.getElementById("xoa9");
		form.submit();
	}
	function xoa10() {
		var form = document.getElementById("xoa10");
		form.submit();
	}
	function xoa11() {
		var form = document.getElementById("xoa11");
		form.submit();
	}
	function mua() {
		var form = document.getElementById("mua");
		form.submit();
	}
</script>

<body>
	<%
	String user_id = request.getAttribute("user_id") + "";
	user_id = (user_id.equals("null")) ? "0" : user_id;
	int id = Integer.parseInt(user_id);
	giohangDAO ghd = new giohangDAO();
	ArrayList<gioHang> listgiohang = new ArrayList<>();
	listgiohang = ghd.sellectAllById(id);
	gioHang[] gh = new gioHang[100];
	int i = 0;
	for (gioHang element : listgiohang) {
		gh[i] = element;
		
		i++;
	}
	%>
	<%
	int tinhtongtien = 0;
	String tinhtien = request.getAttribute("tinhtien") + "";
	tinhtien = (tinhtien.equals("null")) ? "0" : tinhtien;
	int tt = Integer.parseInt(tinhtien);
	tinhtongtien += tt;
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
	<div class="container-fluid text-center"
		style="height: 40px; margin: 30px">
		<h3>GIỎ HÀNG</h3>
	</div>
	<!-- giỏ hàng  -->
	<form action="mua" method="post" id="mua">
	<input type="hidden" name="user_id" value="<%=user_id%>">
		<div class="row">
			<%
			for (int luc = 0; luc < listgiohang.size(); luc++) {
			%>
			<div class="row col-lg-6"
				style="padding-top: 20px; padding-bottom: 20px">
				<div class="col-lg-3"></div>
				<div class="col-lg-1">
					<input class="form-check-input" type="checkbox"
						style="height: 40px; width: 40px" name="selectedItems"
						onclick="calculateTotal();" value="<%=luc%>">

				</div>
				<div class="col-lg-2">
					<a href="#"><img class="card-img-top"
						src="<%=gh[luc].getSanPham().getAnh().getLink()%>" alt=""></a>
				</div>
				<div class="col-lg-3">
					<h4><%=gh[luc].getSanPham().getTieuDe()%></h4>
					<h6><%=gh[luc].getSanPham().getGiaBan()%>đ</h6>
					<form action="" method="post"></form>
					<form id="tinhtien<%=luc%>" action="" method="post">
						<input type="hidden" name="giaban"
							value="<%=gh[luc].getSanPham().getGiaBan()%>"> <input
							type="hidden" name="soluong" value="<%=gh[luc].getSoLuong()%>">
						<input type="hidden" name="user_id" value="<%=user_id%>">
					</form>
				</div>

				<div class="row col-lg-6"
					style="padding-top: 20px; padding-bottom: 20px"></div>
			</div>
			<div class="row col-lg-6"
				style="padding-top: 20px; padding-bottom: 20px">
				<div class="row col-lg-2">
					<h5><%=gh[luc].getSoLuong()%></h5>
				</div>
				<div class="col-lg-1">
					<button type="button" onclick="xoa<%=luc%>()">Xóa</button>
				</div>
			</div>
			<form id="xoa<%=luc%>" method="post" action="xoagiohang">
				<input type="hidden" name="sanpham"
					value="<%=gh[luc].getSanPham().getId()%>" /> <input type="hidden"
					name="user" value="<%=gh[luc].getUser().getId()%>" />
			</form>
			<%
			}
			%>
		</div>
	</form>
	<!-- hết giỏ hàng -->
	<!-- tính tiền -->
	<div style="position: fixed; bottom: 0; width: 100%;">
		<div class="row" style="background-color: green">
			<div class="row col-lg-10">
				<div class="row col-lg-2">
					<h5></h5>
				</div>
				<div class="row col-lg-2">
					<h3>Tổng tiền :</h3>
				</div>
				<div class="row col-lg-8">
					<span id="tongtien">đ</span>
				</div>
			</div>
			<div class="row col-lg-2">
				<button onclick="mua()">MUA</button>
			</div>
		</div>
		<!-- hết tính tiền -->
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
	</div>
	<!-- End Footer -->
</body>
</html>