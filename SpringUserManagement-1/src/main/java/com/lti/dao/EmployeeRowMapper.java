package com.lti.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.lti.model.Users;

public class EmployeeRowMapper implements RowMapper<Users> {

	

	public Users mapRow(ResultSet rs, int arg1) throws SQLException {
		Users user = new Users();
		user.setFirstname(rs.getString("FIRSTNAME"));
		user.setLastname(rs.getString("LASTNAME"));
		user.setUsername(rs.getString("USERNAME"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setMobilenumber(rs.getString("MOBILENUMBER"));
		return user;
	}

}
