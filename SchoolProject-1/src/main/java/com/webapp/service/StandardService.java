package com.webapp.service;

import com.webapp.model.Standard;
import com.webapp.repository.StandardRepository;
import com.webapp.student.StandardDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandardService {

    @Autowired
    private StandardRepository standardRepository;

    @Autowired
    private ModelMapper modelMapper;

    public StandardDTO getStandardById(Long id) {
        Standard standard = standardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Standard not found"));
        return modelMapper.map(standard, StandardDTO.class);
    }

    public StandardDTO createStandard(StandardDTO standardDTO) {
        Standard standard = modelMapper.map(standardDTO, Standard.class);
        Standard savedStandard = standardRepository.save(standard);
        return modelMapper.map(savedStandard, StandardDTO.class);
    }

    public StandardDTO updateStandard(Long id, StandardDTO standardDTO) {
        Standard standard = standardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Standard not found"));
        modelMapper.map(standardDTO, standard);
        Standard updatedStandard = standardRepository.save(standard);
        return modelMapper.map(updatedStandard, StandardDTO.class);
    }

    public void deleteStandard(Long id) {
        standardRepository.deleteById(id);
    }
}
