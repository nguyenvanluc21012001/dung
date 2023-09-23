package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.chiTietDonHangDAO;
import dao.donHangDAO;
import dao.giohangDAO;
import dao.userDAO;
import model.chiTietDonHang;
import model.donHang;
import model.gioHang;
import model.user;

/**
 * Servlet implementation class dangkydonhang
 */
@WebServlet("/dangkydonhang")
public class dangkydonhang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dangkydonhang() {
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
		int uid = Integer.parseInt(user_id);
		request.setAttribute("user_id", uid);
		userDAO ud = new userDAO();
		user u = ud.sellectByid(uid);
		String[] List = request.getParameterValues("listParam");
		ArrayList<Integer> selectedLucValues = new ArrayList<>();
		if (List != null) {
			for (String selectedItem : List) {
				Integer luc = Integer.parseInt(selectedItem);
				System.out.println(luc);
				selectedLucValues.add(luc);
			}
		}
		String ten = request.getParameter("ten");
		String email = request.getParameter("email");
		String sdt = request.getParameter("sdt");
		String diachi = request.getParameter("diachi");
		Random rd = new Random();
		int madonhang = (int) (System.currentTimeMillis() + rd.nextInt(1000));
		LocalDateTime currentTime = LocalDateTime.now();
		donHang dh = new donHang(madonhang, u, ten, email, sdt, diachi, currentTime);
		dh.toString();
		donHangDAO dhd = new donHangDAO();
		dhd.insert(dh);
		donHang donhang = dhd.sellectByid(madonhang);
		giohangDAO ghd = new giohangDAO();
		ArrayList<gioHang> listgiohang = new ArrayList<>();
		listgiohang = ghd.sellectAllById(uid);
		gioHang[] gh = new gioHang[100];
		int i = 0;
		for (gioHang element : listgiohang) {
			gh[i] = element;
			i++;
		}
		chiTietDonHangDAO ctdhd = new chiTietDonHangDAO();
		for (int luc = 0; luc < listgiohang.size(); luc++) {
			if (selectedLucValues.contains(luc)) {
				chiTietDonHang ctdh = new chiTietDonHang(donhang, gh[luc].getSanPham(), gh[luc].getSoLuong());
				ctdhd.insert(ctdh);
			}
		}
		request.setAttribute("donhang_id", madonhang);
		String url = "/xacnhandonhang.jsp";
		RequestDispatcher r = getServletContext().getRequestDispatcher(url);
		r.forward(request, response);

	}

}
