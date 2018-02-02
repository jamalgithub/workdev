package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.in28minutes.jpa.hibernate.demo.entity.Course;

@RepositoryRestResource(path="courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

	//*************** Query Creation from Method Name  *********************
	
	/**
	 * Finds Course by using the name and the id as a search criteria.
	 * @param name
	 * @param id
	 * @return List<Course>
	 */
	List<Course> findByNameAndId(String name, Long id);

	/**
	 * Finds Course by using the name as a search criteria.
	 * @param name
	 * @return
	 */
	List<Course> findByName(String name);

	List<Course> countByName(String name);

	// Enabling static ORDER BY for a query
	List<Course> findByNameOrderByIdDesc(String name);

	/**
	 * Delette Course by using the name.
	 * @param name
	 * @return
	 */
	List<Course> deleteByName(String name);
	
	// Enables the distinct flag for the query
	List<Course> findDistinctCourseByNameOrId(String name, Long id);	
	List<Course> findCourseDistinctByNameOrId(String name, Long id);
	
	//*************** End Query Creation from Method Name  *****************

	//*************** JPA Named Queries **********************************
	
	@Query("Select  c  From Course c where name like '%100 Steps'")
	List<Course> courseWith100StepsInName();

	@Query(value = "Select  *  From Course c where name like '%100 Steps'", nativeQuery = true)
	List<Course> courseWith100StepsInNameUsingNativeQuery();

	@Query(name = "query_get_100_Step_courses")
	List<Course> courseWith100StepsInNameUsingNamedQuery();
	
	//*************** End JPA Named Queries **********************************
}