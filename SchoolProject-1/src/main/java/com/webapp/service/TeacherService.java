package com.webapp.service;

import com.webapp.model.Teacher;
import com.webapp.repository.TeacherRepository;
import com.webapp.student.TeacherDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TeacherDTO getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        return modelMapper.map(teacher, TeacherDTO.class);
    }

    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = modelMapper.map(teacherDTO, Teacher.class);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return modelMapper.map(savedTeacher, TeacherDTO.class);
    }

    public TeacherDTO updateTeacher(Long id, TeacherDTO teacherDTO) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        modelMapper.map(teacherDTO, teacher);
        Teacher updatedTeacher = teacherRepository.save(teacher);
        return modelMapper.map(updatedTeacher, TeacherDTO.class);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
