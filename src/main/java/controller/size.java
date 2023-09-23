package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.khoDAO;
import dao.sanPhamDAO;
import model.kho;
import model.sanPham;

/**
 * Servlet implementation class size
 */
@WebServlet("/size")
public class size extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public size() {
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

		String sp_id = request.getParameter("sp");
		sp_id = (sp_id.equals("null")) ? "1" : sp_id;
		int sp = Integer.parseInt(sp_id);
		String size_id = request.getParameter("size");
		size_id = (size_id.equals("null")) ? "1" : size_id;
		int size = Integer.parseInt(size_id);
		System.out.println(size);
		khoDAO kd = new khoDAO();
		kho k = kd.sellectkho(sp, size);
		request.setAttribute("kho", k.getSoLuong());
		request.setAttribute("data", sp_id);
		request.setAttribute("size", size);
		String url = "/chitiet.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
