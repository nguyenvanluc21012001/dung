package controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import dao.userDAO;
import model.role;
import model.user;

/**
 * Servlet implementation class DangKy
 */
@WebServlet(name = "/dang-ky", urlPatterns = { "/dang-ky" })
public class DangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangKy() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		String hoVaTen = request.getParameter("hoVaTen");
		String email = request.getParameter("email");
		String diaChiKhachHang = request.getParameter("diaChiKhachHang");
		String dienThoai = request.getParameter("dienThoai");
		String vaitro = request.getParameter("vaitro");
		role role;
		if (vaitro.equals("nhân viên")) {
			role = new role(1, "nhân viên");
		} else {
			role = new role(2, "khách hàng");
		}

		request.setAttribute("tenDangNhap", tenDangNhap);
		request.setAttribute("hoVaTen", hoVaTen);
		request.setAttribute("email", email);
		request.setAttribute("diaChiKhachHang", diaChiKhachHang);
		request.setAttribute("dienThoai", dienThoai);

		String url = "";
		String baoLoi = "";
		userDAO userDAO = new userDAO();

		if (userDAO.kiemTraTenDangNhap(tenDangNhap)) {
			baoLoi += "Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác.<br/>";
		}
		request.setAttribute("baoLoi", baoLoi);

		if (baoLoi.length() > 0) {
			url = "/dangky.jsp";
		} else {
			Random rd = new Random();
			int maUser = (int) (System.currentTimeMillis() + rd.nextInt(1000));
			user user = new user(maUser, tenDangNhap, matKhau, hoVaTen, email, dienThoai, diaChiKhachHang, role);
			userDAO.insert(user);
			url = "/dangnhap.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
