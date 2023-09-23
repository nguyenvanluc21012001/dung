package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.danhMucDAO1;
import dao.giohangDAO;
import model.danhMuc;

/**
 * Servlet implementation class xoagiohang
 */
@WebServlet("/xoagiohang")
public class xoagiohang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public xoagiohang() {
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

		String sp_id = request.getParameter("sanpham");
		sp_id = (sp_id.equals("null")) ? "null" : sp_id;
		int sp = Integer.parseInt(sp_id);
		String user_id = request.getParameter("user");
		user_id = (user_id.equals("null")) ? "null" : user_id;
		int u = Integer.parseInt(user_id);
		giohangDAO ghd = new giohangDAO();
		ghd.delete(sp, u);
		request.setAttribute("user_id", u);
		String url = "/giohang.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
