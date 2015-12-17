package com.lcpan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/GetBooks")
public class GetBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;	
              
	public void init() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String connUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=android";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // end of init()
	
	public void destroy() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	private static final String GET_ALL =
			"SELECT title, author, publisher FROM book";		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		String action = request.getParameter("action");
		List<String> cols = new ArrayList<String>();
		try {
			String qryStmt = null;
//			if (action.equals("GetAll")) {
				qryStmt = GET_ALL;
//			} 
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			ResultSet rs = stmt.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			for(int i = 1; i <= count; i++) {
				cols.add(rsmd.getColumnLabel(i));
			}
			
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObj;
			while (rs.next()) {
				jsonObj = new JSONObject();
				jsonObj.put(cols.get(0), rs.getString(1));
				jsonObj.put(cols.get(1), rs.getString(2));
				jsonObj.put(cols.get(2), rs.getString(3));
				jsonArray.put(jsonObj);
			}
			stmt.close();
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(jsonArray.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	} // end of doGet()
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
		 doGet(request, response);
	} // end of doPost()
} // end of class GetBooks
