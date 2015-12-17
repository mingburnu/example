package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.ContentBean;
import model.ContentDAO;

public class ContentDAOJdbc implements ContentDAO {

	private DataSource dataSource;

	public ContentDAOJdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/xxx");

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String SELECT_BY_TITLE = "select * from GuestBooks where title = ?";

	public ContentBean select(String title) {
		ContentBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT_BY_TITLE);
			stmt.setString(1, title);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new ContentBean();
				result.setTitle(rset.getString("title"));
				result.setContent(rset.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	private static final String SELECT_ALL = "select * from GuestBooks";

	public List<ContentBean> select() {
		List<ContentBean> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();

			result = new ArrayList<ContentBean>();
			while (rset.next()) {
				ContentBean temp = new ContentBean();
				temp.setTitle(rset.getString("title"));
				temp.setContent(rset.getString("content"));
				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	private static final String INSERT = "insert into GuestBooks (title, content) values (?, ?) ";

	public ContentBean insert(ContentBean bean) {
		ContentBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(INSERT);

			stmt.setString(1, bean.getTitle());
			stmt.setString(2, bean.getContent());

			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.select(bean.getTitle());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
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