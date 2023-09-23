package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.feedbackDAO;
import dao.sanPhamDAO;

/**
 * Servlet implementation class xoaphanhoi
 */
@WebServlet("/xoaphanhoi")
public class xoaphanhoi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public xoaphanhoi() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @throws IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String user_id = request.getParameter("user_id");
		user_id = (user_id.equals("null")) ? "null" : user_id;
		int uid = Integer.parseInt(user_id);
		String sanpham_id = request.getParameter("sanpham_id");
		sanpham_id = (sanpham_id.equals("null")) ? "null" : sanpham_id;
		int spid = Integer.parseInt(sanpham_id);
		feedbackDAO phd = new feedbackDAO();
		phd.delete(spid, uid);
		String url = "/quanlyphanhoi.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
