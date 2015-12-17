package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductBean;
import model.ProductService;

public class ProductServlet extends HttpServlet {
	private ProductService service = new ProductService();
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//接收資料
		String col1 = request.getParameter("id");
		String name = request.getParameter("name");
		String col3 = request.getParameter("price");
		String col4 = request.getParameter("make");
		String col5 = request.getParameter("expire");
		String prodaction = request.getParameter("prodaction");
		
//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errorMsgs", errors);
		
		if(prodaction!=null) {
			if(prodaction.equals("Insert") || prodaction.equals("Update") || prodaction.equals("Delete")) {
				if(col1==null || col1.trim().length()==0) {
					errors.put("id", "Please enter Id for "+prodaction);
				}
			}
		}
		
//轉換資料
		int id = 0;
		if(col1!=null && col1.trim().length()!=0) {
			id = ProductBean.convertInt(col1);
			if(id==-1000) {
				errors.put("id", "Id must be an integer");
			}
		}
		double price = 0;
		if(col3!=null && col3.trim().length()!=0) {
			price = ProductBean.convertDouble(col3);
			if(price==-1000) {
				errors.put("price", "Price must be a number");
			}
		}
		java.util.Date make = null;
		if(col4!=null && col4.trim().length()!=0) {
			make = ProductBean.convertDate(col4);
			if(make.equals(new java.util.Date(0))) {
				errors.put("make", "Make must be a date of YYYY-MM-DD");
			}
		}
		int expire = 0;
		if(col5!=null && col5.trim().length()!=0) {
			expire = ProductBean.convertInt(col5);
			if(expire==-1000) {
				errors.put("expire", "Expire must be an integer");
			}
		}
		if(errors!=null && !errors.isEmpty()) {
			request.getRequestDispatcher(
					"/pages/product.jsp").forward(request, response);
			return;
		}
		
//呼叫Model、根據Model執行結果導向View
		ProductBean bean = new ProductBean();
		bean.setId(id);
		bean.setName(name);
		bean.setPrice(price);
		bean.setMake(make);
		bean.setExpire(expire);
		
		if(prodaction!=null && prodaction.equals("Select")) {
			List<ProductBean> result = service.select(bean);
			request.setAttribute("select", result);
			request.getRequestDispatcher(
					"/pages/display.jsp").forward(request, response);
			
		} else if(prodaction!=null && prodaction.equals("Insert")) {
			ProductBean result = service.insert(bean);
			if(result!=null) {
				request.setAttribute("insert", result);
			} else {
				errors.put("action", "Insert fail");
			}
			request.getRequestDispatcher(
					"/pages/product.jsp").forward(request, response);
		} else if(prodaction!=null && prodaction.equals("Update")) {
			ProductBean result = service.update(bean);
			if(result!=null) {
				request.setAttribute("update", result);
			} else {
				errors.put("action", "Update fail");
			}
			request.getRequestDispatcher(
					"/pages/product.jsp").forward(request, response);
			
		} else if(prodaction!=null && prodaction.equals("Delete")) {
			boolean result = service.delete(bean);
			if(result) {
				errors.put("action", "Delete Success");
			} else {
				errors.put("action", "Delete fail");
			}
			request.getRequestDispatcher(
					"/pages/product.jsp").forward(request, response);
		} else {
			errors.put("action", "Unknown Action : "+prodaction);
			request.getRequestDispatcher(
					"/pages/product.jsp").forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
