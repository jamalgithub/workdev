package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Table(name ="CourseDetails")
@NamedQueries(value = {
		@NamedQuery(name = "query_get_all_courses", query = "Select  c  From Course c"),
		@NamedQuery(name = "query_get_all_courses_join_fetch", query = "Select  c  From Course c JOIN FETCH c.students s"),
		@NamedQuery(name = "query_get_100_Step_courses", query = "Select  c  From Course c where name like '%100 Steps'")
		})
@Cacheable
//Hibernate will execute this native SQL query instead of the default SQL DELETE statement (when we will delete this entity).
@SQLDelete(sql="update course set is_deleted=true where id=?")
//we don't want to retrieve the deleted rows, we want retrieve the active ones witch have is_deleted = false
//It allows to define an SQL snippet which Hibernate adds to the WHERE clause of all queries instead to exclude the deleted records from the query results
@Where(clause="is_deleted = false")
public class Course {

	private static Logger LOGGER = LoggerFactory.getLogger(Course.class);
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;
	
	//***ToMany : dehault is Lazy fetching.
	//mappedBy : the name of the property(the second side of the relationship) in the entity that owns the relationship.
	@OneToMany(mappedBy="course")
	private List<Review> reviews = new ArrayList<Review>();
	
	@ManyToMany(mappedBy="courses")
	@JsonIgnore
	private List<Student> students = new ArrayList<>();
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;
	
	
	/**
	 * A soft delete performs an update to mark a record as deleted instead of removing it from the database table.
	 * Common ways to model a soft delete are:
	 * - a boolean that indicates if the record is active or deleted,
	 * - an Enumerated which models the state of the record,
	 * - a timestamp that stores the date and time when the soft delete was performed.
	 */
	private boolean isDeleted;
	
	/**
	 * When you delete this entity, the database record gets updated and all queries use the new state value as soon as Hibernate executes the SQL statement.<br>
	 * but Hibernate doesn’t update the state property of this entity in the current session(cache).
	 * So the state property of this entity witch exist in the current session is outdated.<br>
	 * The easiest way to update the attribute is to use a lifecycle callback:
	 * tells Hibernate to call this method before it performs the remove operation
	 */
	@PreRemove //@PrePersist, @PreUpdate, @PostRemove, @PostPersist, @PostUpdate, @PostLoad
	private void preRemove(){
		LOGGER.info("Setting isDeleted to True");
		this.isDeleted = true;
	}
	
	protected Course() {
	}

	public Course(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	@Override
	public String toString() {
		return String.format("Course[%s]", name);
	}
}