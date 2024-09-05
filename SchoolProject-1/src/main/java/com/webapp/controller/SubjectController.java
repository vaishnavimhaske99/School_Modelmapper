package com.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.webapp.model.Standard;
import com.webapp.model.Subject;
import com.webapp.model.Teacher;
import com.webapp.service.SubjectService;
import com.webapp.student.StandardDTO;
import com.webapp.student.SubjectDTO;
import com.webapp.student.SubjectResponseDTO;
import com.webapp.student.TeacherDTO;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDTO> getSubjectById(@PathVariable Long id) {
        SubjectDTO subjectDTO = subjectService.getSubjectById(id);
        return ResponseEntity.ok(subjectDTO);
    }

    @PostMapping
    public ResponseEntity<SubjectResponseDTO> createSubject(@RequestBody SubjectDTO subjectDTO) {
        Subject savedSubject = subjectService.saveSubject(subjectDTO);
        
        // Convert the savedSubject to SubjectResponseDTO
        SubjectResponseDTO responseDTO = new SubjectResponseDTO();
        responseDTO.setId(savedSubject.getId());
        responseDTO.setName(savedSubject.getName());

        if (savedSubject.getStandard() != null) {
            StandardDTO standardDTO = new StandardDTO();
            standardDTO.setId(savedSubject.getStandard().getId());
            standardDTO.setName(savedSubject.getStandard().getName());
            responseDTO.setStandard(standardDTO);
        }

        if (savedSubject.getTeacher() != null) {
            TeacherDTO teacherDTO = new TeacherDTO();
            teacherDTO.setId(savedSubject.getTeacher().getId());
            teacherDTO.setName(savedSubject.getTeacher().getName());
            responseDTO.setTeacher(teacherDTO);
        }

        return ResponseEntity.ok(responseDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<SubjectDTO> updateSubject(@PathVariable Long id, @RequestBody SubjectDTO subjectDTO) {
        SubjectDTO updatedSubject = subjectService.updateSubject(id, subjectDTO);
        return ResponseEntity.ok(updatedSubject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }
}
