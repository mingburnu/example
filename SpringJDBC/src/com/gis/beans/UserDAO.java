package com.gis.beans;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public User getUserById(int id) {
		List rows = jdbcTemplate.queryForList("SELECT * FROM users WHERE id=?",
				id);
		Iterator it = rows.iterator();
		if (it.hasNext()) {
			Map userMap = (Map) it.next();
			Integer i = new Integer(userMap.get("id").toString());
			String name = userMap.get("name").toString();
			User user = new User();
			user.setId(i);
			user.setName(name);
			return user;
		}
		return null;
	}
	public void  InsertForTest() {
jdbcTemplate.update("INSERT INTO users(id,name) VALUES(?,?)",4,"jad");	
jdbcTemplate.update("INSERT INTO users(id,name) VALUES(?,?)",5,"david");		
	}
}
