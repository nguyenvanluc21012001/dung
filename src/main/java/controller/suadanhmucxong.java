package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.danhMucDAO1;
import model.danhMuc;

/**
 * Servlet implementation class suadanhmucxong
 */
@WebServlet("/suadanhmucxong")
public class suadanhmucxong extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public suadanhmucxong() {
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

		String dm_id = request.getParameter("danhmuc_id");
		dm_id = (dm_id.equals("null")) ? "null" : dm_id;
		int dm = Integer.parseInt(dm_id);
		String tendanhmuc = request.getParameter("suadanhmuc");
		tendanhmuc = (tendanhmuc.equals("null")) ? "null" : tendanhmuc;
		danhMucDAO1 dmd = new danhMucDAO1();
		danhMuc danhmuc = new danhMuc(dm, tendanhmuc);
		dmd.update(danhmuc);
		String url = "/quanlydanhmuc.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
