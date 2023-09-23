<%@page import="model.user"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.donHangDAO"%>
<%@page import="model.donHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý đơn hàng</title>
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
<script type="text/javascript">
function xem0() {
	var form = document.getElementById("xem0");
	form.submit();
}
function xem1() {
	var form = document.getElementById("xem1");
	form.submit();
}
function xem2() {
	var form = document.getElementById("xem2");
	form.submit();
}
function xem3() {
	var form = document.getElementById("xem3");
	form.submit();
}
function xem4() {
	var form = document.getElementById("xem4");
	form.submit();
}
function xem5() {
	var form = document.getElementById("xem5");
	form.submit();
}
function xem6() {
	var form = document.getElementById("xem6");
	form.submit();
}
function xem7() {
	var form = document.getElementById("xem7");
	form.submit();
}
function xem8() {
	var form = document.getElementById("xem8");
	form.submit();
}
function xem9() {
	var form = document.getElementById("xem9");
	form.submit();
}
function xem10() {
	var form = document.getElementById("xem10");
	form.submit();
}
function xem11() {
	var form = document.getElementById("xem11");
	form.submit();
}
function xem12() {
	var form = document.getElementById("xem12");
	form.submit();
}
function xem13() {
	var form = document.getElementById("xem13");
	form.submit();
}
function xem14() {
	var form = document.getElementById("xem14");
	form.submit();
}
function xem15() {
	var form = document.getElementById("xem15");
	form.submit();
}
function xem16() {
	var form = document.getElementById("xem16");
	form.submit();
}
function xem17() {
	var form = document.getElementById("xem17");
	form.submit();
}
function xem18() {
	var form = document.getElementById("xem18");
	form.submit();
}
function xem19() {
	var form = document.getElementById("xem19");
	form.submit();
}
function xem20() {
	var form = document.getElementById("xem20");
	form.submit();
}
function xem21() {
	var form = document.getElementById("xem21");
	form.submit();
}
function xem22() {
	var form = document.getElementById("xem22");
	form.submit();
}
function xem23() {
	var form = document.getElementById("xem23");
	form.submit();
}
function xem24() {
	var form = document.getElementById("xem24");
	form.submit();
}
function xem25() {
	var form = document.getElementById("xem25");
	form.submit();
}
function xem26() {
	var form = document.getElementById("xem26");
	form.submit();
}
function xem27() {
	var form = document.getElementById("xem27");
	form.submit();
}
function xem28() {
	var form = document.getElementById("xem28");
	form.submit();
}
function xem29() {
	var form = document.getElementById("xem29");
	form.submit();
}
function xem30() {
	var form = document.getElementById("xem30");
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
function xoa7() {
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
function xoa12() {
	var form = document.getElementById("xoa12");
	form.submit();
}
function xoa13() {
	var form = document.getElementById("xoa13");
	form.submit();
}
function xoa14() {
	var form = document.getElementById("xoa14");
	form.submit();
}function xoa15() {
	var form = document.getElementById("xoa15");
	form.submit();
}function xoa16() {
	var form = document.getElementById("xoa16");
	form.submit();
}function xoa17() {
	var form = document.getElementById("xoa17");
	form.submit();
}function xoa18() {
	var form = document.getElementById("xoa18");
	form.submit();
}function xoa19() {
	var form = document.getElementById("xoa19");
	form.submit();
}function xoa20() {
	var form = document.getElementById("xoa20");
	form.submit();
}function xoa21() {
	var form = document.getElementById("xoa21");
	form.submit();
}function xoa21() {
	var form = document.getElementById("xoa22");
	form.submit();
}function xoa23() {
	var form = document.getElementById("xoa23");
	form.submit();
}function xoa24() {
	var form = document.getElementById("xoa24");
	form.submit();
}
function xoa25() {
	var form = document.getElementById("xoa25");
	form.submit();
}
function xoa26() {
	var form = document.getElementById("xoa26");
	form.submit();
}
function xoa27() {
	var form = document.getElementById("xoa27");
	form.submit();
}
function xoa28() {
	var form = document.getElementById("xoa28");
	form.submit();
}
function xoa29() {
	var form = document.getElementById("xoa29");
	form.submit();
}
function xoa30() {
	var form = document.getElementById("xoa30");
	form.submit();
}
</script>
<style type="text/css">
.highlight:hover {
	color: red;
}
.row {
  margin-bottom: 15px;
}

/* Ẩn viền đường bao quanh các ô input */
input[type="text"] {
  border: none;
  border-bottom: 1px solid #ccc;
  padding: 5px;
  width: 100%;
}

/* Định dạng phông chữ cho tiêu đề "TÊN DANH MỤC" */
h4 {
  font-size: 24px;
  font-weight: bold;
  color: #333;
}

/* Tạo nút "THÊM" hấp dẫn hơn */
button[type="button"] {
  padding: 5px 10px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

/* Tạo hiệu ứng khi di chuột vào các nút */
button[type="button"]:hover {
  background-color: #0056b3;
}

/* Tạo viền xung quanh bảng */
.table {
  border: 1px solid #ccc;
  border-collapse: collapse;
  width: 100%;
}

/* Định dạng cho tiêu đề của bảng */
.table th {
  background-color: #cccccc;
  padding: 10px;
  text-align: left;
}

/* Định dạng cho các ô dữ liệu trong bảng */
.table td {
  padding: 8px;
  border-bottom: 1px solid #ccc;
}

/* Tạo hiệu ứng khi di chuột vào các dòng của bảng */
.table tbody tr:hover {
  background-color: #f2f2f2;
}
input[type="text"] {
  width: 100%;
  padding: 10px;
  border: 2px solid #007bff; /* Màu viền */
  border-radius: 4px;
  outline: none; /* Loại bỏ viền xung quanh khi focus */
  transition: border-color 0.3s ease-in-out; /* Hiệu ứng chuyển đổi màu viền */
}

/* Định dạng khi di chuột vào ô tìm kiếm */
input[type="text"]:hover {
  border-color: #0056b3; /* Màu viền khi di chuột vào */
}

/* Định dạng khi ô tìm kiếm được focus */
input[type="text"]:focus {
  border-color: #00ccff; /* Màu viền khi focus */
  box-shadow: 0 0 8px rgba(0, 123, 255, 0.5); /* Đổ bóng khi focus */
}
.table {
  width: calc(100% - 60px); /* 100% - 2 x 30px = 100% - 60px */
  margin: 0 30px; /* Cách lề trái và phải 30px */
  border-collapse: collapse;
}

/* Định dạng phần tiêu đề của bảng */
.table th,
.table td {
  padding: 10px;
  text-align: center;
}

/* Định dạng ô hiển thị ngày mua và đơn hàng */
.highlight {
  font-weight: bold;
  color: #333;
}
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0; /* Set your desired background color here */
}
</style>
</head>
<body>
	<%
	donHangDAO dhd = new donHangDAO();
	ArrayList<donHang> listdonhang = new ArrayList<>();
	listdonhang = dhd.sellectAll();
	int i = 0;
	donHang[] dh = new donHang[100];
	for (donHang element : listdonhang) {
		dh[i] = element;
		i++;
	}
	%>
	<div class="row">
		<div class="dropdown col-lg-5" style="padding-left: 100px; padding-top: 30px">
			<button type="button" class="btn btn-primary dropdown-toggle"
				data-bs-toggle="dropdown">Thư mục</button>
			<ul class="dropdown-menu">
				<li><a class="dropdown-item highlight highlight"
					href="http://localhost:8080/baitap/quanlydanhmuc.jsp">QUẢN LÝ
						DANH MỤC</a></li>
				<li><a class="dropdown-item highlight highlight"
					href="http://localhost:8080/baitap/quanlysanpham.jsp">QUẢN LÝ
					 SẢN PHẨM</a></li>
				<li><a class="dropdown-item highlight highlight"
					href="http://localhost:8080/baitap/quanlyphanhoi.jsp">QUẢN LÝ
						PHẢN HỒI</a></li>
				<li><a class="dropdown-item highlight highlight"
					href="http://localhost:8080/baitap/quanly.jsp"> QUAY LẠI</a></li>
			</ul>
		</div>
		<div class="danhmuc col-lg-6" style="padding-top: 30px">
			<h3>QUẢN LÝ ĐƠN HÀNG</h3>
		</div>
		<div class="col-lg-1" style="padding-top: 30px">
			<nav class="navbar navbar-expand-lg bg-body-tertiary">
				<div class="container-fluid">
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
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
							<div >
								<b><%=user.getTenDangNhap()%></b>
							</div>
							<div >
								<a style="white-space: nowrap;" href="dang-xuat"> Đăng xuất
								</a>
							</div>
						</div>
						<%
						}
						%>
					</div>
				</div>
			</nav>
		</div>
		
	</div>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">STT</th>
				<th scope="col">Ngày mua</th>
				<th scope="col">Đơn hàng</th>
				<th scope="col">Xem</th>
				<th scope="col">Xóa</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int luc = 0; luc < listdonhang.size(); luc++) {
			%>
			<tr>
				<th scope="row"><%=luc + 1%></th>
				<td class="highlight"><%=dh[luc].getThoiGianDat() %></td>
				<td class="highlight"><%=dh[luc].getId()%></td>
				<td>
					<button type="button" onclick="xem<%=luc%>()">Xem</button>
				</td>
				<td>
					<button type="button" onclick="xoa<%=luc%>()">Xóa</button>
				</td>
				<form id="xem<%=luc%>" method="post" action="xemdonhang">
					<input type="hidden" name="donhang" value="<%=dh[luc].getId()%>" />
				</form>
				<form id="xoa<%=luc%>" method="post" action="xoadonhang">
					<input type="hidden" name="donhang" value="<%=dh[luc].getId()%>" />
				</form>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>