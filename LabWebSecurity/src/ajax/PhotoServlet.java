package ajax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(
		urlPatterns={"/pages/photo.view"},
		initParams={
				@WebInitParam(
						name="defaultFile",
						value="/css/x.jpg"
				)
		}
)
public class PhotoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String photoid = request.getParameter("photoid");
//		
		byte[] photo = null;
		if(photoid!=null && photoid.trim().length()!=0) {
			photo = this.readDetailTable(photoid);
		}
		if(photo==null || photo.length==0) {
			photo = defaultPhoto;
		}
		response.setContentType("image/jpeg");
		OutputStream out = response.getOutputStream();
		out.write(photo);
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	private byte[] defaultPhoto = null;
	@Override
	public void init() throws ServletException {
		String defaultFile = this.getInitParameter("defaultFile");
		ServletContext application = this.getServletContext();
		String path = application.getRealPath(defaultFile);
		defaultPhoto = this.readBackupFile(path);
		if(defaultPhoto==null || defaultPhoto.length==0) {
			throw new RuntimeException("No default file exist");
		}
	}
	private byte[] readBackupFile(String path) {
		byte[] result = null;
		
		FileInputStream fis = null;
		try {
			File input = new File(path);
			result = new byte[(int) input.length()];
			fis = new FileInputStream(input);
			fis.read(result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	private byte[] readDetailTable(String photoid) {
		byte[] result = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/xxx");
			
			conn = ds.getConnection();
			stmt = conn.prepareStatement(
					"select * from detail where photoid = ?");
			stmt.setString(1, photoid);
			rset = stmt.executeQuery();
			if(rset.next()) {
				result = rset.getBytes("photo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
