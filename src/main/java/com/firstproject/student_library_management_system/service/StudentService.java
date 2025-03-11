package com.firstproject.student_library_management_system.service;

import com.firstproject.student_library_management_system.converters.StudentConverter;
import com.firstproject.student_library_management_system.enums.CardStatus;
import com.firstproject.student_library_management_system.model.Card;
import com.firstproject.student_library_management_system.model.Student;
import com.firstproject.student_library_management_system.repository.StudentRepository;
import com.firstproject.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public String saveStudent(StudentRequestDto studentRequestDto){

        Student student = StudentConverter.convertStudentRequestDtoIntoStudent(studentRequestDto);

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setStudent(student);
        student.setCard(card);

        studentRepository.save(student);

        return "Student saved successfully";
    }

    public Student findStudentById(int id){

        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent())
        {
            return studentOptional.get();
        }
        else
        {
            throw new RuntimeException("Student not found with id : " + id);
        }
    }

    public List<Student> findAllStudents() {

        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public List<Student> findStudentByPage(int pageNo, int pageSize){
        List<Student> studentList = studentRepository.findAll(PageRequest.of(pageNo,pageSize)).getContent();
        return studentList;
    }

    public List<Student> findStudentByPageAndSort(int pageNo, int pageSize){
        List<Student> studentList = studentRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by("name").ascending())).getContent();
        return studentList;
    }

    public String deleteStudentById(int id){
        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }

    public String updateStudent(int id, StudentRequestDto studentRequestDto){
        Student student = findStudentById(id);
        if(student != null){
            student.setName(studentRequestDto.getName());
            student.setEmail(studentRequestDto.getEmail());
            student.setMobile(studentRequestDto.getMobile());
            student.setAddress(studentRequestDto.getAddress());
            student.setDob(studentRequestDto.getDob());
            student.setGender(studentRequestDto.getGender());
            student.setDept(studentRequestDto.getDept());
            student.setSemester(studentRequestDto.getSemester());

            studentRepository.save(student);
            return "Student updated successfully";
        }
        else{
            throw new RuntimeException("Student cannot be updated with id : " + id);
        }
    }

    public String countStudent() {
        long totalStudent = studentRepository.count();
        return "Total student present are : " + totalStudent;
    }

    public Student findByEmail(String inputEmail){
        Student student = studentRepository.findByEmail(inputEmail);
        return student;
    }

    public List<Student> findBySemester(String inputSem){
        List<Student> studentList = studentRepository.findBySemester(inputSem);
        return studentList;
    }

    public List<Student> findBySemesterAndDept(String inputSemester, String inputDept){
        List<Student> studentList = studentRepository.findBySemesterAndDept(inputSemester,inputDept);
        return studentList;
    }

    public List<Student> findBySemesterOrDeptOrEmail(String inputSemester, String inputDept, String inputEmail){
        List<Student> studentList = studentRepository.findBySemesterOrDeptOrEmail(inputSemester,inputDept,inputEmail);
        return studentList;
    }

    public List<Student> getStudentsByEmail(String inputEmail){
        List<Student> studentList = studentRepository.getStudentsByEmail(inputEmail);
        return studentList;
    }

    public List<Student> getStudentsBySem(String inputSem){
        List<Student> studentList = studentRepository.getStudentsBySem(inputSem);
        return studentList;
    }

    public List<Student> getStudentsBySemAndDept(String inputSemester, String inputDept){
        List<Student> studentList = studentRepository.getStudentsBySemAndDept(inputSemester,inputDept);
        return studentList;
    }

    public List<Student> getStudentsBySemesterOrDeptOrEmail(String inputSemester, String inputDept, String inputEmail){
        List<Student> studentList = studentRepository.getStudentsBySemesterOrDeptOrEmail(inputSemester,inputDept, inputEmail);
        return studentList;
    }
}
