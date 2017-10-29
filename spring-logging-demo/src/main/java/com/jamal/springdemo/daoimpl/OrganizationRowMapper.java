package com.jamal.springdemo.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jamal.springdemo.domain.Organization;

public class OrganizationRowMapper implements RowMapper<Organization> {

	@Override
	public Organization mapRow(ResultSet rs, int rownum) throws SQLException {
		Organization org = new Organization();
		
		org.setId(rs.getInt("id"));
		org.setCompanyName(rs.getString("company_name"));
		org.setYearOfIncorporation(rs.getInt("year_of_incorporation"));
		org.setPostalCode(rs.getString("postal_code"));
		org.setEmployeeCount(rs.getInt("employee_count"));
		org.setSlogan(rs.getString("slogan"));
		
		return org;
	}

}
