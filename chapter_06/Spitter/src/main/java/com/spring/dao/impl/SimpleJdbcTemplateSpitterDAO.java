package com.spring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.spring.dao.ISpitterDAO;
import com.spring.model.Spitter;

public class SimpleJdbcTemplateSpitterDao implements ISpitterDAO {
	private SimpleJdbcTemplate jdbcTemplate;
	
	private static final String SQL_INSERT_SPITTER = "insert into spitter (username, password, fullname, email, updateByEmail) values (?, ?, ?, ?, ?)";
	private static final String SQL_INSERT_SPITTER_WITH_NAMEDPARAMETER = "insert into spitter (username, password, fullname, email, updateByEmail) values (:username, :password, :fullname, :email, :updateByEmail)";
	private static final String SQL_SELECT_SPITTER_BY_USERNAME = "select id, username, fullname, email from spitter where username = ?";
	
	public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@SuppressWarnings("deprecation")
	public void addSpitter(Spitter spitter) {
		jdbcTemplate.update(SQL_INSERT_SPITTER, 
				spitter.getUsername(), 
				spitter.getPassword(), 
				spitter.getFullName(),
				spitter.getEmail(),	
				spitter.isUpdateByEmail());
	}
	
	@SuppressWarnings("deprecation")
	public void addSpitterWithNamedParameters(Spitter spitter) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", spitter.getUsername());
		params.put("password", spitter.getPassword());
		params.put("fullname", spitter.getFullName());
		params.put("email", spitter.getEmail());
		params.put("updateByEmail", spitter.isUpdateByEmail());
		jdbcTemplate.update(SQL_INSERT_SPITTER_WITH_NAMEDPARAMETER, params);
	}

	@SuppressWarnings("deprecation")
	public Spitter getSpitterByUsername(String username) {
		return jdbcTemplate.queryForObject(SQL_SELECT_SPITTER_BY_USERNAME,
				new RowMapper<Spitter>() {
					public Spitter mapRow(ResultSet rs, int nbRow) throws SQLException {
						Spitter spitter = new Spitter();
						spitter.setId(rs.getLong(1));
						spitter.setUsername(rs.getString(2));
						spitter.setFullName(rs.getString(3));
						spitter.setEmail(rs.getString(4));
						return spitter;
					}
				}, username);
	}
}
