package com.jamal.springdemo.dao;

import java.util.List;

import javax.sql.DataSource;

import com.jamal.springdemo.domain.Organization;

public interface OrganizationDao {

	/**
	 * Set the data-source that will be required to create a connection to the database
	 * @param ds DataSource
	 */
	public void setDataSource(DataSource ds);
	
	/**
	 * Create a record in the organization table
	 * @param org Organization
	 * @return boolean
	 */
	public boolean create(Organization org);
	
	/**
	 * Retrieve a single organization
	 * @param id Integer
	 * @return Organization
	 */
	public Organization getOrganization(Integer id);
	
	/**
	 * Retrieve all organization from the table
	 * @return List of Organization
	 */
	public List<Organization> getAllOrganizations();
	
	/**
	 * Delete a specific organazation from the table
	 * @param org Organization
	 * @return boolean
	 */
	public boolean delete(Organization org);
	
	/**
	 * Update an existing organazation
	 * @param org Organization
	 * @return boolean
	 */
	public boolean update(Organization org);
	
	public void cleanup();
}
