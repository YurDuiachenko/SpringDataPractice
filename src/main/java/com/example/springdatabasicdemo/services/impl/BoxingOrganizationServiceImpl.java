package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.BoxingOrganizationDto;
import com.example.springdatabasicdemo.dtos.BoxingOrganizationDto;
import com.example.springdatabasicdemo.models.BoxingOrganization;
import com.example.springdatabasicdemo.repositories.BeltRepository;
import com.example.springdatabasicdemo.repositories.BoxerRepository;
import com.example.springdatabasicdemo.repositories.BoxingOrganizationRepository;
import com.example.springdatabasicdemo.repositories.FigureRepository;
import com.example.springdatabasicdemo.services.BoxingOrganizationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoxingOrganizationServiceImpl implements BoxingOrganizationService {

    @Autowired
    private BoxingOrganizationRepository boxingOrganizationRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public BoxingOrganizationDto create(BoxingOrganizationDto boxingOrganizationDto) {
        BoxingOrganization s = modelMapper.map(boxingOrganizationDto, BoxingOrganization.class);
//        if (figure.getGroup().getId() != 0) {
//             g = groupRepository.findById(student.getGroup().getId()).get();
//            s.setGroup(g);
//        }
        return modelMapper.map(boxingOrganizationRepository.save(s), BoxingOrganizationDto.class);
    }

    @Override
    public void destroyById(Long id) {
        boxingOrganizationRepository.deleteById(id);
    }


    @Override
    public void destroy(BoxingOrganizationDto boxingOrganizationDto) {
        boxingOrganizationRepository.deleteById(boxingOrganizationDto.getId());
    }

    @Override
    public Optional<BoxingOrganizationDto> find(Long id) {
        return Optional.ofNullable(modelMapper.map(boxingOrganizationRepository.findById(id), BoxingOrganizationDto.class));
    }

    @Override
    public List<BoxingOrganizationDto> getAll() {
        return boxingOrganizationRepository.findAll().stream().map((s) -> modelMapper.map(s, BoxingOrganizationDto.class)).collect(Collectors.toList());
    }
}
