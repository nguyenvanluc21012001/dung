package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.giohangDAO;

/**
 * Servlet implementation class themvaogiohang
 */
@WebServlet("/themvaogiohang")
public class themvaogiohang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public themvaogiohang() {
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

		String sanpham_id = request.getParameter("sanpham_id");
		request.setAttribute("data", sanpham_id);
		int sp = Integer.parseInt(sanpham_id);

		String user_id = request.getParameter("user_id");
		request.setAttribute("user_id", user_id);

		String soluong = request.getParameter("soluong");
		int sl = Integer.parseInt(soluong);

		String soluongtoida = request.getParameter("soluongtoida");
		int sltd = Integer.parseInt(soluongtoida);
		System.out.println("soluongtoida " + sltd);

		System.out.println(sanpham_id);
		System.out.println(user_id);
		System.out.println(soluong);
		String url = "";
		if (user_id == null) {
			url = "/chitiet.jsp";
			request.setAttribute("candangnhap", "bạn cần đăng nhập tài khoản");
		} else {
			if (sl > sltd) {
				request.setAttribute("soluongtoida", "hiện tại chúng tôi không đủ hàng");
				url = "/chitiet.jsp";
			} else if (sl <= 0) {
				request.setAttribute("soluongtoida", "số lượng ít nhất phải là 1");
				url = "/chitiet.jsp";
			} else {
				int u = Integer.parseInt(user_id);
				giohangDAO ghd = new giohangDAO();
				ghd.insert(sp, u, sl);
				url = "/giohang.jsp";
			}

		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
