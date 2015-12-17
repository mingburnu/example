package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductBean;
import model.ProductService;

@WebServlet(
		urlPatterns={"/pages/product.view"}
)
public class ProductIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getContextPath()+",  method="+request.getMethod());
		this.textJson(request, response);
	}
	private void textJson(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		StringBuilder output = new StringBuilder();
		String temp = request.getParameter("id");
		int id = 0;
		if(temp==null || temp.trim().length()==0) {
			output.append("ID是必要欄位");
		} else {
			id = ProductBean.convertInt(temp);
			if(id==-1000) {
				output.append("ID必需是數字");
			}
		}
		if(output!=null && output.length()!=0) {
			JsonObject obj = Json.createObjectBuilder()
				.add("text", output.toString())
				.add("hasMoreData", false).build();
			JsonArray jsonArray = 
					Json.createArrayBuilder().add(obj).build();
			out.write(jsonArray.toString());
			out.close();
			return;
		}
		
		ProductBean bean = new ProductBean();
		bean.setId(id);
		ProductService service = new ProductService();
		List<ProductBean> result = service.select(bean);
		
		JsonArrayBuilder builder = Json.createArrayBuilder();
		if(result==null || result.isEmpty()) {
			JsonObject obj = Json.createObjectBuilder()
					.add("text", "ID不存在")
					.add("hasMoreData", false).build();
			builder.add(obj);
		} else {
			JsonObject obj1 = Json.createObjectBuilder()
					.add("text", "ID存在")
					.add("hasMoreData", true).build();
			builder.add(obj1);

			ProductBean data = result.get(0);
			JsonObject obj2 = Json.createObjectBuilder()
					.add("id", data.getId())
					.add("name", data.getName())
					.add("price", data.getPrice())
					.add("make", data.getMake().toString())
					.add("expire", data.getExpire()).build();
			builder.add(obj2);
		}
		
		out.write(builder.build().toString());
		out.close();
		return;
	}
}
