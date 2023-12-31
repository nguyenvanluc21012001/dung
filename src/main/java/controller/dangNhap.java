package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.userDAO;
import model.role;
import model.user;

/**
 * Servlet implementation class dangNhap
 */
@WebServlet("/dang-nhap")
public class dangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dangNhap() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		userDAO userDAO = new userDAO();
		user user = userDAO.sellectByTaiKhoanMatKhau(tenDangNhap, matKhau);
		String url = "";
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			int vaitro = user.getRole().getRole_id();
			if (vaitro == 1) {
				url = "/quanly.jsp";
			} else {
				url = "/trangchinh.jsp";
			}
		} else {
			request.setAttribute("baoLoi", "Tên đăng nhập hoặc mật khẩu không đúng!");
			url = "/dangnhap.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
