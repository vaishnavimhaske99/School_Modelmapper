package com.webapp.service;

import com.webapp.model.Standard;
import com.webapp.model.Subject;
import com.webapp.model.Teacher;
import com.webapp.repository.StandardRepository;
import com.webapp.repository.SubjectRepository;
import com.webapp.repository.TeacherRepository;
import com.webapp.student.SubjectDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StandardRepository standardRepository;
    
    @Autowired
    private TeacherRepository teacherRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    public SubjectDTO getSubjectById(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
        return modelMapper.map(subject, SubjectDTO.class);
    }


    public Subject saveSubject(SubjectDTO subjectDTO) {
        Subject subject = new Subject();
        subject.setName(subjectDTO.getName());

        if (subjectDTO.getStandardId() != null) {
            Standard standard = standardRepository.findById(subjectDTO.getStandardId())
                                                 .orElseThrow();
            subject.setStandard(standard);
        }

        if (subjectDTO.getTeacherId() != null) {
            Teacher teacher = teacherRepository.findById(subjectDTO.getTeacherId())
                                               .orElseThrow();
            subject.setTeacher(teacher);
        }

        return subjectRepository.save(subject);
    }

    public SubjectDTO updateSubject(Long id, SubjectDTO subjectDTO) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
        modelMapper.map(subjectDTO, subject);
        Subject updatedSubject = subjectRepository.save(subject);
        return modelMapper.map(updatedSubject, SubjectDTO.class);
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
