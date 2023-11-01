package com.demoSpring.services;

import com.demoSpring.databases.StudentRepository;
import com.demoSpring.modules.DataStatus;
import com.demoSpring.modules.ResponseStatus;
import com.demoSpring.modules.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private  final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<DataStatus> getStudents(){
        return List.of(
                new DataStatus(
                        "Successful",
                        studentRepository.findAll()
                )
        );
    }

    public List<ResponseStatus> addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()){
//            throw new IllegalStateException("email taken");
            return List.of(
                    new ResponseStatus(
                            "Failure",
                            "Email taken"
                    )
            );
        }
        studentRepository.save(student);
        return List.of(
                new ResponseStatus(
                        "Successful",
                        "Create Student Successful"
                )
        );
    }

    public List<ResponseStatus> deleteStudent(Long studentId) {
        studentRepository.findById(studentId);
        boolean exist = studentRepository.existsById(studentId);

        if (!exist) {
//            throw new IllegalStateException("student with id " + studentId + " does not exists");
            return List.of(
                    new ResponseStatus(
                            "Failure",
                            "Student with id " + studentId + " does not exists"
                    )
            );
        }

        studentRepository.deleteById(studentId);
        return List.of(
                new ResponseStatus(
                        "Successful",
                        "Delete Student Successful"
                )
        );
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "student with id " + studentId + " does not exits"
        ));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            student.setEmail(email);
        }
    }
}
