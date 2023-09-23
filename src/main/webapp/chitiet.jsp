<%@page import="model.feedBack"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.feedbackDAO"%>
<%@page import="model.user"%>
<%@page import="model.kho"%>
<%@page import="dao.khoDAO"%>
<%@page import="model.sanPham"%>
<%@page import="dao.sanPhamDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết</title>
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
<script>
	var maxValue = 100;
	function decreaseValue() {
		var numberInput = document.getElementById("numberInput");
		var currentValue = parseInt(numberInput.value);
		var newValue = Math.max(currentValue - 1, 0); // Giá trị mới là giá trị hiện tại trừ 1, nhưng không nhỏ hơn 0
		numberInput.value = newValue;
	}

	function increaseValue() {
		var numberInput = document.getElementById("numberInput");
		var currentValue = parseInt(numberInput.value);
		var newValue = Math.min(currentValue + 1, maxValue); // Giá trị mới là giá trị hiện tại cộng 1
		numberInput.value = newValue;
	}
</script>
<style type="text/css">
#dam {
	background-color: red;
}
</style>
</head>
</head>
<body>
	<%
	String candangnhap = request.getAttribute("candangnhap") + "";
	candangnhap = (candangnhap.equals("null")) ? "" : candangnhap;

	String candangnhaptaikhoan = request.getAttribute("candangnhaptaikhoan") + "";
	candangnhaptaikhoan = (candangnhaptaikhoan.equals("null")) ? "" : candangnhaptaikhoan;

	String soluongtoida = request.getAttribute("soluongtoida") + "";
	soluongtoida = (soluongtoida.equals("null")) ? "" : soluongtoida;

	String size = request.getAttribute("size") + "";
	size = (size.equals("null")) ? "0" : size;
	int h = Integer.parseInt(size);

	String data = request.getAttribute("data") + "";
	data = (data.equals("null")) ? "0" : data;
	int id = Integer.parseInt(data);
	sanPhamDAO spd = new sanPhamDAO();
	sanPham sp = spd.sellectByid(id);
	String kho = request.getAttribute("kho") + "";
	kho = (kho.equals("null")) ? "0" : kho;
	int soLuong = Integer.parseInt(kho);
	int i = 1;
	if (soLuong == 0) {
		khoDAO kd = new khoDAO();
		kho k = kd.sellectkho(sp.getId(), i);
		soLuong = k.getSoLuong();
	}

	feedbackDAO fbd = new feedbackDAO();
	ArrayList<feedBack> listfeedback = fbd.sellectAll(id);
	feedBack[] fb = new feedBack[100];
	int c = 0;
	for (feedBack element : listfeedback) {
		fb[c] = element;
		c++;
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
	<form action="themvaogiohang?soluongtoida=<%=soLuong%>" method="post">
		<div class="container-fluid text-center" style="margin: 20px">
			<h1>CHI TIẾT SẢN PHẨM</h1>
		</div>
		<div class="row">
			<div class="row col-lg-6">
				<div class="row col-lg-3"></div>
				<div class="row col-lg-6" style="padding-bottom: 20px">
					<a href="#"><img class="card-img-top"
						src="<%=sp.getAnh().getLink()%>" alt=""></a>
				</div>
			</div>
			<div class="row col-lg-3">
				<div>
					<h2><%=sp.getTieuDe()%></h2>
				</div>

				<div class="row col-lg-1"></div>
				<div class="row col-lg-6"><%=sp.getGia()%>đ
				</div>
				<div class="row col-lg-5"><%=sp.getGiaBan()%>đ
				</div>


				<div>
					<h5>SIZE</h5>
					<div class="btn-group" role="group" aria-label="Basic example">
						<form action="size?sp=<%=sp.getId()%>" method="post"></form>
						<form action="size?sp=<%=sp.getId()%>" method="post">
							<button type="submit" class="btn btn-primary" value="1"
								name="size" <%if (h == 1) {%> id="dam"<%}%> }%>S</button>

						</form>
						<form action="size?sp=<%=sp.getId()%>" method="post">
							<button type="submit" class="btn btn-primary" value="2"
								name="size" <%if (h == 2) {%> id="dam"<%}%> }%>M</button>
						</form>
						<form action="size?sp=<%=sp.getId()%>" method="post">
							<button type="submit" class="btn btn-primary" value="3"
								name="size" <%if (h == 3) {%> id="dam"<%}%> }%>L</button>
						</form>
						<form action="size?sp=<%=sp.getId()%>" method="post">
							<button type="submit" class="btn btn-primary" value="4"
								name="size" <%if (h == 4) {%> id="dam"<%}%> }%>XL</button>
						</form>
						<form action="size?sp=<%=sp.getId()%>" method="post">
							<button type="submit" class="btn btn-primary" value="5"
								name="size" <%if (h == 5) {%> id="dam"<%}%> }%>XXL</button>
						</form>
					</div>
				</div>

				<div class="row col-lg-9">
					<h5>Số lượng còn hàng</h5>
				</div>
				<div class="row col-lg-3">
					<%=soLuong%>
				</div>
				<div>
					<h5>Mô tả sản phẩm</h5>
				</div>
				<div style="border: 2px; border-color: black">
					<label><%=sp.getMoTaSanPham()%>.</label>
				</div>
				<div class="row" style="padding-top: 20px; padding-bottom: 20px">
					<div class="row col-lg-4">Số lượng</div>
					<div class="row col-lg-8">
						<div class="input-group">
							<div class="input-group-prepend">
								<button class="btn btn-outline-secondary" type="button"
									id="decreaseButton" onclick="decreaseValue()">-</button>
							</div>
							<input type="text" class="form-control text-center" value="0"
								style="height: 40px; width: 40px" name="soluong"
								id="numberInput">
							<div class="input-group-append">
								<button class="btn btn-outline-secondary" type="button"
									id="increaseButton" onclick="increaseValue()">+</button>
							</div>
						</div>
						<div style="color: red" id="baoLoi">
							<%=soluongtoida%>
						</div>
					</div>
				</div>

				<div>
					<input type="hidden" name="sanpham_id" value="<%=sp.getId()%>">
					<%
					if (user == null) {
					%>
					<button style="background-color: green;" type="submit">
						<h3>THÊM VÀO GIỎ HÀNG</h3>
					</button>
					<div style="color: red" id="baoLoi">
						<%=candangnhap%>
					</div>
					<%
					} else {
					%>
					<input type="hidden" name="user_id" value="<%=user.getId()%>">
					<button style="background-color: green;" type="submit">
						<h3>THÊM VÀO GIỎ HÀNG</h3>
					</button>
					<%
					}
					%>

				</div>
			</div>
			<div class="row col-lg-3"></div>
			<hr />
		</div>
	</form>
	<div class=row>
		<div class="row col-lg-6"></div>
		<div class="row col-lg-6">
			<form action="guinhanxet" method="post">
				<label for="exampleFormControlTextarea1" class="form-label"><h6>Bạn
						có thể đánh giá sản phẩm</h6></label>
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="3" placeholder="đánh giá sản phẩm" name=nhanxet></textarea>
				<%
				if (user == null) {
				%>
				<input type="hidden" name="sanpham_id" value="<%=id%>">
				<div class="row col-lg-1" style="padding-top: 20px; padding-left: 15px">
					<button type="submit" style="background: blue">Gửi</button>
				</div>
				<div style="color: red" id="baoLoi">
					<%=candangnhaptaikhoan%>
				</div>
				<%
				} else {
				%>
				<input type="hidden" name="user_id" value="<%=user.getId()%>">
				<input type="hidden" name="sanpham_id" value="<%=id%>">
				<div class="row col-lg-1" style="padding-top: 20px">
					<button type="submit" style="background: blue">Gửi</button>
				</div>
				<%
				}
				%>
				<div class="row col-lg-11"></div>
			</form>
			<div class="row col-lg-3"></div>
			<div class="row col-lg-6" style="padding-bottom: 20px">ĐÁNH GIÁ
				SẢN PHẨM</div>
			<div class="row col-lg-3"></div>
			<%
			for (int duc = 0; duc < listfeedback.size(); duc++) {
			%>
			<div class="row col-lg-12" style="color: red;">
				<%=fb[duc].getUser().getTenDangNhap()%>
				:
			</div>
			<div class="row col-lg-12">
				<%=fb[duc].getNoiDung()%>
			</div>
			<%
			}
			%>
		</div>
	</div>
	<!-- Footer -->
	<footer class="footer bg-dark text-light" style="margin-top: 100px">
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