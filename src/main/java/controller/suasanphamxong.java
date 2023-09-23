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
import model.anh;
import model.danhMuc;
import model.sanPham;

/**
 * Servlet implementation class suasanphamxong
 */
@WebServlet("/suasanphamxong")
public class suasanphamxong extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public suasanphamxong() {
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
		String sp_id = request.getParameter("sanpham_id");
		System.out.println(sp_id);
		int sanpham_id = Integer.parseInt(sp_id);
		String tieude = request.getParameter("tieude");
		System.out.println(tieude);
		String danhmuc = request.getParameter("danhmuc");
		System.out.println(danhmuc);
		int danhmuc_id = Integer.parseInt(danhmuc);
		danhMucDAO1 dmd = new danhMucDAO1();
		danhMuc dm = dmd.sellectByid(danhmuc_id);
		String gia = request.getParameter("gia");
		System.out.println(gia);
		int g = Integer.parseInt(gia);
		String giaban = request.getParameter("giaban");
		System.out.println(giaban);
		int gb = Integer.parseInt(giaban);
		String giagoc = request.getParameter("giagoc");
		int gg = Integer.parseInt(giagoc);
		String hinhanh = request.getParameter("hinhanh");
		int hinhanh_id = Integer.parseInt(hinhanh);
		hinhAnhDAO had = new hinhAnhDAO();
		anh a = had.sellectByid(hinhanh_id);
		String motasanpham = request.getParameter("motasanpham");
		sanPhamDAO spd = new sanPhamDAO();
		sanPham sp = new sanPham(sanpham_id, dm, tieude, g, gb, gg, a, motasanpham);
		System.out.println(sp.toString());
		spd.update1(sp);
		String url = "/quanlysanpham.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
