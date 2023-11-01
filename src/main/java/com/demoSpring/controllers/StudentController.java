package com.demoSpring.controllers;

import com.demoSpring.modules.DataStatus;
import com.demoSpring.modules.ResponseStatus;
import com.demoSpring.services.StudentService;
import com.demoSpring.modules.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<DataStatus> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/")
    public List<ResponseStatus> registerNewStudent(@RequestBody Student student){
        return studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "{studentId}")
    public List<ResponseStatus> deleteStudent(@PathVariable("studentId") Long studentId){
        return studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
        studentService.updateStudent(studentId, name, email);
    }
}
