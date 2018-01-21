package com.in28minutes.springboot.rest.example.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Student JPA Repository. This is created using Spring Data JpaRepository.
 * @author jamal
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}