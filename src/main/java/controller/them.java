package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.danhMucDAO1;
import model.danhMuc;

/**
 * Servlet implementation class them
 */
@WebServlet("/them")
public class them extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public them() {
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
		String sp_id = request.getParameter("themdanhmuc");
		Random rd = new Random();
		int madanhmuc = (int) (System.currentTimeMillis() + rd.nextInt(1000));
		danhMuc dm = new danhMuc(madanhmuc, sp_id);
		danhMucDAO1 dmd = new danhMucDAO1();
		dmd.insert(dm);
		String url = "/quanlydanhmuc.jsp";
		RequestDispatcher r = getServletContext().getRequestDispatcher(url);
		r.forward(request, response);
	}

}
