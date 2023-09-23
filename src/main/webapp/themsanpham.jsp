<%@page import="model.danhMuc"%>
<%@page import="dao.danhMucDAO1"%>
<%@page import="model.anh"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.hinhAnhDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Thêm sản phẩm</title>
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
</head>
<body>
	<%
	hinhAnhDAO had = new hinhAnhDAO();
	ArrayList<anh> a = new ArrayList<>();
	a = had.sellectAll();
	int i = 0;
	anh[] anh = new anh[100];
	for (anh element : a) {
		anh[i] = element;
		i++;
	}
	danhMucDAO1 dmd = new danhMucDAO1();
	ArrayList<danhMuc> listdanhmuc = new ArrayList<>();
	listdanhmuc = dmd.sellectAll();
	int j = 0;
	danhMuc[] danhmuc = new danhMuc[100];
	for (danhMuc element : listdanhmuc) {
		danhmuc[j] = element;
		j++;
	}
	%>
	<div class="container">
		<div class="text-center">
			<h1>THÊM SẢN PHẨM</h1>
		</div>
		<form class="form" action="themsanpham" method="post">
			<div class="mb-3">
				<label for="tieude" class="form-label">Tiều đề<span
					class="red">*</span></label> <input type="text" class="form-control"
					id="tieude" name="tieude" required="required">
			</div>
			<div class="mb-3">
				<label for="matKhau" class="form-label">Danh mục</label> <select
					class="form-control" id="danhmuc" name="danhmuc" required="required">
					<option></option>
					<%
					for (int luc = 0; luc < listdanhmuc.size(); luc++) {
					%>
					<option value="<%=danhmuc[luc].getId()%>">
						<%=danhmuc[luc].getTenDanhMuc()%>
					</option>
					<%
					}
					%>
				</select>
			</div>
			<div class="mb-3">
				<label for="gia" class="form-label">Giá <span class="red">*</span></label> <input
					type="text" class="form-control" id="gia" name="gia" required="required">
			</div>
			<div class="mb-3">
				<label for="giaban" class="form-label">Giá bán<span class="red">*</span></label> <input
					type="text" class="form-control" id="giaban" name="giaban" required="required">
			</div>
			<div class="mb-3">
				<label for="giagoc" class="form-label">Giá gốc<span class="red">*</span></label> <input
					type="text" class="form-control" id="giagoc" required="required" name="giagoc">
			</div>
			<div class="mb-3">
				<label for="hinhanh" class="form-label">Hình ảnh</label> <select
					class="form-control" id="hinhanh" name="hinhanh">
					<option></option>
					<%
					for (int luc = 0; luc < a.size(); luc++) {
					%>
					<option value="<%=anh[luc].getId()%>">
						<%=anh[luc].getLink()%>
					</option>
					<%
					}
					%>
				</select>
			</div>
			<div class="mb-3">
				<label for="motasanpham" class="form-label">Mô tả sản phẩm</label> <input
					type="tel" class="form-control" id="motasanpham" name="motasanpham">
			</div>
			<hr />
			<input class="btn btn-primary form-control" type="submit"
				value="Thêm sản phẩm" name="submit" id="submit" />
		</form>
	</div>
</body>
</html>