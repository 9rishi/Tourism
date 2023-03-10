package com.rishi.tourist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rishi.tourist.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
