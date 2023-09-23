<%@page import="model.chiTietDonHang"%>
<%@page import="dao.chiTietDonHangDAO"%>
<%@page import="model.donHang"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xem đơn hàng</title>
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
</head>
<body>
	<%
	String donhang = request.getAttribute("donhang") + "";
	donhang = (donhang.equals("null")) ? "0" : donhang;
	int dh_id = Integer.parseInt(donhang);
	chiTietDonHangDAO ctdhd = new chiTietDonHangDAO();
	ArrayList<chiTietDonHang> listChiTietDonHang = ctdhd.sellectAllById(dh_id);
	chiTietDonHang[] ctdh = new chiTietDonHang[100];
	int i = 0;
	int tong=0;
	for (chiTietDonHang element : listChiTietDonHang) {
		ctdh[i] = element;
		tong+=ctdh[i].getSoLuong()*ctdh[i].getSanPham().getGiaBan();
		i++;
	}
	%>
	<div class="container-fluid text-center"
		style="height: 40px; margin: 30px">
		<h3>ĐƠN HÀNG</h3>
	</div>
	<!-- giỏ hàng  -->
	<div class="row">
		<%
		for (int luc = 0; luc < listChiTietDonHang.size(); luc++) {
		%>
		<div class="row col-lg-6"
			style="padding-top: 20px; padding-bottom: 20px">
			<div class="col-lg-3"></div>
			<div class="col-lg-4">
				<a href="#"><img class="card-img-top"
					src="<%=ctdh[luc].getSanPham().getAnh().getLink()%>" alt="" style="width: 200px; height: 200x;"></a>
			</div>
			<div class="col-lg-3">
				<h4><%=ctdh[luc].getSanPham().getTieuDe()%></h4>
				<h6><%=ctdh[luc].getSanPham().getGiaBan()%>đ</h6>
			</div>

			<div class="row col-lg-6"
				style="padding-top: 20px; padding-bottom: 20px"></div>
		</div>
		<div class="row col-lg-6"
			style="padding-top: 20px; padding-bottom: 20px">
			<div class="col-lg-2"><h5>Số lượng</h5></div>
			<div class="row col-lg-2">
				<h5><%=ctdh[luc].getSoLuong()%></h5>
			</div>

		</div>
		<%
		}
		%>
		<div class="row col-lg-6" style="padding-top: 20px; padding-bottom: 20px">
		<div class="col-lg-9"></div>
		<div class="col-lg-3"><h4>TỔNG TIỀN :</h4></div>
		</div>
		<div class="row col-lg-6" style="padding-top: 20px; padding-bottom: 20px">
		<div class="col-lg-2"><h4><%=tong %>đ</h4></div>
		</div>
	</div>
	<div class="text-center" style="padding-top: 30px">
		<a href="http://localhost:8080/baitap/quanlydonhang.jsp">QUAY LẠI</a>
	</div>
</body>
</html>