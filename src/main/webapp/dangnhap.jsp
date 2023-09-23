<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
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
<style>
		body {
			font-family: Arial, sans-serif;
		}

		.container {
			margin-top: 100px;
		}

		.container-fluid {
			margin: 20px;
		}

		h1 {
			color: #333;
		}

		.error-message {
			color: red;
		}

		.taikhoan, .matkhau, .dangnhap {
			padding: 10px;
		}

		h5 {
			margin: 0;
		}

		input[type="text"],
		input[type="password"] {
			padding: 8px;
			border: 1px solid #ccc;
			border-radius: 4px;
			width: 60%;
			box-sizing: border-box;
		}

		button {
			padding: 8px 16px;
			background-color: #007bff;
			color: #fff;
			border: none;
			border-radius: 4px;
			cursor: pointer;
		}

		button:hover {
			background-color: #0056b3;
		}

		.text-center {
			text-align: center;
		}

		.new-account-link {
			display: block;
			text-align: center;
			margin-top: 10px;
			color: #007bff;
		}
</style>
</head>
<body>
<form action="dang-nhap"  method="post">
	<div class="container" style="margin-top: 100px">
			<div class="row">
				<div class="container-fluid text-center" style="margin: 20px">
					<h1>ĐĂNG NHẬP</h1>
				</div>
				<%
				String baoLoi = request.getAttribute("baoLoi")+"";
				if(baoLoi.equals("null")){
					baoLoi = "";
				}
			    %>
			<div class="text-center"><span style="color: red"><%=baoLoi %></span></div>
				<!--tai khoan -->
				<div class="row taikhoan" style="padding: 10px">
					<div class="col-lg-3"></div>
					<div class="col-lg-2">
						<h5>Tài Khoản</h5>
					</div>
					<div class="col-lg-6" >
						<input type="text" id="tenDangNhap" name="tenDangNhap" style="padding-right: 60px">
					</div>
				</div>


				<!--mat khau -->
				<div class="row matkhau" style="padding: 10px">
					<div class="col-lg-3"></div>
					<div class="col-lg-2">
						<h5>Mật Khẩu</h5>
					</div>
					<div class="col-lg-6">
						<input type="password" id="matKhau" name="matKhau" style="padding-right: 60px">
					</div>
				</div>


				<!-- dang ky dang nhap -->
				<div class="row dangnhap" style="padding: 10px">
					<div class="col-lg-5"></div>
					<div class="col-lg-7">
						<button type="submit" class="btn btn-primary">ĐĂNG NHẬP</button>
					</div>
				</div>
				<a href="dangky.jsp" class="text-center">Đăng ký tài khoản mới</a>
			</div>
	</div>
</form>
</body>
</html>