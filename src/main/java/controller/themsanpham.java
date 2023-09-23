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
import dao.hinhAnhDAO;
import dao.sanPhamDAO;
import dao.userDAO;
import model.anh;
import model.danhMuc;
import model.role;
import model.sanPham;
import model.user;

/**
 * Servlet implementation class themsanpham
 */
@WebServlet("/themsanpham")
public class themsanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public themsanpham() {
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
		String tieude = request.getParameter("tieude");
		String danhmuc = request.getParameter("danhmuc");
		int danhmuc_id = Integer.parseInt(danhmuc);
		danhMucDAO1 dmd = new danhMucDAO1();
		danhMuc dm = dmd.sellectByid(danhmuc_id);
		String gia = request.getParameter("gia");
		int g = Integer.parseInt(gia);
		String giaban = request.getParameter("giaban");
		int gb = Integer.parseInt(giaban);
		String giagoc = request.getParameter("giagoc");
		int gg = Integer.parseInt(giagoc);
		String hinhanh = request.getParameter("hinhanh");
		String hinhanh2="img/product/"+hinhanh;
		Random rd = new Random();
		int anh_id=(int) (System.currentTimeMillis() + rd.nextInt(1000));
		hinhAnhDAO had = new hinhAnhDAO();
		anh anh= new anh(anh_id, hinhanh2);
		had.insert(anh);
		anh a = had.sellectByid(anh_id);
		String motasanpham = request.getParameter("motasanpham");
		int masanpham = (int) (System.currentTimeMillis() + rd.nextInt(1000));
		sanPham sp = new sanPham(masanpham, dm, tieude, g, gb, gg, a, motasanpham);
		sanPhamDAO spd = new sanPhamDAO();
		spd.insert(sp);
		String url = "/quanlysanpham.jsp";

		RequestDispatcher rdd = getServletContext().getRequestDispatcher(url);
		rdd.forward(request, response);
	}

}
