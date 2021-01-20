package com.students.resource;

import com.students.repository.StudentRepository;
import  com.students.model.Students;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("students/db")
public class StudentsDB {
    private StudentRepository studentRepository;

    public StudentsDB(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/Students")
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Students> getStudentById(@PathVariable(value = "id")
                                                               Integer id) throws ResourceNotFoundException {
        Students student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No student found!" + id));
        return ResponseEntity.ok().body(student);
    }


//    @GetMapping("{niveau}")
//    public List<Students> GetStudentsByLevel(@PathVariable("niveau") String niveau) {
//        List<Students> All;
//        List<Students> Some = new ArrayList<>();
//        All = getAllStudents();
//        for (Students students : All) {
//            if (students.getNiveau() == niveau)
//                Some.add(students);
//        }
//        return(Some);
//    }

    @PostMapping("/students")
    public Students createStudent(@Valid @RequestBody Students student) {
        return studentRepository.save(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Students> updateStudent(@PathVariable(value = "id") Integer id ,
                                                 @Valid @RequestBody Students studentInfo) throws ResourceNotFoundException {
        Students student = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No student for this id" + id));

        student.setPrenom(studentInfo.getPrenom());
        student.setNom(studentInfo.getNom());
        student.setNiveau(studentInfo.getNiveau());
        student.setMoyenne(studentInfo.getMoyenne());
        student.setAbscence(studentInfo.getAbscence());

        final Students updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/students/{id}")
    public Map<String, Boolean> deleteStudent(@PathVariable Integer id) throws ResourceNotFoundException {
        Students student = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No student found for " + id));
        studentRepository.delete(student);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }






}


