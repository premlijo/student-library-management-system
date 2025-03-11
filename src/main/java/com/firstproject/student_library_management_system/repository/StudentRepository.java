package com.firstproject.student_library_management_system.repository;

import com.firstproject.student_library_management_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Student findByEmail(String inputEmail);

    public List<Student> findBySemester(String inputSem);

    public List<Student> findBySemesterAndDept(String inputSemester, String inputDept);

    public List<Student> findBySemesterOrDeptOrEmail(String inputSemester, String inputDept, String inputEmail);

    @Query(nativeQuery = true, value = "SELECT * FROM student where email=:inputEmail")
    public List<Student> getStudentsByEmail(String inputEmail);

    @Query(nativeQuery = true, value = "SELECT * FROM student where semester=:inputSem")
    public List<Student> getStudentsBySem(String inputSem);

    @Query(nativeQuery = true, value = "SELECT * FROM student where semester=:inputSemester and dept=:inputDept")
    public List<Student> getStudentsBySemAndDept(String inputSemester, String inputDept);

    @Query(nativeQuery = true, value = "SELECT * FROM student where semester=:inputSemester or dept=:inputDept or email=:inputEmail")
    public List<Student> getStudentsBySemesterOrDeptOrEmail(String inputSemester, String inputDept, String inputEmail);
}
