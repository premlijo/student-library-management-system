package com.firstproject.student_library_management_system.controller;

import com.firstproject.student_library_management_system.model.Student;
import com.firstproject.student_library_management_system.requestdto.StudentRequestDto;
import com.firstproject.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<?>  saveStudent(@RequestBody StudentRequestDto studentRequestDto){
        try {
            String response = studentService.saveStudent(studentRequestDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable int id){
        try {
            Student student = studentService.findStudentById(id);
            return ResponseEntity.ok(student);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllStudents(){
        try {
            List<Student> studentList = studentService.findAllStudents();
            return ResponseEntity.ok(studentList);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable int id){
        try {
            String response = studentService.deleteStudentById(id);
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody StudentRequestDto studentRequestDto){
        try {
            String response = studentService.updateStudent(id, studentRequestDto);
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @GetMapping("/count")
    public ResponseEntity<?> countStudents() {
        try {
            String response = studentService.countStudent();
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @GetMapping("/findAllByPage")
    public ResponseEntity<?> findStudentByPage(@RequestParam int pageNo, @RequestParam int pageSize){
        try {
            List<Student> studentList = studentService.findStudentByPage(pageNo, pageSize);
            return ResponseEntity.ok(studentList);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @GetMapping("/findAllByPageAndSort")
    public ResponseEntity<?> findStudentByPageAndSort(@RequestParam int pageNo, @RequestParam int pageSize){
        try {
            List<Student> studentList = studentService.findStudentByPageAndSort(pageNo, pageSize);
            return ResponseEntity.ok(studentList);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<?> findByEmail(@RequestParam String inputEmail){
        try {
            Student student = studentService.findByEmail(inputEmail);
            return ResponseEntity.ok(student);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @GetMapping("/findBySemester")
    public ResponseEntity<?> findBySemester(@RequestParam String inputSem){
        try {
            List<Student> studentList = studentService.findBySemester(inputSem);
            return ResponseEntity.ok(studentList);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @GetMapping("/findBySemesterAndDept")
    public ResponseEntity<?> findBySemesterAndDept(@RequestParam String inputSemester,@RequestParam String inputDept){
        try {
            List<Student> studentList = studentService.findBySemesterAndDept(inputSemester, inputDept);
            return ResponseEntity.ok(studentList);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @GetMapping("/findBySemesterOrDeptOrEmail")
    public ResponseEntity<?> findBySemesterOrDeptOrEmail(@RequestParam String inputSemester,@RequestParam String inputDept,@RequestParam String inputEmail){
        try {
            List<Student> studentList = studentService.findBySemesterOrDeptOrEmail(inputSemester, inputDept, inputEmail);
            return ResponseEntity.ok(studentList);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @GetMapping("/getStudentsByEmail")
    public ResponseEntity<?> getStudentsByEmail(String inputEmail){
        try {
            List<Student> studentList = studentService.getStudentsByEmail(inputEmail);
            return ResponseEntity.ok(studentList);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @GetMapping("/getStudentsBySem")
    public ResponseEntity<?> getStudentsBySem(String inputSem){
        try {
            List<Student> studentList = studentService.getStudentsBySem(inputSem);
            return ResponseEntity.ok(studentList);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @GetMapping("/getStudentsBySemAndDept")
    public ResponseEntity<?> getStudentsBySemAndDept(String inputSemester, String inputDept){
        try {
            List<Student> studentList = studentService.getStudentsBySemAndDept(inputSemester, inputDept);
            return ResponseEntity.ok(studentList);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @GetMapping("/getStudentsBySemesterOrDeptOrEmail")
    public ResponseEntity<?> getStudentsBySemesterOrDeptOrEmail(String inputSemester, String inputDept, String inputEmail){
        try {
            List<Student> studentList = studentService.getStudentsBySemesterOrDeptOrEmail(inputSemester, inputDept, inputEmail);
            return ResponseEntity.ok(studentList);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

}
