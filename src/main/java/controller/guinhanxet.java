package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.feedbackDAO;
import dao.giohangDAO;
import dao.sanPhamDAO;
import dao.userDAO;
import model.feedBack;
import model.sanPham;
import model.user;

/**
 * Servlet implementation class guinhanxet
 */
@WebServlet("/guinhanxet")
public class guinhanxet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public guinhanxet() {
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
		String user_id = request.getParameter("user_id");
		System.out.println(user_id);
		request.setAttribute("user_id", user_id);
		
		String sanpham_id = request.getParameter("sanpham_id");
		System.out.println(sanpham_id);
		request.setAttribute("data",sanpham_id );
		
		String nhanxet = request.getParameter("nhanxet");
		System.out.println(nhanxet);
		String url = "";
		if (user_id == null) {
			request.setAttribute("candangnhaptaikhoan", "bạn cần đăng nhập tài khoản");
		} else {
			int uid = Integer.parseInt(user_id);
			int sp_id = Integer.parseInt(sanpham_id);
			feedbackDAO fbd= new feedbackDAO();
			userDAO ud= new userDAO();
			user u= ud.sellectByid(uid);
			sanPhamDAO spd= new sanPhamDAO();
			sanPham sp=spd.sellectByid(sp_id);
			feedBack fb = new feedBack(sp, u, "đánh giá sản phẩm", nhanxet);
			fbd.insert(fb);
		}
		
		url = "/chitiet.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
