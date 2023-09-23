package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mua
 */
@WebServlet("/mua")
public class mua extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public mua() {
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
		String[] selectedItems = request.getParameterValues("selectedItems");
		String user_id = request.getParameter("user_id");
		request.setAttribute("user_id", user_id);
		System.out.println(user_id);
		ArrayList<Integer> selectedLucValues = new ArrayList<>();
		if (selectedItems != null) {
			for (String selectedItem : selectedItems) {
				Integer luc = Integer.parseInt(selectedItem);
				System.out.println(luc);
				selectedLucValues.add(luc);
			}
		}
		request.setAttribute("selectedLucValues", selectedLucValues);
		String url = "/dangkydonhang.jsp";
		RequestDispatcher r = getServletContext().getRequestDispatcher(url);
		r.forward(request, response);

	}

}
