package _04_ShoppingCart.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import _04_ShoppingCart.model.ShoppingCart;

public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
			HttpSession session = request.getSession(false);
			if (session == null) {   // 使用逾時
				request.setAttribute("Errors", "使用逾時，請重新登入");
				RequestDispatcher rd = request.getRequestDispatcher("/_04_ShoppingCart/CheckError.jsp");
				rd.forward(request, response);
				return;
			}			
			ShoppingCart sc = (ShoppingCart) session.getAttribute("ShoppingCart");
			if (sc == null) {
				// 如果找不到購物車(通常是Session逾時)，沒有必要往下執行
				// 導向首頁
				response.sendRedirect(getServletContext().getContextPath() + "/index.jsp"  );
				return;
			}
			// 結帳
			RequestDispatcher rd = request.getRequestDispatcher("OrderConfirm.jsp");
			rd.forward(request, response);
			return;
	}
}